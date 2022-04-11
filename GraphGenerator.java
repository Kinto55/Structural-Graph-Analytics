import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E7_21 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Integer> vals = readValues(in.nextLine());
        System.out.println(generateBarGraph(vals));
        in.close();
    }

    private static List<Integer> readValues(String in) {
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
        String ret = "";
        int min = Collections.min(values);
        String padding = "";
        for (int i = 0; i < Math.abs(min); i++) {
            padding += ' ';
        }
        for (int val : values) {
            String line = "";
            for (int i = 0; i < Math.abs(val); i++) {
                line += '*';
            }
            if (min < 0)
                if (val < 0) {
                    line = padding.substring(0, val - min) + line + '|';
                } else {
                    line = padding + '|' + line;
                }
            ret += line + '\n';
        }
        return ret;
    }
}