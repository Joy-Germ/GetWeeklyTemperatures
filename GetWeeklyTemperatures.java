import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetWeeklyTemperatures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // I chose to prepopulate this to prevent user error.
        ArrayList<String> daysOfWeek = new ArrayList<>(
            Arrays.asList("monday", "tuesday", "wednesday", "thursday",
                          "friday", "saturday", "sunday"));

        ArrayList<Double> avgDailyTemp = new ArrayList<>();

        // I'm using the final as a control for the "for" loop.
        // "For" loops can only be used when the number of iterations is known.
        final int NUM_DAYS_OF_WEEK = 7;

        double sumOfAverageDailyTemps = 0;
        double averageDailyTempForWeek = 0;
        String userInput = "";

        // The retrievalIndex will capture the index associated with the day of the week
        // per the user request. Then the retrievalIndex will be used to retrieve the
        // associated index in the ArrayList with average temperatures.
        int retrievalIndex;
        
        // Data Collection Phase
        for (int i = 0; i < NUM_DAYS_OF_WEEK; i++) {
            System.out.print("Type the average temperature for " + daysOfWeek.get(i) + ": ");

            // This will ensure that the day of the week positioned at i corresponds
            // to the temperature positioned at i in the parallel ArrayList.
            Double temp = scanner.nextDouble();
            avgDailyTemp.add(temp);
        }

        // Average Calculation
        for (int i = 0; i < avgDailyTemp.size(); i++) {
            // Using .size() allows the code to respond to the fact that the ArrayList
            // is not fixed. The code will stay flexible and prevent bugs.
            sumOfAverageDailyTemps = sumOfAverageDailyTemps + avgDailyTemp.get(i);
        }

        // Calculating this outside of the loop is necessary to keep the formula accurate.
        averageDailyTempForWeek = sumOfAverageDailyTemps / avgDailyTemp.size();

        // Data Retrieval Phase
        System.out.print("Type a day to view its average temperature, 'week' for the weekly summary, or 'done' to exit: ");
        userInput = scanner.nextLine();
        userInput = userInput.toLowerCase();

        while (!userInput.equals("done")) {

            if (userInput.equals("week")) {
                for (int i = 0; i < daysOfWeek.size(); i++) {
                    System.out.println(daysOfWeek.get(i) + ": " + avgDailyTemp.get(i));
                }
                System.out.println("Weekly Average: " + averageDailyTempForWeek);
            }
            else if (daysOfWeek.contains(userInput)) {
                retrievalIndex = daysOfWeek.indexOf(userInput);
                System.out.println(daysOfWeek.get(retrievalIndex) + ": " + avgDailyTemp.get(retrievalIndex));
            }
            else {
                System.out.println("Value not recognized. Double check spelling or type 'done' to exit.");
            }

            // Re-prompt for userInput to prevent infinite loop from occurring.
            System.out.print("Enter a day, 'week', or 'done': ");
            userInput = scanner.nextLine();
            userInput = userInput.toLowerCase();
        }

    }
}