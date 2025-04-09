package test;

import app.MenstrualApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMenstrualApp {

    @Test
    @DisplayName("Test that ovulation date is valid for a 28-day cycle")
    public void testValidOvulationDateFor28Days() {
        MenstrualApp app = new MenstrualApp("2025-10-06", 28, 5, 7, 1);
        LocalDate ovulationDate = LocalDate.parse("2025-10-20");
        assertEquals(ovulationDate, app.getOvulationDate() );
    }

    @Test
    @DisplayName("Test that ovulation date is valid for a 14-day cycle")
    public void testValidOvulationDateFor14Days() {
        MenstrualApp app = new MenstrualApp("2025-10-06", 14, 5, 7, 1);
        LocalDate ovulationDate = LocalDate.parse("2025-10-13");
        assertEquals(ovulationDate, app.getOvulationDate() );
    }


    @Test
    @DisplayName("Test to calculate the next period date for 28-day cycle")
    public void testToCalculateNextPeriodFor28Days() {
        MenstrualApp app = new MenstrualApp("2025-10-06", 28, 5, 7, 1);
        LocalDate expectedNextPeriod = LocalDate.parse("2025-11-03");
        assertEquals(expectedNextPeriod, app.getNextPeriodDate());
    }
    @Test
    @DisplayName("Test to calculate safe period with user-defined values")
    public void testSafePeriodWithUserInput() {
        MenstrualApp app = new MenstrualApp("2025-10-06", 28, 5, 7, 1);

        LocalDate expectedOvulationDate = LocalDate.parse("2025-10-20");
        assertEquals(expectedOvulationDate, app.getOvulationDate());

        LocalDate[] safePeriod = app.getSafePeriod();
        LocalDate expectedSafeStart = LocalDate.parse("2025-10-13");
        LocalDate expectedSafeEnd = LocalDate.parse("2025-10-19");

        assertEquals(expectedSafeStart, safePeriod[0]);
        assertEquals(expectedSafeEnd, safePeriod[1]);
    }



}