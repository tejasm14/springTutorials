package com.demo.firstSpring.tutorial.test;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class ListFiles {
    public static void main(String[] args) {
        String folderPath = "D:\\TEJAS MOHITE\\Projects-06-06-2022\\vijay-sales-project-files-05-04-2024\\mixed-prod-spec-files-segregate-20-01-2024\\output"; // Change this to your folder path

        try {
            List<String> fileList = Files.list(Paths.get(folderPath))
                    .filter(Files::isRegularFile) // Filters only files, not directories
                    .map(path -> path.getFileName().toString()) // Extracts file names
                    .collect(Collectors.toList());

            System.out.println("Files in folder: " + fileList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

