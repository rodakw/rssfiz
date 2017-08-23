package pl.wr.rss.rssfiz.show.math.generator;

import java.util.HashMap;
import java.util.Map;

public class Tester {
    public static void main(String[] args) throws Exception {

        Map<String, Double> params = new HashMap<>();
        params.put("A", 31.0);
        params.put("B", 20.0);
        params.put("C", 14.0);
        params.put("D", 10.0);

        Map<String, Integer> ja = new HashMap<>();
        ja.put("A", 0);
        ja.put("B", 0);
        ja.put("C", 0);
        ja.put("D", 0);
        ja.put("UNKNOWN", 0);
        for (int j = 0; j < 1; j++) {
            Generator generator = new Generator();
            String result = generator.generate(params);
            ja.put(result, ja.get(result) + 1);
        }
        System.out.println("Wynik =" + ja);
    }
}
