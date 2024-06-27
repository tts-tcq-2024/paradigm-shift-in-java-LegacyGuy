package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return isTemperatureOk(temperature) && isSocOk(soc) && isChargeRateOk(chargeRate);
    }

    static boolean isTemperatureOk(float temperature) {
        boolean isOk = temperature >= 0 && temperature <= 45;
        if (!isOk) {
            System.out.println("Temperature is out of range!");
        }
        return isOk;
    }

    static boolean isSocOk(float soc) {
        boolean isOk = soc >= 20 && soc <= 80;
        if (!isOk) {
            System.out.println("State of Charge is out of range!");
        }
        return isOk;
    }

    static boolean isChargeRateOk(float chargeRate) {
        boolean isOk = chargeRate <= 0.8;
        if (!isOk) {
            System.out.println("Charge Rate is out of range!");
        }
        return isOk;
    }

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");
    }
}
