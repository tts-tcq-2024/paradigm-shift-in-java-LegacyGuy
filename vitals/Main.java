package vitals;

import java.util.HashMap;
import java.util.Map;

class BatteryChecker {
    static String language = "EN"; // Default language

    // Messages for different languages
    static Map<String, Map<String, String>> messages = new HashMap<String, Map<String, String>>() {{
        put("EN", new HashMap<String, String>() {{
            put("LOW_TEMPERATURE", "Temperature is too low");
            put("HIGH_TEMPERATURE", "Temperature is too high");
            put("LOW_SOC", "State of Charge is too low");
            put("HIGH_SOC", "State of Charge is too high");
            put("LOW_CHARGE_RATE", "Charge Rate is too low");
            put("HIGH_CHARGE_RATE", "Charge Rate is too high");
            put("LOW_TEMPERATURE_WARNING", "Warning: Approaching low temperature");
            put("HIGH_TEMPERATURE_WARNING", "Warning: Approaching high temperature");
            put("LOW_SOC_WARNING", "Warning: Approaching discharge");
            put("HIGH_SOC_WARNING", "Warning: Approaching charge peak");
            put("LOW_CHARGE_RATE_WARNING", "Warning: Approaching low charge rate");
            put("HIGH_CHARGE_RATE_WARNING", "Warning: Approaching high charge rate");
        }});
        put("DE", new HashMap<String, String>() {{
            put("LOW_TEMPERATURE", "Temperatur ist zu niedrig");
            put("HIGH_TEMPERATURE", "Temperatur ist zu hoch");
            put("LOW_SOC", "Ladezustand ist zu niedrig");
            put("HIGH_SOC", "Ladezustand ist zu hoch");
            put("LOW_CHARGE_RATE", "Laderate ist zu niedrig");
            put("HIGH_CHARGE_RATE", "Laderate ist zu hoch");
            put("LOW_TEMPERATURE_WARNING", "Warnung: Annäherung an niedrige Temperatur");
            put("HIGH_TEMPERATURE_WARNING", "Warnung: Annäherung an hohe Temperatur");
            put("LOW_SOC_WARNING", "Warnung: Annäherung an Entladung");
            put("HIGH_SOC_WARNING", "Warnung: Annäherung an Ladehöhepunkt");
            put("LOW_CHARGE_RATE_WARNING", "Warnung: Annäherung an niedrige Laderate");
            put("HIGH_CHARGE_RATE_WARNING", "Warnung: Annäherung an hohe Laderate");
        }});
    }};

    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return isParameterOk("Temperature", temperature, 0, 45, 2.25f) &&
               isParameterOk("State of Charge", soc, 20, 80, 4) &&
               isParameterOk("Charge Rate", chargeRate, 0, 0.8f, 0.04f);
    }

    static boolean isParameterOk(String parameter, float value, float min, float max, float warningTolerance) {
        return !isCritical(parameter, value, min, max) && !isWarning(parameter, value, min, max, warningTolerance);
    }

    static boolean isCritical(String parameter, float value, float min, float max) {
        if (value < min) {
            System.out.println(getMessage(parameter, "LOW"));
            return true;
        } else if (value > max) {
            System.out.println(getMessage(parameter, "HIGH"));
            return true;
        }
        return false;
    }

    static boolean isWarning(String parameter, float value, float min, float max, float warningTolerance) {
        if (value < min + warningTolerance) {
            System.out.println(getMessage(parameter, "LOW_WARNING"));
            return true;
        } else if (value > max - warningTolerance) {
            System.out.println(getMessage(parameter, "HIGH_WARNING"));
            return true;
        }
        return false;
    }

    static String getMessage(String parameter, String condition) {
        String key = condition + "_" + parameter.toUpperCase().replace(" ", "_");
        return messages.get(language).getOrDefault(key, "Unknown condition");
    }

    public static void main(String[] args) {
        language = "EN"; // Switch to "DE" for German
        assert (batteryIsOk(25, 70, 0.7f) == true);
        assert (batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("All tests passed.");
    }
}
