package app;
import java.time.LocalDate;

public class MenstrualApp {
    private LocalDate lastMenstrualPeriodDate;
    private int lengthOfOvulationCycle;
    private int lengthOfMenstruationCycle;
    private int menstruationDuration;
    private int daysBetweenOvulationAndMenstruation;


    public MenstrualApp(String ovulationDate, int lengthOfOvulationCycle) {
        this.lastMenstrualPeriodDate = LocalDate.parse(ovulationDate);
        this.lengthOfOvulationCycle = lengthOfOvulationCycle;
        this.menstruationDuration = 5;
        this.lengthOfMenstruationCycle = 28;
        this.daysBetweenOvulationAndMenstruation = 0;
    }

    public LocalDate getLastMenstrualPeriodDate() {
        return lastMenstrualPeriodDate;
    }

    public LocalDate getOvulationDate() {
        return lastMenstrualPeriodDate.plusDays(lengthOfOvulationCycle);
    }
}