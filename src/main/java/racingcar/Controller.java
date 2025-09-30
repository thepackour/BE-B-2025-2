package racingcar;

import javax.swing.text.html.Option;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Controller {
    private static ArrayList<String> car_name_list = new ArrayList<>();
    private static int loop;

    public static void add_car_names() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] names = readLine().split(",");
        if (names.length == 0) throw new IllegalArgumentException();
        Arrays.stream(names)
                .forEach(s -> {
                    if (s.length() > 5) throw new IllegalArgumentException();
                    else car_name_list.add(s);
                });
    }

    public static void set_loop() {
        System.out.println("시도할 회수는 몇회인가요?");
        String num = readLine();
        try { loop = Integer.parseInt(num); }
        catch (NumberFormatException e) { throw new IllegalArgumentException(); }
    }

    public static void print_progress() {
        ArrayList<Car> cars = Car.get_cars();
        for (Car car : cars) {
            String name = car.get_name();
            int moved = car.get_moved();

            System.out.print(name + " : " + "-".repeat(moved));
        }
        System.out.println();
    }

    public static void print_winners() {
        ArrayList<Car> cars = Car.get_cars();
        Optional<Integer> max = cars.stream()
                .map(Car::get_moved)
                .max(Integer::compareTo);
        if (max.isEmpty()) System.out.println("오류가 발생했습니다.");
        else {
            String res = cars.stream()
                    .filter(car -> car.get_moved() == max.get())
                    .map(Car::get_name)
                    .collect(Collectors.joining(", "));
            System.out.println("최종 우승자 : " + res);
        }
    }

    public static void start_race() {
        add_car_names();
        car_name_list.forEach(Car::create_car);

        set_loop();
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < loop; i++) {
            Car.move_cars();
            print_progress();
        }
        print_winners();
    }

    private Controller() {}
}
