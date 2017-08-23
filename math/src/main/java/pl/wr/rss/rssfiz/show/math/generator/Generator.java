package pl.wr.rss.rssfiz.show.math.generator;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Generator {

    private String[] table = null;

    private int sizeTable = 0;


    public String generate(Map<String, Double> params) throws Exception {

        List<Map.Entry<String, Double>> sortedParams = Utilities.sortByValue(params);
//        System.out.println(sortedParams);

        SortedSet<Integer> maxMultipier = new TreeSet<>();
        Double sum = 0.0;
        for (Map.Entry<String, Double> sortedParam : sortedParams) {
            maxMultipier.add(Utilities.multiplier(sortedParam.getValue()));
            sum = Utilities.sum(sortedParam.getValue(),sum);
            //sum += sortedParam.getValue();
        }

        if (sum > 100){
            System.out.println("sum="+sum);
            throw new Exception("Bad sum pf persents");
        } else if (sum < 100){
            System.out.println("sum="+sum);
            params.put("UNKNOWN",Utilities.rest(sum));
            sortedParams = Utilities.sortByValue(params);
        }
        System.out.println(sortedParams);

        Integer last = maxMultipier.last();
        sizeTable = last;
        table = new String[sizeTable];


        for (Map.Entry<String, Double> sortedParam : sortedParams) {
            fillTable(sortedParam.getKey(), sortedParam.getValue() * sizeTable / 100);
        }

//        System.out.println(Arrays.toString(table));
        return randomValue();
    }

    private void fillTable(String name, double percent) {
        int count = 0;
        Double b = 0.0;
        int a;
        for (int i = 0; count < percent; i = i + a) {

            if (i > sizeTable - 1) {
                if (i != sizeTable)
                    i = (i % sizeTable) - 1;
                else i = 0;
                percent = percent - count;
                b = 0.0;
                count = 0;
            }
            b = b - Math.floor(b) + (sizeTable / percent);
            a = b.intValue();
            if (table[i] == null) {
                table[i] = name;
                ++count;
            } else {
                a = 1;
            }
        }
    }

    private String randomValue() {
        Double round = Math.floor(Math.random() * (double) sizeTable);
        return table[round.intValue()];
    }

}
