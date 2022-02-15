package vitals;
    
public class Main{
    static boolean batteryIsOk(float temperature, float  soc, float chargeRate) {
            Temperature tempObj = ( float value) -> tempCheck(value);
            soc socObj = (float value) -> socCheck(value);
            chargeRate chargeRateObj = ( float value) -> chargeRateCheck(value);
            
            return tempObj.Check(temperature) && socObj.Check(soc) && chargeRateObj.Check(chargeRate);
            }
    static void print(String msg) {
        System.out.println(msg);
    }
    interface Temperature {
        boolean Check(final float temp);
    }

    interface soc {
        boolean Check(final float temp);
    }

    interface chargeRate {
        boolean Check(final float temp);
    }

    static boolean checkRange(float low, float high, float value) {
        if (value < low || value > high)
            return true;
        else
            return false;
    }
    static boolean warnOnUpperLimit(final float batteryCondition, final float upperLimit){
        return batteryCondition >= (upperLimit - 0.05*upperLimit);
        
    }
    static boolean warnOnLowerLimit(final float batteryCondition, final float lowerLimit){
        return batteryCondition <= (lowerLimit + 0.05*lowerLimit);
        
    }
      static void checkWaringForupperAndLowerLimit(final float batteryCondition, final float lowerLimit, final float upperLimit) {
          if(warnOnUpperLimit(batteryCondition,upperLimit)) {
              print("Warning reaching to upper value");
          }
          if(warnOnLowerLimit(batteryCondition,lowerLimit)) {
              print("Warning reaching to lower value");
          }
       }

    static boolean tempCheck(float temperature) {
        checkWaringForupperAndLowerLimit(temperature,0,45);
        if (checkRange(0,45,temperature)) {
            print("Temperature is out of range!");
            return false;
        }
        return true;
    }

    static boolean socCheck(float soc) {
        checkWaringForupperAndLowerLimit(soc,0,45);
        if (checkRange(20,80,soc)) {
            print("soc is out of range!");
            return false;
        }
        return true;
    }

    static boolean chargeRateCheck(float chargeRate) {
        if (chargeRate > 0.8) {
            print("Charge Rate is out of range!");
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



