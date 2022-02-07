package vitals;
public class testSimpleMonitor   {
    public static void main(String[] args) {
        simpleMonitor sM = new simpleMonitor();
        assert(sM.batteryIsOk(sM.tempCheck(50), sM.socCheck(85), sM.chargeRateCheck(0.0f)) == false);
        assert(sM.batteryIsOk(sM.tempCheck(42), sM.socCheck(70), sM.chargeRateCheck(0.07f) == true));
    }
}
