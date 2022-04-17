package aoc.y2021.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public final class Utilss {

    private Utilss() {

    }

    public static <T> List<T> readFileLineByLine(String pathname, Function<String, T> convert) {
        List<T> contents = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(pathname))) {
            while (sc.hasNextLine()) {
                contents.add(convert.apply(sc.nextLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

}
