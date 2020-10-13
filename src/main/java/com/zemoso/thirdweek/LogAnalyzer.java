package com.zemoso.thirdweek;

import edu.duke.FileResource;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<>();
    }

    public void readFile(String filename) {
        FileResource resource = new FileResource(filename);
        for (String line : resource.lines()) {
            LogEntry le = WebLogParser.parseEntry(line);
            records.add(le);
        }
    }
    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs() {
        List<String> uniqueIPs = new ArrayList<>();
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }

    public int countUniqueIPsInRange(int low, int high) {
        List<String> uniqueIPs = new ArrayList<>();
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            int statusCode = le.getStatusCode();
            if (statusCode >= low && statusCode <= high && !uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }

    public List<String> uniqueIPVisitsOnDay(String someday) {
        List<String> uniqueVisits = new ArrayList<>();
        for (LogEntry le : records) {
            Date accessTime = le.getAccessTime();
            String ipAddr = le.getIpAddress();
            Format formatter = new SimpleDateFormat("MMM dd");
            String formattedDate = formatter.format(accessTime);
            if (formattedDate.equals(someday) && !uniqueVisits.contains(ipAddr)) {
                uniqueVisits.add(ipAddr);
            }
        }
        return uniqueVisits;
    }

    public Map<String, Integer> countVisitsPerIP() {
        Map<String, Integer> map = new HashMap<>();
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            if (map.containsKey(ipAddr)) {
                map.put(ipAddr, map.get(ipAddr) + 1);
            } else {
                map.put(ipAddr, 1);
            }
        }
        return map;
    }

    public int mostNumberVisitsByIP(Map<String, Integer> visitsPerIPMap) {
        int result = 0;
        for (Map.Entry<String, Integer> entry : visitsPerIPMap.entrySet()) {
            if (entry.getValue() > result) {
                result = entry.getValue();
            }
        }
        return result;
    }

    public List<String> iPsMostVisits(Map<String, Integer> visitsPerIPMap) {
        ArrayList<String> ipList = new ArrayList<String>();
        int maxVisit = mostNumberVisitsByIP(visitsPerIPMap);

        for (String key : visitsPerIPMap.keySet()) {
            int currentCount = visitsPerIPMap.get(key);

            if (currentCount == maxVisit) {
                ipList.add(key);
            }
        }
        return ipList;
    }

    public Map<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> ipsPerDay = new HashMap<String, ArrayList<String>>();
        for (LogEntry le : records) {
            String accessTime = le.getAccessTime().toString();
            String day = accessTime.substring(4, 10);
            String currIp = le.getIpAddress();
            ArrayList<String> ipList;

            if (!ipsPerDay.containsKey(day)) {
                ipList = new ArrayList<String>();
            } else {
                ipList = ipsPerDay.get(day);
            }

            ipList.add(currIp);
            ipsPerDay.put(day, ipList);
        }

        return ipsPerDay;
    }

    public String dayWithMostIPVisits(Map<String, List<String>> ipsForDays) {
        String day = "";
        int maxVisit = Integer.MIN_VALUE;

        for (String key : ipsForDays.keySet()) {
            int currentVisit = ipsForDays.get(key).size();

            if (currentVisit > maxVisit) {
                maxVisit = currentVisit;
                day = key;
            }
        }

        return day;
    }

    public List<String> iPsWithMostVisitsOnDay(Map<String, ArrayList<String>> ipsForDays, String someday) {
        ArrayList<String> ipList = ipsForDays.get(someday);
        HashMap<String, Integer> ipCounts = new HashMap<String, Integer>();

        for (String ip : ipList) {
            if (!ipCounts.containsKey(ip)) {
                ipCounts.put(ip, 1);
            } else {
                ipCounts.put(ip, ipCounts.get(ip) + 1);
            }
        }
        return iPsMostVisits(ipCounts);
    }


    public void printAllHigherThanNum(int num) {
        System.out.println("All log entries with status higher than " + num + ":");
        for (LogEntry le : records) {
            int statusCode = le.getStatusCode();
            if (statusCode > num) {
                System.out.println(le);
            }
        }
    }

    public static void main(String[] args) {
        LogAnalyzer l = new LogAnalyzer();
//        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
//        System.out.println(le);
        l.readFile("/home/sharanyam/IdeaProjects/Coursera2/files/short-log");
        //l.printAll();
        //test unique ip
       // System.out.println("Total unique IPs = " + l.countUniqueIPs());

//        List<String> record = l.uniqueIPVisitsOnDay("Sep 30");
//        System.out.println("Sep 30 = " + record);

//        l.printAllHigherThanNum(200);
    }
}
