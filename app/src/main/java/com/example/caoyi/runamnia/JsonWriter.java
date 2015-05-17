package com.example.caoyi.runamnia;

/**
 * Created by de-weikung on 5/16/15.
 */


import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Reference:
 * @author Crunchify.com
 */

public class JsonWriter {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        JSONObject obj = new JSONObject();
        obj.put("Name", "crunchify.com");
        obj.put("Author", "App Shah");

        JSONArray company = new JSONArray();
        company.add("Compnay: eBay");
        company.add("Compnay: Paypal");
        company.add("Compnay: Google");
        obj.put("Company List", company);

        FileWriter file = new FileWriter("/Users/de-weikung/AndroidStudioProjects/Runmania/app/src/main/res/userInfo.config");



        try {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            file.flush();
            file.close();
        }
    }
}