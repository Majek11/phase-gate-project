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
        MenstrualApp app = new MenstrualApp("2025-10-06", 28);
        LocalDate ovulationDate = LocalDate.parse("2025-10-20");
        assertEquals(ovulationDate, app.getOvulationDate() );
    }

    @Test
    @DisplayName("Test that ovulation date is valid for a 14-day cycle")
    public void testValidOvulationDateFor14Days() {
        MenstrualApp app = new MenstrualApp("2025-10-06", 14);
        LocalDate ovulationDate = LocalDate.parse("2025-10-13");
        assertEquals(ovulationDate, app.getOvulationDate() );
    }

    @Test
    @DisplayName("Test to calculate safe period")
    public void testToCalculateSafePeriod() {
        MenstrualApp app = new MenstrualApp("2025-10-06",  28);
        LocalDate safePeriodStart = LocalDate.parse("2025-10-06");
        LocalDate safePeriodEnd = LocalDate.parse("2025-10-13");

    }


}