package app;

import java.time.LocalDate;
import java.util.Scanner;

public class MenstrualApp {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter the date of the last menstrual period (yyyy-MM-dd): ");
        String ovulationDate = userInput.nextLine();

        while (true) {
            try {
                LocalDate.parse(ovulationDate);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date. Please enter a valid date (yyyy-MM-dd): ");
                ovulationDate = userInput.nextLine();
            }
        }

        System.out.println("Enter the length of the menstruation cycle (in days): ");
        int lengthOfMenstruationCycle = userInput.nextInt();

        System.out.println("Enter the length of menstruation duration (in days): ");
        int menstruationDuration = userInput.nextInt();

        System.out.println("Enter the number of days before ovulation for the safe period: ");
        int safePeriodBeforeOvulation = userInput.nextInt();

        System.out.println("Enter the number of days after ovulation for the safe period: ");
        int safePeriodAfterOvulation = userInput.nextInt();

        MenstrualApp app = new MenstrualApp(ovulationDate, lengthOfMenstruationCycle, menstruationDuration, safePeriodBeforeOvulation, safePeriodAfterOvulation);

        System.out.println("The ovulation date is: " + app.getOvulationDate());
        System.out.println("The next period (flow date) starts on: " + app.getNextPeriodDate());
        LocalDate[] safePeriod = app.getSafePeriod();
        System.out.println("The safe period starts on: " + safePeriod[0] + " and ends on: " + safePeriod[1]);
        LocalDate[] fertilityWindow = app.getFertileDays();
        System.out.println("The fertility window is from: " + fertilityWindow[0] + " to: " + fertilityWindow[1]);
    }

    private final LocalDate lastMenstrualPeriodDate;
    private final int lengthOfMenstruationCycle;
    private final int safePeriodBeforeOvulation;

    public MenstrualApp(String ovulationDate, int lengthOfMenstruationCycle, int menstruationDuration, int safePeriodBeforeOvulation, int safePeriodAfterOvulation) {
        this.lastMenstrualPeriodDate = LocalDate.parse(ovulationDate);
        this.lengthOfMenstruationCycle = lengthOfMenstruationCycle;
        this.safePeriodBeforeOvulation = safePeriodBeforeOvulation;
    }

    public LocalDate getOvulationDate() {
        return lastMenstrualPeriodDate.plusDays(lengthOfMenstruationCycle / 2);
    }

    public LocalDate getNextPeriodDate() {
        return lastMenstrualPeriodDate.plusDays(lengthOfMenstruationCycle);
    }

    public LocalDate[] getSafePeriod() {
        LocalDate ovulationDate = getOvulationDate();
        LocalDate safeStart = ovulationDate.minusDays(safePeriodBeforeOvulation);
        LocalDate safeEnd = ovulationDate.minusDays(1);
        return new LocalDate[]{safeStart, safeEnd};
    }

    public LocalDate[] getFertileDays() {
        LocalDate ovulationDate = getOvulationDate();
        LocalDate fertileStart = ovulationDate.minusDays(5);
        LocalDate fertileEnd = ovulationDate.plusDays(1);
        return new LocalDate[]{fertileStart, fertileEnd};
    }
}
