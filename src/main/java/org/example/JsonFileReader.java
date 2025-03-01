package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class JsonFileReader {
    public static JsonNode readJsonFromFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = JsonFileReader.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: words.json");
            }
            JsonNode jsonNode = objectMapper.readTree(inputStream);
            return jsonNode;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
