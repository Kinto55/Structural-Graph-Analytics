import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E7_19 {
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
        for (int val : values) {
            for (int i = 0; i < val; i++) {
                ret += '*';
            }
            ret += '\n';
        }
        return ret;
    }
}