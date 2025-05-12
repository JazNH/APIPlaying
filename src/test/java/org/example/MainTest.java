package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        // Arrange: Set up a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Act: Call the main method
        Main.main(new String[]{});

        // Assert: Verify the output
        String expectedOutput = "Hello and welcome!i = 1\n" +
                "i = 2\n" +
                "i = 3\n" +
                "i = 4\n" +
                "i = 5\n";

        assertEquals(expectedOutput, outputStream.toString());
    }
}