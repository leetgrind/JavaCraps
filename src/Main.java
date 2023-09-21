import java.security.SecureRandom;

public class Main {

    static SecureRandom secureRandom = new SecureRandom();

    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int SEVEN = 7; // won
    private static final int ELEVEN = 11; // won
    private static final int TWELVE = 12;

    public static void main(String[] args) {

        GameStatus gameStatus;

        int rollValue = rollTwoDice();
        int pointValue = 0;

        //7 and 11 you win
        // 2, 3 or 12 you lose
        switch (rollValue) {

            case SEVEN:
            case ELEVEN:
                gameStatus = GameStatus.WON;
                break;

            case TWO:
            case THREE:
            case TWELVE:
                gameStatus = GameStatus.LOST;
                break;

            default:
                // if roll value is 4, 5, 6, 8, 9, 10
                gameStatus = GameStatus.CONTINUE;
                pointValue = rollValue;
                break;
        }

        // until the game status is Continue don't stop
        while(gameStatus == GameStatus.CONTINUE) {

            // roll the dice again
            rollValue = rollTwoDice();

            // if you make the point you won
            if(rollValue == pointValue) {
                gameStatus = GameStatus.WON;
                break;
            }

            // if you roll 7 you lose

            if (rollValue == SEVEN) {
                gameStatus = GameStatus.LOST;
                break;
            }
        }

        if(gameStatus == GameStatus.WON) {
            System.out.println("Congratulations you won");
        }
        else {
            System.out.println("Sorry you lose");
        }

    }

    public static int rollTwoDice() {

        int die1 = 1 + secureRandom.nextInt(6);
        int die2 = 1 + secureRandom.nextInt(6);
        int sum = die1 + die2;
        System.out.printf("Dice rolled with values: %d, %d. Total: %d\n", die1, die2, sum);
        return sum;
    }

}