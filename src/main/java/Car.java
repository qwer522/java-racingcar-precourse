import exception.CarNameException;

public class Car {

    private final int NAME_MAX_LENGTH = 5;

    private String name;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            System.out.println("dddd");
            throw new CarNameException("자동자 이름이 유효한 글자 수를 초과하였습니다. 입력된 이름 글자 수 : " + name.length());
        }
    }

    public String getName() {
        return name;
    }

}
