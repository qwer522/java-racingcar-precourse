import com.sun.tools.javac.util.Convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AutoRacingService {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = convertToCarForInputValue(scanner.next());
    }
    public List<Car> convertToCarForInputValue(String inputValue) {
        List<Car> cars = new ArrayList<>();
        for (String carName : splitToCommaForInputValue(inputValue)) {
            cars.add(new Car(carName));
        }
        return cars;
    }
    public List<String> splitToCommaForInputValue(String inputValue) {
        return Arrays.asList(inputValue.split(","));
    }
}