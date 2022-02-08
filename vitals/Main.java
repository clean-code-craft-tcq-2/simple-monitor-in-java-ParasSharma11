package vitals;
    
public class Main implements BatteryParameters{
    static boolean batteryIsOk(boolean temperature, boolean soc, boolean chargeRate) {
        return temperature && soc && chargeRate;
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
          testSimpleMonitor test = new testSimpleMonitor();
             test.temperature_validation();
             test.SOC_validation();
             test.Charge_rate_validation();
             test.test_battery_ok1();
    }
}



