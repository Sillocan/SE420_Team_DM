package src.SecurityLightController;

/**
 * This interface defines an interface which a class must implement if it
 * desires to observe the lamp state.
 * 
 */
public interface LightControllerStateMachineObserverInterface {
	public static final int LAMP_OFF_DAYLIGHT = 1;
	public static final int LAMP_ON_FULL_BRIGHTNESS = 2;
	public static final int LAMP_OFF_NIGHTIME = 4;
	public static final int LAMP_ON_NIGHTIME_BRIGHTNESS = 8;
	public static final int MOTION_DETECTED = 16;
	public static final int INTRUSION_DETECTED = 32;

	/**
	 * This method will update the state of the light, passing in one of the the
	 * parameters representing the current state.
	 * 
	 * @param newState
	 *            The new state, one of LAMP_OFF_DAYLIGHT ,
	 *            LAMP_ON_FULL_BRIGHTNESS, LAMP_OFF_NIGHTIME,
	 *            LAMP_ON_NIGHTIME_BRIGHTNESS, MOTION_DETECTED,
	 *            INTRUSION_DETECTED = 32;
	 */
	public void updateLightState(int newState);

}
