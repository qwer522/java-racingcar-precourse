import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public String getRacingDraw() {
        StringBuilder racingResult = new StringBuilder();
        for (Car car : this.cars) {
            racingResult.append(car.getName());
            racingResult.append(": ");
            racingResult.append(car.getMoveDraw());
            racingResult.append("\n");
        }
        return racingResult.toString();
    }

    public List<String> getWinnerName() {
        List<String> winner = new ArrayList<>();
        Collections.sort(cars, Comparator.comparingInt(Car::getMoveCount).reversed());
        for (Car car : cars) {
            winnerCondition(winner, car);
        }
        return winner;
    }

    private void winnerCondition(List<String> winner, Car car) {
        if (cars.get(WINNER_INDEX).getMoveCount() == car.getMoveCount()) {
            winner.add(car.getName());
        }
    }

}
