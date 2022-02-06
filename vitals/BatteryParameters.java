package vitals;

public interface BatteryParameters {
public boolean tempCheck(float temp);
public boolean socCheck(float soc);
public boolean chargeRateCheck(float chargeRate);
}
