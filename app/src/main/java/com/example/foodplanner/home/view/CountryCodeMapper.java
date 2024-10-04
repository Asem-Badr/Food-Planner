package com.example.foodplanner.home.view;

import java.util.HashMap;

public class CountryCodeMapper {
    private static final HashMap<String, String> areaToCountryCodeMap = new HashMap<>();

    static {
        areaToCountryCodeMap.put("American", "us");
        areaToCountryCodeMap.put("British", "gb");
        areaToCountryCodeMap.put("Canadian", "ca");
        areaToCountryCodeMap.put("Chinese", "cn");
        areaToCountryCodeMap.put("Croatian", "hr");
        areaToCountryCodeMap.put("Dutch", "nl");
        areaToCountryCodeMap.put("Egyptian", "eg");
        areaToCountryCodeMap.put("Filipino", "ph");
        areaToCountryCodeMap.put("French", "fr");
        areaToCountryCodeMap.put("Greek", "gr");
        areaToCountryCodeMap.put("Indian", "in");
        areaToCountryCodeMap.put("Irish", "ie");
        areaToCountryCodeMap.put("Italian", "it");
        areaToCountryCodeMap.put("Jamaican", "jm");
        areaToCountryCodeMap.put("Japanese", "jp");
        areaToCountryCodeMap.put("Kenyan", "ke");
        areaToCountryCodeMap.put("Malaysian", "my");
        areaToCountryCodeMap.put("Mexican", "mx");
        areaToCountryCodeMap.put("Moroccan", "ma");
        areaToCountryCodeMap.put("Polish", "pl");
        areaToCountryCodeMap.put("Portuguese", "pt");
        areaToCountryCodeMap.put("Russian", "ru");
        areaToCountryCodeMap.put("Spanish", "es");
        areaToCountryCodeMap.put("Thai", "th");
        areaToCountryCodeMap.put("Tunisian", "tn");
        areaToCountryCodeMap.put("Turkish", "tr");
        areaToCountryCodeMap.put("Ukrainian", "ua");
        areaToCountryCodeMap.put("Vietnamese", "vn");
    }

    public static String getCountryCode(String area) {
        return areaToCountryCodeMap.get(area);
    }
}
