package com.learn.example.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JDBCUtils {
    private static String demoStr;

    static {
        Properties pro = new Properties();
        try {
            pro.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        demoStr = pro.getProperty("demoStr");
    }

    public static String getDemoStr() {
        return demoStr;
    }
}
