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

# 1 Install the required dependencies:
# If using sbt:
sbt update

# If using Maven:

mvn clean install

# 2 Configure the simulation:

    Open the src/test/scala/com/example/gatlingassignment/LoadSimulation.scala file.
    Adjust the base URL in the http.baseUrl() method to match the target API.

# 3 Run the simulation:
# If using sbt:
sbt gatling:test

# If using Maven:
mvn gatling:test
# 4 View the test results:

After running the simulation, Gatling generates HTML reports containing detailed test results. The reports can be found in the target/gatling directory.

