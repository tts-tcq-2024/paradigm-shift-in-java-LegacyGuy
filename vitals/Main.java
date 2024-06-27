package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        boolean isTemperatureOk = temperature >= 0 && temperature <= 45;
        boolean isSocOk = soc >= 20 && soc <= 80;
        boolean isChargeRateOk = chargeRate <= 0.8;

        if (!isTemperatureOk) {
            System.out.println("Temperature is out of range!");
        }
        if (!isSocOk) {
            System.out.println("State of Charge is out of range!");
        }
        if (!isChargeRateOk) {
            System.out.println("Charge Rate is out of range!");
        }

        return isTemperatureOk && isSocOk && isChargeRateOk;
    }

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");
    }
}
