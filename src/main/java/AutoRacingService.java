import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AutoRacingService {

    private Scanner scanner;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        scannerInit();
        List<Car> cars = convertToCarForInputValue(scanner.next());

        System.out.println("시도할 회수는 몇회인가요?");
        RacingGroup racingGroup = new RacingGroup(cars);

        for (int i = 0; i < scanner.nextInt(); i++) {
            racingGroup.racingStart();
        }

    }

    private void scannerInit() {
        scanner = new Scanner(System.in);
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