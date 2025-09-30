package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    private static ArrayList<String> car_name_list = new ArrayList<>();
    private static int loop;
    private static Scanner input = new Scanner(System.in);

    public static void add_car_names(String name) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] names = input.nextLine().split(",");
        Arrays.stream(names)
                .forEach(s -> {
                    if (s.length() > 5) throw new IllegalArgumentException();
                    else car_name_list.add(s);
                });
    }

    private Controller() {}
}
