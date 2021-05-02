import java.util.concurrent.ThreadLocalRandom;

public class Random {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int NAX_DEFAULT_NUMBER = 1;

    public static int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + NAX_DEFAULT_NUMBER) + MIN_NUMBER;
    }
}
