package vitals;
    
public class Main implements BatteryParameters{
    static boolean batteryIsOk(boolean temperature, boolean soc, boolean chargeRate) {
        if(temperature && soc && chargeRate) {
        return true;
        }
        else return false;
    }
    
    public boolean tempCheck(float temperature){
         if(temperature < 0 || temperature > 45) {
             System.out.println("Temperature is out of range!");
             return false;
         }
        return true;
    }
    
    public boolean socCheck(float soc){
        if(soc < 20 || soc > 80) {
            System.out.println("State of Charge is out of range!");
            return false;
        }
        return true;
    }
    
    public boolean chargeRateCheck(float chargeRate){
        if(chargeRate > 0.8) {
            System.out.println("Charge Rate is out of range!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BatteryParameters mI = new simpleMonitor();
        assert(batteryIsOk(mI.tempCheck(50), mI.socCheck(85), mI.chargeRateCheck(0.0f) == false));
        assert(batteryIsOk(mI.tempCheck(42), mI.socCheck(70), mI.chargeRateCheck(0.07f) == true));
        System.out.println("Some more tests needed");
    }
}



