package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private static ArrayList<String> car_name_list = new ArrayList<>();
    private static int loop;

    public static void add_car_names() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] names = readLine().split(",");
        Arrays.stream(names)
                .forEach(s -> {
                    if (s.length() > 5) throw new IllegalArgumentException();
                    else car_name_list.add(s);
                });
    }

    public static void set_loop() {
        String num = readLine();
        try { loop = Integer.parseInt(num); }
        catch (NumberFormatException e) { throw new IllegalArgumentException(); }
    }

    public static void print_progress() {
        ArrayList<Car> cars = Car.get_cars();
        for (Car car : cars) {
            String name = car.get_name();
            int moved = car.get_moved();

            System.out.print(name + " : ");
            System.out.println("-".repeat(moved));
        }
        System.out.println();
    }

    private Controller() {}
}
