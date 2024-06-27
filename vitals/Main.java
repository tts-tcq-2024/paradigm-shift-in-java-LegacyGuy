package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        boolean isTemperatureValid = (temperature >= 0) && (temperature <= 45);
        boolean isSocValid = (soc >= 20) && (soc <= 80);
        boolean isChargeRateValid = (chargeRate <= 0.8);

        return isTemperatureValid && isSocValid && isChargeRateValid;
    }

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");
    }
}
