package vitals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BatteryCheckerTest {

    @Test
    void testBatteryIsOk() {
        BatteryChecker checker = new BatteryChecker("EN");
        assertTrue(checker.batteryIsOk(25, 70, 0.7f));
        assertFalse(checker.batteryIsOk(50, 85, 0.0f));
    }

    @Test
    void testWarningSystem() {
        BatteryChecker checker = new BatteryChecker("EN");
        checker.setWarningForTemperature(false);
        assertTrue(checker.batteryIsOk(5, 70, 0.7f)); // Warning disabled for temperature
        checker.setWarningForTemperature(true);
        assertFalse(checker.batteryIsOk(5, 70, 0.7f)); // Warning enabled for temperature
    }

    @Test
    void testLanguageChange() {
        BatteryChecker checker = new BatteryChecker("DE");
        String message = LanguageSupport.getMessage("DE", "Temperature", "LOW");
        assertEquals("Temperatur ist zu niedrig", message);
    }

    @Test
    void testGetColorManual() {
        BatteryChecker checker = new BatteryChecker("EN");
        StringBuilder manual = checker.getColorManual();
        assertTrue(manual.toString().contains("Temperature is too low"));
        assertTrue(manual.toString().contains("State of Charge is too low"));
    }
}
