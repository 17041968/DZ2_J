package org.example;

import java.sql.SQLOutput;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        String str = "{\"name\": \"Ivanov\",\"country\": \"Russia\", \"city\": \"Moscow\", \"age\": \"null\"}";
        System.out.println(createSQLRequest(str));
    }
    private static String createSQLRequest(String request) {
        request = request.substring(1, request.length() - 1);
        System.out.println(request);
        String[] attributes = request.split(",");
        StringBuilder SQLrequest = new StringBuilder("SELECT * FROM students WERE");
        for (int i = 0; i < attributes.length; i++) {
            String[] pair = attributes[i].split(":");
            String value = pair[1];

            if (value.equals("\"null\"")) {
                String key = pair[0].substring(1, pair[0].length() - 1);
                if (i != 0) {
                    SQLrequest.append("And");
                }
                SQLrequest.append(" ").append(key).append("=").append(value);
            }
        }
        return  SQLrequest.toString();
    }
}
