package vitals;

public class Main {
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return checkAndReport("Temperature", temperature, 0, 45) &&
               checkAndReport("State of Charge", soc, 20, 80) &&
               checkAndReport("Charge Rate", chargeRate, 0, 0.8f);
    }

    static boolean checkAndReport(String parameter, float value, float min, float max) {
        if (value < min) {
            System.out.println(parameter + " is too low Value: " + value + ", Min: " + min);
            return false;
        } else if (value > max) {
            System.out.println(parameter + " is too high! Value: " + value + ", Max: " + max);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        assert (batteryIsOk(25, 70, 0.7f) == true);
        assert (batteryIsOk(50, 85, 0.0f) == false); 
        System.out.println("Some more tests needed");
    }
}
