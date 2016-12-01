package net.testProject.geoCodingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DataExtractor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataExtractor.class);
    private static final String CURRENT_DIR = System.getProperty("user.dir");
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String FILE_NAME = "cities";
    private static final String MESSAGE =
            "Put a file with name 'cities' in the same parent directory as a jar file and press any key";

    public static List<String> getCities() throws IOException {
        LOGGER.info(MESSAGE);
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        scanner.nextLine();

        String absoluteFileName = CURRENT_DIR + FILE_SEPARATOR + FILE_NAME;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(absoluteFileName))) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
