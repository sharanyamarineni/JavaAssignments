package com.zemoso.week3;
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class CoolestDay {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord temp = null;
        for(CSVRecord row : parser) {
            if(temp == null) {
                temp = row;
            }
            else {
                double currTemp = Double.parseDouble(row.get("TemperatureF"));
                double min = Double.parseDouble(temp.get("TemperatureF"));
                if(currTemp < min) {
                    temp = row;
                }
            }
        }
        return temp;
    }
    public void testColdestHourInFile() {
        FileResource f = new FileResource();
        CSVParser parser = f.getCSVParser();

        CSVRecord min = coldestHourInFile(parser);
        System.out.println(min.get("TemperatureF") + ": " + min.get("DateUTC"));
    }

    public String fileWithColdestTemperature() {
        File fileName = null;
        CSVRecord temp = null;

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord row = coldestHourInFile(parser);

            if(temp == null) {
                temp = row;
                fileName = f;
            }
            else {
                double currTemp = Double.parseDouble(row.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(temp.get("TemperatureF"));
                if(currTemp < lowestTemp && currTemp > -50) {
                    temp = row;
                    fileName = f;
                }
            }
        }
        return fileName.getAbsolutePath();
    }

    public void testFileWithColdestTemperature() {
        String coldfile = fileWithColdestTemperature();
        File f = new File(coldfile);
        String fileName = f.getName();

        System.out.println("cool day filename: " + fileName);


        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser();
        CSVRecord min = coldestHourInFile(parser);

        System.out.println("coldest temp is: " + min.get("TemperatureF"));

        System.out.println("all temperatures:");
        CSVParser parser2 = fr.getCSVParser();
        for(CSVRecord record : parser2) {
            double temp = Double.parseDouble(record.get("TemperatureF"));
            System.out.println(temp);
        }
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord humidity = null;
        int currHumd;
        int min;
        for(CSVRecord row : parser) {
            if(humidity == null) {
                humidity = row;
            }

            else {
                if(!row.get("Humidity").equals("N/A") && !humidity.get("Humidity").equals("N/A")) {
                    currHumd = Integer.parseInt(row.get("Humidity"));
                    min = Integer.parseInt(humidity.get("Humidity"));

                    if(currHumd < min) {
                        humidity = row;
                    }
                }
            }
        }
        return humidity;
    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord humidity = lowestHumidityInFile(parser);

        System.out.println(humidity.get("Humidity") + " at " + humidity.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord humidity = null;
        int curr;
        int min;

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord row = lowestHumidityInFile(parser);

            if(humidity == null) {
                humidity = row;
            }
            else {
                int currTemp = Integer.parseInt(row.get("Humidity"));
                int lowestTemp = Integer.parseInt(humidity.get("Humidity"));
                if(currTemp < lowestTemp) {
                    humidity = row;
                }

                else {
                    if(row.get("Humidity") != "N/A" && humidity.get("Humidity") != "N/A") {
                        curr = Integer.parseInt(row.get("Humidity"));
                        min = Integer.parseInt(humidity.get("Humidity"));

                        if(curr < min) {
                            humidity = row;
                        }
                    }
                }
            }
        }
        return humidity;
    }

    public void testLowestHumidityInManyFiles() {
        CSVRecord record = lowestHumidityInManyFiles();
        System.out.println(record.get("Humidity") + " at " + record.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser) {
        double n = 0.0;
        double total = 0.0;

        for(CSVRecord record : parser) {
            double temp = Double.parseDouble(record.get("TemperatureF"));
            total += temp;
            n++;
        }

        double average = total / n;
        return average;
    }

    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureInFile(parser);

        System.out.println("avg temp is " + avg);
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double n = 0.0;
        double total = 0.0;

        for(CSVRecord record : parser) {
            double temp = Double.parseDouble(record.get("TemperatureF"));
            int humidity = Integer.parseInt(record.get("Humidity"));
            if(humidity >= value) {
                total += temp;
                n++;
            }
        }

        double average = total / n;
        return average;
    }

    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureWithHighHumidityInFile(parser, 80);

        if(!Double.isNaN(avg)) {
            System.out.println("avg temp is " + avg);
        } else {
            System.out.println("Not found");
        }
    }
}
