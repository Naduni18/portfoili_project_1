package com.naduni18.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    private final String SystemFilePath = System.getProperty("user.dir");
    private final String propertyFilePath = SystemFilePath + "\\src\\config\\data.properties";

    public ConfigFileReader() {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String readProperty(String propertyName)
    {
        String Property = properties.getProperty(propertyName.trim());

        if (Property != null) {
            return Property;
        } else {
            throw new RuntimeException("Value not specified in the data.properties file for the Key: "+propertyName);
        }
    }
}
