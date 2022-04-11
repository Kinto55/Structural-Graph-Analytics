// CaptionBarChart for this exercises - class implementing captions for the BarChart
// Author: Markay Morris 
// Date: 7/14/2021 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaptionBarChart {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String res = "";
        while ("123".indexOf(res) == -1 || res.isEmpty()) {
            System.out.println("Would you like a labeled bar graph?\n[1] Yes\n[2] No\n[3] Quit");
            res = in.nextLine();
        }
        switch (res) {
            case "1":
                System.out.println("Please input entries in this format: \"Caption\" [value]\nInput -1 to stop.");
                ArrayList<Integer> nums = new ArrayList<>();
                ArrayList<String> captions = new ArrayList<>();
                while (true) {
                    String entry = in.nextLine();
                    if (entry.equals("-1"))
                        break;
                    String cap = entry.substring(entry.indexOf('"'), entry.lastIndexOf('"'));
                    String num = entry.substring(entry.lastIndexOf('"') + 1).trim();
                    try {
                        nums.add(Integer.parseInt(num));
                    } catch (NumberFormatException e) {
                        System.err.println("Error reading \"" + num + "\". Skipping entry.");
                    }
                    captions.add(cap);
                }
                System.out.println(generateBarGraphWithCaptions(nums, captions));
                break;
            case "2":
                System.out.println("Please input numerical values with a space inbetween.");
                System.out.println(generateBarGraph(readValues(in.nextLine())));
                break;
            case "3":
                // Just does nothing.
                break;
        }
        in.close();
    }

    private static List<Integer> readValues(String in) {
        //WHAT IT DOES:The string with the list of values separated by spaces.
        //HOW TI WORKS:The list of values from the string.
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

    private static String generateBarGraph(List<Integer> values) {
        //WHAT IT DOES:values The list of the input values
        //HOW IT WORKS:Returns the string representation of bar graph 
        String ret = "";
        for (int val : values) {
            for (int i = 0; i < val; i++) {
                ret += '*';
            }
            ret += '\n';
        }
        return ret;
    }

    private static String generateBarGraphWithCaptions(List<Integer> values, List<String> captions) {
        //WHAT IT DOES: values The list of the input values captions The list of the input captions
        //HOW IT WORKS: This method returns the string representation of the labeled bar graph produced by inputted values and captions
        String ret = "";
        for (int index = 0; index < values.size(); index++) {
            ret += captions.get(index) + '\t';
            for (int i = 0; i < values.get(index); i++) {
                ret += '*';
            }
            ret += '\n';
        }
        return ret;
    }
}