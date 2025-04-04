package test;

import app.MenstrualApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMenstrualApp {

    @Test
    @DisplayName("Test that ovulation date is valid")
    public void testValidOvulationDate() {
        MenstrualApp app = new MenstrualApp("2025-10-06", 28);
        LocalDate ovulationDate = LocalDate.parse("2025-11-03");
        assertEquals(ovulationDate, app.getOvulationDate() );
    }

}