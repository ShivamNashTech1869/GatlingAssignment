# Gatling Assignment

This repository contains a Gatling load testing project for the assignment.

## Assignment Details

The assignment is to perform load testing on the target API and measure its performance. The API is located at `https://api.example.com/`.

## Prerequisites

- Java 8 or higher
- Gatling installed (version X.X.X)

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/shivamknoldus1869/GatlingAssignment.git

2. Install the required dependencies:
#### If using sbt:
     sbt update

#### If using Maven:

    mvn clean install

3. Configure the simulation:

    Open the src/test/scala/com/example/gatlingassignment/LoadSimulation.scala file.
    Adjust the base URL in the http.baseUrl() method to match the target API.

4. Run the simulation:
#### If using sbt:
    sbt gatling:test

#### If using Maven:
    mvn gatling:test

5. View the test results:

After running the simulation, Gatling generates HTML reports containing detailed test results. The reports can be found in the target/gatling directory.


# Documentation of Gatling Load Test Report

This repository contains a Gatling load test simulation that generates an HTML report. The report provides detailed insights into the performance and behavior of the tested application under load. You can find the generated report at the following location:

## Report Contents

The Gatling load test report consists of the following sections:

### Summary

The summary section provides an overview of the load test results, including the total number of requests, number of failed requests, response time percentiles, and throughput.

### Requests

The requests section displays individual request details, such as the request name, request count, average response time, and request details chart.

### Errors

The errors section lists any errors or failed requests that occurred during the load test. It provides information about the error message, status code, and occurrence count.

### Distribution

The distribution section presents response time distribution charts, allowing you to analyze the distribution of response times across different percentiles.

### Response Time

The response time section visualizes the response time metrics, including response time percentiles and response time distribution.

### Global Information

The global information section provides general information about the load test run, such as the start time, end time, and total duration.

### Configuration

The configuration section displays the configuration settings used for the load test, such as the base URL, feeder file path, and injection profiles.

### Assertions

The assertions section shows the results of the assertions defined in the simulation. It indicates whether the defined performance thresholds were met or not.


Use the Gatling load test report to analyze the performance of your application, identify any bottlenecks, and make informed optimizations.


