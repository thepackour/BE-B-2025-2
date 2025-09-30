package racingcar;

import java.util.ArrayList;

public class Car {
    private final String name;
    private int moved = 0;
    private static ArrayList<Car> cars = new ArrayList<Car>();

    public static ArrayList<Car> get_cars() { return cars; }

    public String get_name() { return name; }

    public int get_moved() { return moved; }

    public Car(String name) {
        this.name = name;
    }
}
