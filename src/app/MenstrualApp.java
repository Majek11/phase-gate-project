package app;
import java.time.LocalDate;

public class MenstrualApp {
    private LocalDate lastMenstrualPeriodDate;
    private int lengthOfMenstruationCycle;
    private int menstruationDuration;
    private int daysBetweenOvulationAndMenstruation;


    public MenstrualApp(String ovulationDate, int lengthOfMenstruationCycle) {
        this.lastMenstrualPeriodDate = LocalDate.parse(ovulationDate);
        this.lengthOfMenstruationCycle = lengthOfMenstruationCycle;
        this.menstruationDuration = 5;
        this.daysBetweenOvulationAndMenstruation = 0;
    }

    public LocalDate getOvulationDate() {
        return lastMenstrualPeriodDate.plusDays(lengthOfMenstruationCycle / 2);
    }
}