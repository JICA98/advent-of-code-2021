package aoc.y2021.daythree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import aoc.y2021.utils.Utilss;

class Pair {
    int one;
    int zero;

    public Pair(int one, int zero) {
        this.one = one;
        this.zero = zero;
    }

}

public class DayThreeMain {

    public static void main(String... args) {
        List<String> input = Utilss.readFileLineByLine("three");
        partOne(input);
        partTwo(input);
    }

    private static void partOne(List<String> inputList) {
        Map<Integer, Pair> countMap = new TreeMap<>();
        final int times = inputList.get(0).length();
        for (String input : inputList) {
            for (int i = 0; i < times; i++) {
                Pair pair = countMap.getOrDefault(i, new Pair(0, 0));
                if (input.charAt(i) == '0') {
                    pair.zero += 1;
                } else {
                    pair.one += 1;
                }
                countMap.put(i, pair);
            }
        }
        StringBuilder gammaBuilder = new StringBuilder();
        StringBuilder epsilonBuilder = new StringBuilder();
        for (Pair pair : countMap.values()) {
            gammaBuilder.append(pair.one > pair.zero ? "1" : "0");
            epsilonBuilder.append(pair.one > pair.zero ? "0" : "1");
        }
        System.out.println(Integer.parseInt(gammaBuilder.toString(), 2)
                * Integer.parseInt(epsilonBuilder.toString(), 2));
    }

    private static void partTwo(List<String> input) {
        String oxyRating = getRating(input, true);
        String co2Rating = getRating(input, false);
        // System.out.println(oxyRating);
        // System.out.println(co2Rating);
        System.out.println(Integer.parseInt(oxyRating, 2)
                * Integer.parseInt(co2Rating, 2));
    }

    private static String getRating(List<String> inputList, boolean useCommonBit) {
        int iteration = 0;
        List<String> filtered = new ArrayList<>(inputList);
        final int times = filtered.get(0).length();
        while (iteration < times) {
            if (filtered.size() == 1) {
                break;
            }
            // System.out.printf("%d - %d\n", iteration, filtered.size());
            Pair curPair = new Pair(0, 0);
            for (String input : filtered) {
                if (input.charAt(iteration) == '0') {
                    curPair.zero += 1;
                } else {
                    curPair.one += 1;
                }
            }
            final char mostCommonBit = curPair.one >= curPair.zero ? '1' : '0';
            final char leastCommonBit = curPair.zero <= curPair.one ? '0' : '1';
            final char filterBit = useCommonBit ? mostCommonBit : leastCommonBit;
            final int index = iteration;
            filtered = filtered.stream()
                    .filter((ele) -> ele.charAt(index) == filterBit)
                    .collect(Collectors.toList());
            iteration++;
        }
        return filtered.get(0);
    }

}
