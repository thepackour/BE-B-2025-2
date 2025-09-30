package racingcar;

import java.util.ArrayList;

public class Car {
    private final String name;
    private int moved = 0;
    private static ArrayList<Car> cars = new ArrayList<Car>();

    public Car(String name) {
        this.name = name;
    }
}
