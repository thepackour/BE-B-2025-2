package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Car {
    private final String name;
    private int moved = 0;
    private static ArrayList<Car> cars = new ArrayList<>();

    public static ArrayList<Car> get_cars() { return cars; }

    public static void move_cars() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) car.move();
        }
    }

    public static void create_car(String name) {
        cars.add(new Car(name));
    }

    public String get_name() { return name; }

    public int get_moved() { return moved; }

    private void move() { this.moved++; }

    private Car(String name) {
        this.name = name;
    }
}
