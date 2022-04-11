import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E7_20 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Integer> vals = readValues(in.nextLine());
        System.out.println(generateBarGraphVertical(vals));
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

    private static String generateBarGraphHorizontal(List<Integer> values) {
        String ret = "";
        for (int val : values) {
            for (int i = 0; i < val; i++) {
                ret += '*';
            }
            ret += '\n';
        }
        return ret;
    }

    private static String generateBarGraphVertical(List<Integer> values) {
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