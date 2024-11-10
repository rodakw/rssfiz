package pl.wr.rss.rssfiz.show.math.generator;

import java.util.*;
import java.util.Map.Entry;

public class Utilities {

    public static <K, V extends Comparable<V>> List<Entry<K, V>> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        entries.sort(new ByValue<>());
        return entries;
    }

    private static class ByValue<K, V extends Comparable<V>> implements Comparator<Entry<K, V>> {
        public int compare(Entry<K, V> o1, Entry<K, V> o2) {
            return o2.getValue().compareTo(o1.getValue());
        }
    }

    public static int multiplier(double percent) {
        double modulo = 10;
        int returnValue = 10;
        while (true) {
            if (percent % modulo == 0) {
                return returnValue;
            } else {
                percent *= 10;
                returnValue *= 10;

            }
        }
    }

    public static double rest(double todostanie) {
        double ola = 10;
        int mnoznik = 1;
        while (true) {
            if (todostanie % ola == 0) {
                return (100 * mnoznik - todostanie) / mnoznik;
            } else {
                todostanie *= 10;
                mnoznik *= 10;

            }
        }
    }

    public static double sum(double totezdostanie, double sum) {

        double modulo = 1;
        int mnoznik = 1;

        while (true) {
            if (sum % modulo == 0 || totezdostanie % modulo == 0) {
                sum = (sum + totezdostanie) / mnoznik;
                System.out.println("Suma:" + sum);
                return sum;
            } else {
                sum *= 10;
                totezdostanie *= 10;
                mnoznik *= 10;
            }

        }

//        while (true) {
//            if (sum % modulo ==0) {
//                    if (totezdostanie % modulo == 0) {
//                        System.out.println("Suma:" + sum);
//                        return (sum + totezdostanie) / mnoznik;
//                    }
//                    else {
//                        sum*=10;
//                        totezdostanie *= 10;
//                        mnoznik *= 10;
//                    }
//            } else {
//                sum*=10;
//                mnoznik *= 10;
//                totezdostanie *= 10;
//            }
//        }

    }
}
