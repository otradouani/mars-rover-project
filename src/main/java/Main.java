import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar rover.jar input.txt");
            System.exit(1);
        }

        String inputFile = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            Plateau plateau = readPlateau(reader);
            List<String> finalPositions = processRovers(reader, plateau);
            finalPositions.forEach(System.out::println);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing input file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Plateau readPlateau(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line == null) {
            throw new IOException("Input file is empty.");
        }
        String[] parts = line.trim().split("\\s+");
        if (parts.length != 2) {
            throw new IOException("Invalid plateau dimensions.");
        }
        int xMax = Integer.parseInt(parts[0]);
        int yMax = Integer.parseInt(parts[1]);
        return new Plateau(xMax, yMax);
    }

    private static List<String> processRovers(BufferedReader reader, Plateau plateau) throws IOException {
        List<String> finalPositions = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] roverData = line.split("\\s+");
            if (roverData.length != 3) {
                throw new IOException("Invalid rover starting position: " + line);
            }
            int startX = Integer.parseInt(roverData[0]);
            int startY = Integer.parseInt(roverData[1]);
            Direction startDirection = Direction.valueOf(roverData[2]);

            Rover rover = new Rover(startX, startY, startDirection, plateau);

            String commands = reader.readLine();
            if (commands == null) {
                throw new IOException("Missing commands for rover at position: " + line);
            }
            rover.processCommands(commands.trim());
            finalPositions.add(rover.getPosition());
        }
        return finalPositions;
    }
}