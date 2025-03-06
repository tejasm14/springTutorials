package com.demo.firstSpring.tutorial.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BlankRowChecker {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\tejas.mohite\\Downloads\\a-plus-content (25).csv"; // Update this with your CSV file path
        checkBlankRows(filePath);
    }

    public static void checkBlankRows(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowNumber = 0;
            boolean hasBlankRow = false;

            while ((line = br.readLine()) != null) {
                rowNumber++;
                if (line.trim().isEmpty() || line.matches("^(,)*$")) {
                    System.out.println("Blank row found at line: " + rowNumber);
                    hasBlankRow = true;
                }
            }

            if (!hasBlankRow) {
                System.out.println("No blank rows found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

