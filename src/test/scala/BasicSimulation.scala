
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}

import scala.concurrent.duration._
import scala.language.postfixOps
import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder


class BasicSimulation extends Simulation {
  val baseUrl = "https://reqres.in/api/"
  val httpProtocol: HttpProtocolBuilder = http.baseUrl(baseUrl)


  val userFeeder: BatchableFeederBuilder[String] = csv("user_data.csv").random

  val createFirstUsers: ChainBuilder = group("Create User") {
    feed(userFeeder) // Read data from the CSV file
      .exec(http("Post 1 User Only Request")
        .post("users")
        .header("Content-Type", "application/json")
        .body(StringBody("{\n    \"name\": \"${name}\",\n    \"job\": \"${job}\"\n}")).asJson
        .check(status.is(201))
      )
      .pause(1)
  }

  val updateFirstUser: ChainBuilder = group("Update user") {
    feed(userFeeder) // Read data from the CSV file
      .exec(http("PUT User Request")
        .put("users/2")
        .header("Content-Type", "application/json")
        .body(StringBody("{\n    \"name\": \"${name}\",\n    \"job\": \"${job}\"\n}")).asJson
        .check(status.is(200)))
      .pause(1)
  }

  val getFirstUser: ChainBuilder = group("Get User") {
    exec(http("GET 1 User Only Request")
      .get("users/2")
      .check(status.is(200)))
      .pause(1)
  }

  val firstSimulation: ChainBuilder = createFirstUsers
  val secondSimulation: ChainBuilder = updateFirstUser
  val thirdSimulation: ChainBuilder = getFirstUser

  // Injection simulation
  val scenarioBuilder: ScenarioBuilder = scenario("Load_Test_Scenario")
    .exec(firstSimulation)
    .exec(secondSimulation)
    .exec(thirdSimulation)

  setUp(scenarioBuilder.inject(
    nothingFor(5.seconds),
    atOnceUsers(50),
    constantUsersPerSec(20).during(15.seconds),
    rampUsersPerSec(1).to(100).during(30.seconds)
  ))
    .protocols(httpProtocol)
    .assertions(
      global.responseTime.mean.lt(500),
      global.successfulRequests.percent.gte(75)
    )
    .maxDuration(1 minute)
}
