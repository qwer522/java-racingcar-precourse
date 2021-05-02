import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGroup {

    private final int WINNER_INDEX = 0;
    private final List<Car> cars;

    public RacingGroup(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void racingStart() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public List<Car> getWinner() {
        List<Car> winner = new ArrayList<>();
        Collections.sort(cars);
        for (Car car : cars) {
            winnerCondition(winner, car);
        }
        return winner;
    }

    private void winnerCondition(List<Car> winner, Car car) {
        if (cars.get(WINNER_INDEX).getMoveCount() == car.getMoveCount()) {
            winner.add(car);
        }
    }

}
