package com.psl.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesDataProvider {

    Properties property;

    public PropertiesDataProvider(String configFileName) {

        File propertiesFile = new File("src\\test\\resources\\ConfigurationFile\\" + configFileName + ".properties");
        try {
            FileInputStream fis = new FileInputStream(propertiesFile);
            property = new Properties();
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
//     Function to get the Value of PropertyName from property file 
  
    public String getPropertyValue(String propertyName) {
        return property.getProperty(propertyName);
    }
}