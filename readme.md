# Mars Rover Simulation

This project simulates the navigation of robotic rovers on a rectangular plateau on Mars. Each rover receives a set of commands to turn or move, and then reports its final position on the grid.

## Project Overview

- **Direction.java**: Enum representing the four cardinal directions (N, E, S, W) with methods to turn left and right.
- **Plateau.java**: Class representing the plateau boundaries.
- **Rover.java**: Class that processes movement commands and updates the rover's position.
- **Main.java**: Main class that reads the input file, processes each rover sequentially, and prints the final positions.

## Input Format

- **First line**: Two integers defining the upper-right coordinates of the plateau (the lower-left is assumed to be `0 0`).
- **Subsequent lines**: For each rover:
    - One line with the initial position and direction (e.g., `1 2 N`).
    - One line with the movement commands (e.g., `LMLMLMLMM`).

### Example Input File (`input.txt`)
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```
## Expected Output

For the example above, the program should output:
```
1 3 N
5 1 E
```
## How to Build and Run with Maven
This project uses [Maven](https://maven.apache.org/) for build automation and dependency management.

### Prerequisites

- Install a JDK (not just a JRE) and set the `JAVA_HOME` environment variable appropriately.
- Install Maven.

### Build and Package the Project

From the project root, run the following command to clean, compile, run tests, and package the application:

```bash
mvn clean package
```
This will create an executable jar file named rover.jar in the target directory.

## Run the Application
Run the program from the project root using the following command:

```bash
java -jar rover.jar input.txt
```
Make sure that input.txt is present in the project root or provide the correct path to the input file.

## Running Unit Tests
To run the unit tests separately, execute:
```bash
mvn test
```
