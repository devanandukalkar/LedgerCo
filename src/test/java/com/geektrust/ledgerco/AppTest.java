package com.geektrust.ledgerco;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("AppIntegrationTest")
class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Application Integration Test")
    void appIntegrationTest() {
        // Arrange
        String inputFile = "sample_input/input1.txt";
        String expectedOutput = "IDIDI Dale 1000 55\n" +
                "IDIDI Dale 8000 20\n" +
                "MBI Harry 1044 12\n" +
                "MBI Harry 0 24";
        // Act
        App.run(inputFile);
        String actualOutput = outputStreamCaptor.toString().trim();
        actualOutput = actualOutput.replace("\r\n", " ").replace("\n", " ");
        expectedOutput = expectedOutput.replace("\n", " ");

        // Assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}