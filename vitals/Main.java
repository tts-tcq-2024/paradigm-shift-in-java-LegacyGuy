package vitals;

public class Main {
    public static void main(String[] args) {
        BatteryChecker.language = "EN"; // Switch to "DE" for German
        assert (BatteryChecker.batteryIsOk(25, 70, 0.7f) == true);
        assert (BatteryChecker.batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("All tests passed.");
    }
}
