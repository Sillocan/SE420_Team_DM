package src.SecurityLightController;

/**
 * This interface defines those things which must be present for a light.  This includes the methods invoked from the state machine to control the light.
 *
 */
public interface LightDeviceInterface {
	public void turnLightOff();
	public void turnLightOnFullBrightness();
	public void turnLightOnNightimeBrightness();
}
