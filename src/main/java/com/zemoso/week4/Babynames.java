package com.zemoso.week4;
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class Babynames {
    public void totalBirths(FileResource fr){
        int totalBirth = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for(CSVRecord record:  fr.getCSVParser(false)){
            int curr = Integer.parseInt(record.get(2));
            totalBirth += curr;
            if(record.get(1).equals("M")){
                totalBoys++;
            }
            else{
                totalGirls++;
            }
        }
        System.out.println("total births = "+ totalBirth);
        System.out.println("total boys :  " + totalBoys);
        System.out.println("total girls :" + totalGirls);
    }
    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource();
        int rank = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            String currName = record.get(0);
            String cuurGender = record.get(1);
            if (!cuurGender.equals(gender)) {
                continue;
            } else {
                rank++;
                if (currName.equals(name)) {
                    return rank;
                } else {
                    continue;
                }
            }
        }
        return -1;
    }
    public String getName(int year, int rank, String gender){
        FileResource fr = new FileResource();
        int currRank = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            String thisGender = record.get(1);
            if(!thisGender.equals(gender)){
                continue;
            }
            else{
                currRank++;
                if(currRank == rank){
                    return record.get(0);
                }
                else{
                    continue;
                }
            }
        }
        return "NO NAME";
    }
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int rank = getRank(year, name, gender);
        if(rank == -1){
            System.out.println("not found");
        }
        String currName = getName(newYear, rank, gender);
        System.out.println(name + " born in " + year + " would be "+ currName + " if she was born in " + newYear + ".");

    }
    public int yearOfHighestRank(String name, String gender){
        int max = 0;
        int maxYear = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            String filename = f.getName();
            System.out.println("the file we select is: "+ filename);
            int year = Integer.parseInt(filename.substring(3,7));
            int rank = getRank2(year, name, gender,f);
            System.out.println("the rank of year "+ year + " is "+ rank);
            if(rank == -1){
                continue;
            }
            if(max == 0){
                max = rank;
                maxYear = year;
            }
            else{
                if(rank < max){
                    max = rank;
                    maxYear = year;
                }
                else{
                    continue;
                }
            }
        }

        if(max == 0){
            return -1;
        }
        else{
            return maxYear;
        }
    }
    public int getRank2(int year, String name, String gender, File f){
        FileResource fr = new FileResource(f);
        int rank = 0;
        for(CSVRecord record: fr.getCSVParser(false)){
            String thisName = record.get(0);
            String thisGender = record.get(1);
            if(!thisGender.equals(gender)){
                continue;
            }
            else{
                rank++;
                if(thisName.equals(name)){
                    return rank;
                }
                else{
                    continue;
                }
            }
        }
        return -1;
    }
    public double getAverageRank(String name, String gender){
        int total = 0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            String filename = f.getName();
            System.out.println("the file we select is: "+ filename);
            int year = Integer.parseInt(filename.substring(3,7));
            int rank = getRank2(year, name, gender,f);
            System.out.println("the rank of year "+ year + " is "+ rank);
            if(rank == -1){
                continue;
            }
            else {
                total+= rank;
                count++;
            }
        }
        if(count == 0){
            return -1;
        }
        else{
            return (double)total/count;
        }
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int theRank = getRank(year,name,gender);
        int count = 0;
        FileResource fr = new FileResource();
        for(CSVRecord record: fr.getCSVParser()){
            String currName = record.get(0);
            String currGender = record.get(1);
            int total = Integer.parseInt(record.get(2));
            if(!currGender.equals(gender)){
                continue;
            }
            else {
                if(!currName.equals(name)) {
                    count += total;
                }
                else{
                    return count;
                }
            }
        }
        return -1;
    }
    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
//		System.out.println(getRank(1971, "Frank", "M"));
//		System.out.println(getName(1982, 450, "M"));
//		whatIsNameInYear("Owen", 1974, 2014, "M");
//		System.out.println(yearOfHighestRank("Mich", "M"));
//		System.out.println(getAverageRank("Robert","M"));
//		System.out.println(getTotalBirthsRankedHigher(1990, "Emily", "F"));
    }
}
