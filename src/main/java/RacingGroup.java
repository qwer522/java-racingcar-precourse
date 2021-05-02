import java.util.List;

public class RacingGroup {

    private final List<Car> cars;

    public RacingGroup(List<Car> cars) {
        this.cars = cars;
    }

    public void racingStart() {
        for (Car car : this.cars) {
            car.move();
        }
    }

}
