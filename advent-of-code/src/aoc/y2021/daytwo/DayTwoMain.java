package aoc.y2021.daytwo;

import java.util.List;

import aoc.y2021.utils.Utilss;

enum Direction {
    forward,
    down,
    up
}

class Input {
    Direction direction;
    int value;

    public Input(Direction direction, int value) {
        this.direction = direction;
        this.value = value;
    }

    static Input usingLine(String input) {
        String[] split = input.split(" ");
        return new Input(Direction.valueOf(split[0]), Integer.parseInt(split[1]));
    }

    @Override
    public String toString() {
        return "{" +
                " direction='" + direction + "'" +
                ", value='" + value + "'" +
                "}";
    }
}

public class DayTwoMain {

    private static void partOne(List<Input> inputs) {
        int horiz = 0;
        int vert = 0;
        for (Input input : inputs) {
            switch (input.direction) {
                case forward:
                    horiz = horiz + input.value;
                    break;
                case up:
                    vert = vert - input.value;
                    break;
                case down:
                    vert = vert + input.value;
            }
        }
        System.out.println(horiz * vert);
    }

    private static void partTwo(List<Input> inputs) {
        int horiz = 0;
        int vert = 0;
        int aim = 0;
        for (Input input : inputs) {
            switch (input.direction) {
                case forward:
                    horiz = horiz + input.value;
                    vert = vert + aim * input.value;
                    break;
                case up:
                    aim -= input.value;
                    break;
                case down:
                    aim += input.value;
            }
        }
        System.out.println(horiz * vert);
    }

    public static void main(String... args) {
        List<Input> inputs = Utilss.readFileLineByLine("two", Input::usingLine);
        partOne(inputs);
        partTwo(inputs);
    }
}