import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ShamirSecretSharing {

    static class Point {
        int x;
        BigInteger y;

        public Point(int x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject testCase1 = (JSONObject) parser.parse(new FileReader("C:\\Users\\aryan\\Desktop\\Core Java\\Java FX\\Catalog Assignment\\Catalog Assignment\\src\\testcase1.json"));
            JSONObject testCase2 = (JSONObject) parser.parse(new FileReader("C:\\Users\\aryan\\Desktop\\Core Java\\Java FX\\Catalog Assignment\\Catalog Assignment\\src\\testcase2.json"));


            BigInteger secret1 = solveTestCase(testCase1);
            System.out.println("Secret for test case 1: " + secret1);

            BigInteger secret2 = solveTestCase(testCase2);
            System.out.println("Secret for test case 2: " + secret2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static BigInteger solveTestCase(JSONObject testCase) {
        JSONObject keys = (JSONObject) testCase.get("keys");
        int n = ((Long) keys.get("n")).intValue();
        int k = ((Long) keys.get("k")).intValue();

        List<Point> points = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String index = Integer.toString(i);
            if (testCase.containsKey(index)) {
                JSONObject root = (JSONObject) testCase.get(index);
                int base = Integer.parseInt((String) root.get("base"));
                String value = (String) root.get("value");

                BigInteger y = new BigInteger(value, base);

                points.add(new Point(i, y));
            }
        }

        return lagrangeInterpolation(points, BigInteger.ZERO);
    }

    private static BigInteger lagrangeInterpolation(List<Point> points, BigInteger x) {
        BigInteger result = BigInteger.ZERO;

        for (int i = 0; i < points.size(); i++) {
            BigInteger term = points.get(i).y;
            for (int j = 0; j < points.size(); j++) {
                if (i != j) {
                    BigInteger xi = BigInteger.valueOf(points.get(i).x);
                    BigInteger xj = BigInteger.valueOf(points.get(j).x);
                    term = term.multiply(x.subtract(xj)).divide(xi.subtract(xj));
                }
            }
            result = result.add(term);
        }

        return result;
    }
}
