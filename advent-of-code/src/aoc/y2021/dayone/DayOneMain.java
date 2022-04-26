package aoc.y2021.dayone;

import java.util.Iterator;
import java.util.List;

import aoc.y2021.utils.Utilss;

public class DayOneMain {

    private static int partOne(List<Integer> nums) {
        int count = 0;
        Iterator<Integer> iterator = nums.iterator();
        int prev = iterator.next();
        while (iterator.hasNext()) {
            int input = iterator.next();
            if (prev < input) {
                count++;
            }
            prev = input;
        }
        return count;
    }

    private static int partTwo(List<Integer> nums) {
        int incCount = 0;
        for (int i = 0; i < nums.size() - 3; i++) {
            int currSum = nums.get(i) + nums.get(i + 1) + nums.get(i + 2);
            int nextSum = nums.get(i + 1) + nums.get(i + 2) + nums.get(i + 3);
            if (currSum < nextSum) {
                incCount++;
            }
        }
        return incCount;
    }

    public static void main(String[] args) {
        final var input = Utilss.readFileLineByLine("one", Integer::parseInt);
        System.out.println(partOne(input));
        System.out.println(partTwo(input));
    }
}
