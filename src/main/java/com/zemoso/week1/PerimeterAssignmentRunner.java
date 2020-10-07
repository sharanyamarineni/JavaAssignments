package com.zemoso.week1;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for(Point p : s.getPoints()){
            count += 1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter = getPerimeter(s);
        double sides = (double) getNumPoints(s);
        double avgLength = perimeter / sides;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point point = s.getLastPoint();
        double max = 0.0;

        for(Point p : s.getPoints()){
            double distance = point.distance(p);
            if(distance > max) {
                max = distance;
            }
            point = p;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point point = s.getLastPoint();
        int pointX = point.getX();
        double max = (double) pointX;

        for(Point p : s.getPoints()){
            int x = p.getX();
            if(x > max) {
                max = (double) x;
            }
        }
        return max;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max = 0.0;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double len = getPerimeter(shape);
            if(len > max) {
                max = len;
            }
        }
        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max = 0.0;
        File temp = null;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double len = getPerimeter(shape);
            if(len > max) {
                max = len;
                temp = f;
            }
        }

        return temp.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        double max = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter" + max);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("name of largest perimeter file" + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int count = getNumPoints(s);
        double average = getAverageLength(s);
        double side = getLargestSide(s);
        double largestX = getLargestX(s);

        System.out.println("perimeter = " + length);
        System.out.println("count of points = " + count);
        System.out.println("average of all lengths = " + average);
        System.out.println("largest len of side = " + side);
        System.out.println("largest x coordinate = " + largestX );
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
