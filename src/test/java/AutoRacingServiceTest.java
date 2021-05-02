import exception.CarNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AutoRacingServiceTest {

    private AutoRacingService autoRacingService;

    @BeforeEach
    public void setup() {
        autoRacingService = new AutoRacingService();
    }

    @Test
    public void 자동차_콤마_구분_정상_생성() {
        List<Car> cars = autoRacingService.convertToCarForInputValue(
                "car1,car2,car3,car4,car5"
        );
        assertThat(cars.size() == 5).isTrue();
    }

    @Test
    public void 자동차_유효_길이_초과() {
        try {
            List<Car> cars = autoRacingService.convertToCarForInputValue(
                    "car1,car2,car3,car4,car12345"
            );
        } catch (CarNameException e) {
            assertThat(true).isTrue();
        } catch (Exception e) {
            assertThat(false).isTrue();
        }
    }

}