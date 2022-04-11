// CPSC_1110_VerticalBARCHART.JAVA_Morris - class implementing a Vertical BarChart
// Author: Markay Morris 
// Date: 7/14/2021 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VerticalBarChart {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Integer> vals = readValues(in.nextLine());
        System.out.println(generateBarGraphVertical(vals));
        in.close();
    }

    private static List<Integer> readValues(String in) {
        //WHATS IT DOES: makes the bars vertical, with the tallest bar twenty asterisks high.
        //HOW IT DOES:method returns a list of the bar values from a given string.
        String[] tokens = in.split("\\s+");
        List<Integer> ret = new ArrayList<Integer>();
        for (String t : tokens) {
            try {

                ret.add(Integer.parseInt(t));
            } catch (NumberFormatException e) {
                System.err.println("Error reading \"" + t + "\". Skipping token.");
            }
        }
        return ret;
    }

    private static String generateBarGraphVertical(List<Integer> values) {
        //WHAT IT DOES: Illustrates a values list of all the input values
        // HOW TI WORKS: method returns the string representation of the vertical bar graph produced by inputted value
        String ret = "";
        int max = Collections.max(values);
        for (int i = max; i > 0; --i) {
            for (int val : values) {
                ret += val >= i ? '*' : ' ';
            }
            ret += '\n';
        }
        return ret;
    }
}