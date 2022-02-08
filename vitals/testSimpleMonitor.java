package vitals;
public class testSimpleMonitor   {
    simpleMonitor mI = new simpleMonitor();
    public void  test_temperature_ok(float temperature,boolean expected_result) {
        assert(mI.tempCheck(temperature) == expected_result);
    }
    
    public void  test_SOC_ok(float soc,boolean expected_result) {
        assert(mI.socCheck(soc) == expected_result);
    }
    
    public void  test_chargeRate_ok(float chargeRate,boolean expected_result) {
        assert(mI.chargeRateCheck(chargeRate) == expected_result);
    }
    
    public void temperature_validation() {
      test_temperature_ok(0,true);
      test_temperature_ok(45,true);
      test_temperature_ok(-1,false);
    }
    public void SOC_validation() {
      test_SOC_ok(25,true);
      test_SOC_ok(40,true);
      test_SOC_ok(10,false);
      }
    public void Charge_rate_validation() {
        test_chargeRate_ok(0.5f,true);
        test_chargeRate_ok(0.4f,true);
        test_chargeRate_ok(0.9f,false);
        }
    
    public void   test_battery_ok1() {
        assert(mI.batteryIsOk(mI.tempCheck(50), mI.socCheck(85), mI.chargeRateCheck(0.0f)) == false);
        assert(mI.batteryIsOk(mI.tempCheck(42), mI.socCheck(70), mI.chargeRateCheck(0.07f) == true));
        }
}
