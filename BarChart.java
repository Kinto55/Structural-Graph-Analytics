// CPSC_1110_BARCHART.JAVA_Morris - class implementing a BarChart
// Author: Markay Morris 
// Date: 7/14/2021 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BarChart {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Integer> vals = readValues(in.nextLine());
        System.out.println(generateBarGraph(vals));
        in.close();
    }

    private static List<Integer> readValues(String in) {
        //WHAT IT DOES:The string with the list of values separated by spaces.
        //HOW IT WORKS:The list of values from the string.
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
        //WHAT IT DOES:The list of the input values
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
}