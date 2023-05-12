ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "GatlingAssignment"
  )

val gatlingHighchartsVersion = "3.9.3"
val gatlingFrameworkVersion = "3.9.3"
val typesafeVersion = "0.13.15"
enablePlugins(GatlingPlugin)
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingHighchartsVersion % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % gatlingFrameworkVersion % "test"
libraryDependencies += "com.typesafe.sbt"      % "sbt-interface"             % typesafeVersion


//enablePlugins(GatlingPlugin)
//
//scalaVersion := "2.13.10"
//
//scalacOptions := Seq(
//  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
//  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")
//
//val gatlingVersion = "3.9.3"
//libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % "test,it"
//libraryDependencies += "io.gatling"            % "gatling-test-framework"    % gatlingVersion % "test,it"

