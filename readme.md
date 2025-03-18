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
## How to Compile and Run

1. **Compile the project:**
   ```bash
   javac -d target src/main/java/*.java
   ```

2. **Create the jar file:**
   ```bash
   jar cvfe rover.jar Main -C target .
   ```

3. **Run the program:**
   ```bash
   java -jar rover.jar input.txt
   ```
