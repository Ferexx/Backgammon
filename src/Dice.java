import java.util.Random;

public class Dice{

    Dice(){
        Random random =  new Random();
        int diceRoll1 = random.nextInt(6) + 1;
        int diceRoll2 = random.nextInt(6) + 1;
        System.out.println("\nYour dice rolls are " +diceRoll1 + " and " +diceRoll2);
    }
}