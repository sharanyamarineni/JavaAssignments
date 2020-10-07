package com.zemoso.week3;
import edu.duke.*;
import org.apache.commons.csv.*;
public class ParseData {
    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record : parser) {
            String countryData = record.get("Country");
            if(countryData.contains(country)) {
                String exports = record.get("Exports");
                String price = record.get("Value (dollars)");
                String data = countryData + ": " + exports + ": " + price;
                return data;
            }
        }

        return "can't find";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord record : parser) {
            String exports = record.get("Exports");
            String countryData = record.get("Country");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(countryData);
            }
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for(CSVRecord record : parser) {
            String exports = record.get("Exports");
            if(exports.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }
    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record : parser) {
            String price = record.get("Value (dollars)");
            String countryData = record.get("Country");

            if(price.length() > amount.length()) {
                System.out.println(countryData + ": " + price);
            }
        }
    }
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
        //listExportersTwoProducts(parser,"gold","diamond");
        //System.out.println(numberOfExporters(parser,"sugar"));
       // System.out.println(countryInfo(parser,"Nauru"));
    }

    public static void main(String[] args) {
        ParseData parse = new ParseData();
        parse.tester();

    }
}
