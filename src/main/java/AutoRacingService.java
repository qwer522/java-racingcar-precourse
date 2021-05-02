import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AutoRacingService {

    private Scanner scanner;

    public void start() {
        RacingGroup racingGroup = inputCarName();

        int executeCount = inputExecuteCount();

        racingAndPrint(racingGroup, executeCount);

        winnerPrint(racingGroup);
    }

    private void racingAndPrint(RacingGroup racingGroup, int executeCount) {
        for (int i = 0; i < executeCount; i++) {
            racingGroup.racingStart();
            System.out.println(racingGroup.getRacingDraw());
        }
    }

    private int inputExecuteCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private RacingGroup inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        scannerInit();
        return new RacingGroup(convertToCarForInputValue(scanner.next()));
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

    private List<String> splitToCommaForInputValue(String inputValue) {
        return Arrays.asList(inputValue.split(","));
    }

    private void winnerPrint(RacingGroup racingGroup) {
        System.out.println(String.join(", ", racingGroup.getWinnerName()) + "가 최종 우승했습니다.");
    }

}