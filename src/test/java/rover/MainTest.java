package rover;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class MainTest {

    @Test
    public void testMainOutput() throws Exception {
        File tempInput = File.createTempFile("input", ".txt");
        try (PrintWriter writer = new PrintWriter(tempInput)) {
            writer.println("5 5");
            writer.println("1 2 N");
            writer.println("LMLMLMLMM");
            writer.println("3 3 E");
            writer.println("MMRMMRMRRM");
        }

        // Capture System.out.
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run Main with the temporary input file.
        Main.main(new String[] { tempInput.getAbsolutePath() });

        // Restore System.out.
        System.setOut(originalOut);

        // Compare the output.
        String expectedOutput = "1 3 N" + System.lineSeparator() + "5 1 E";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Delete the temporary file.
        tempInput.delete();
    }
}
