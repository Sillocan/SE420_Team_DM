package src.SecurityLightController;

/**
 * This interface defines those things which must be present for a light.  This includes the methods invoked from the state machine to control the light.
 *
 */
public interface LightDeviceInterface {
	
	public static final int BRIGHT = 2;
	public static final int DIM = 1;
	public static final int OFF = 0;
	
	public void turnLightOff();
	public void turnLightOnFullBrightness();
	public void turnLightOnNightimeBrightness();
	public int getBrightness();
}
