package ru.screamoov.bestlogger.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TXTWriter {
    public static void appendToFile(String filePath, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("[Issue in bestLogger while appending text]: " + e.getMessage());
        }
    }
}
