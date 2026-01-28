
import java.util.Scanner;

public class GablersRuin {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("What is your starting money: ");
        int startAmount = in.nextInt();
        int startAmount2 = startAmount;

        System.out.println("What is the chance of winning? (between 0 and 1) ");
        double winChance = in.nextDouble();

        System.out.println("How much money do you want to win? ");
        int winLimit = in.nextInt();

        System.out.println("How many days you wanna gamble? ");
        int days = in.nextInt();
        int totaldays = 0;
        int totalLosses = 0;
        while (totaldays < days) {
            int totalSimulations = 0;
            startAmount = startAmount2;
            totaldays++;
            while ((startAmount > 0) && (startAmount < winLimit)) {
                totalSimulations++;
                if (Math.random() <= winChance) {

                    startAmount++;
                    //System.out.println("You've Won! Now have: " + startAmount);

                } else {
                    startAmount--;
                    //System.out.println("You've Lost...   :( Now have: " + startAmount);
                }

            }
            if (startAmount == winLimit) {
                System.out.println("Simulation " + totaldays + ": " + totalSimulations + "WIN");

            } else {
                System.out.println("Simulation " + totaldays + ": " + totalSimulations + "LOSE");
                totalLosses++;
            }

        }
        double alpha = (1 - winChance) / winChance;
        double expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
        double simulationRate = (double) (totalLosses) / totaldays;
        System.out.println("Losses: " + totalLosses + "Days: " + totaldays);
        System.out.println("Expected Ruin Rate: " + expectedRuin);
        System.out.println("Simulation Ruin Rate: " + simulationRate);
    }
}
