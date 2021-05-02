import exception.CarNameException;

public class Car implements Comparable<Car> {

    private final int MAX_NAME_LENGTH = 5;
    private final int DEFAULT_MIN_MOVE_NUMBER = 4;
    private String name;
    private int moveCount = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        if (Random.getRandomNumber() >= DEFAULT_MIN_MOVE_NUMBER) {
            moveForward();
        }
    }

    public String getMoveDraw() {
        StringBuilder move = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            move.append("-");
        }
        return move.toString();
    }

    private void moveForward() {
        moveCount++;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CarNameException("자동자 이름이 유효한 글자 수를 초과하였습니다. 입력된 이름 글자 수 : " + name.length());
        }
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.getMoveCount(), moveCount);
    }

}