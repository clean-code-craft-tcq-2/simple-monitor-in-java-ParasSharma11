package vitals;
    
public class Main implements monitorInterface{
    static boolean batteryIsOk(float temperature, float soc, float chargeRate, monitorInterface mI) {
        if(mI.tempCheck(temperature) && mI.socCheck(soc) && mI.chargeRateCheck(chargeRate)) {
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
        monitorInterface mI = new simpleMonitor();
        assert(batteryIsOk(42,70,0.07f,mI) == true);
        assert(batteryIsOk(50, 85, 0.0f,mI) == false);
        //java -ea alerter.java
        System.out.println("Some more tests needed");
    }
}


