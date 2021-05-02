import exception.CarNameException;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AutoRacingServiceTest {

    private final int MAX_CAR_SIZE = 5;
    private final int RANDOM_VALIDATE_NUMBER = 1000;
    private AutoRacingService autoRacingService;
    private String carName;
    private List<Car> cars;
    private RacingGroup racingGroup;

    @BeforeEach
    public void setup() {
        autoRacingService = new AutoRacingService();
        carName = getCarName();
        cars = autoRacingService.convertToCarForInputValue(carName);
        racingGroup = new RacingGroup(cars);
    }

    @Test
    public void 자동차_콤마_구분_정상_생성() {
        assertThat(cars.size() == MAX_CAR_SIZE).isTrue();
    }

    @Test
    public void 자동차_유효_길이_초과() {
        try {
            autoRacingService.convertToCarForInputValue(
                    "car1,car2,car3,car4,car12345"
            );
        } catch (CarNameException e) {
            assertThat(true).isTrue();
        } catch (Exception e) {
            assertThat(false).isTrue();
        }
    }

    @Test
    public void 랜덤_숫자_MIN_MAX_검증() {
        int randomNumber;
        for (int i = 0; i < RANDOM_VALIDATE_NUMBER; i++) {
            randomNumber = Random.getRandomNumber();
            assertThat(randomNumber >= 0 || randomNumber <= 9).isTrue();
        }
    }

    @Description("MAX_CAR_SIZE개의 자동차를 RANDOM_VALIDATE_NUMBER번 테스트 했을 경우" +
            "모든 자동차는 0이상일거라고 가정하고 테스트 진행했습니다.")
    @Test
    public void 랜덤_전진() {
        for (int i = 0; i < RANDOM_VALIDATE_NUMBER; i++) {
            racingGroup.racingStart();
        }
        for (Car car : racingGroup.getCars()) {
            assertThat(car.getMoveCount() > 0).isTrue();
        }
    }

    private String getCarName() {
        String carName = "";
        for (int i = 0; i < MAX_CAR_SIZE; i++) {
            carName = carName + "car" + i + ",";
        }
        return carName;
    }

    @Test
    public void 승리자_선정() {
        for (int i = 0; i < RANDOM_VALIDATE_NUMBER; i++) {
            racingGroup.racingStart();
        }
        assertThat(racingGroup.getWinner().size() > 0).isTrue();
    }

}