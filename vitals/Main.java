package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        String errorMessage = "";

        errorMessage += (temperature < 0 || temperature > 45) ? "Temperature is out of range!\n" : "";
        errorMessage += (soc < 20 || soc > 80) ? "State of Charge is out of range!\n" : "";
        errorMessage += (chargeRate > 0.8) ? "Charge Rate is out of range!\n" : "";

        if (!errorMessage.isEmpty()) {
            System.out.print(errorMessage);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");
    }
}
