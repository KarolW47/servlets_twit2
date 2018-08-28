package com.sda.twit2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextFromFileReader {

    public static final String resPath = "c:/workspace/servlets_twit2/src/main/resources/";


    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static List<String> readLinesFromFile(String path) {

        List<String> list = new ArrayList<>();

        try {
            File file = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
