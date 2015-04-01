package SecurityLightController;

/**
 * This interface defines the light controller interface. Included are the
 * signals that can be sent into the controller (based on the detection of
 * changes in the system) as well as the methods which can be invoked.
 * 
 * 
 */
public interface LightControllerCommandInterface {

	/**
	 * This signal indicates that the light sensor has been darkened, indicating
	 * diminished ambient light and the approach of nightfall.
	 */
	public static final int LIGHT_SENSOR_DARKENED = 1;
	/**
	 * This signal indicates that the light sensor has been lit up, indicating
	 * the sun is up and daylight is here.
	 */
	public static final int LIGHT_SENSOR_LIGHTENED = 2;

	/**
	 * This signal indicates that a manual override switch has been placed into
	 * the on position.
	 */
	public static final int MANUAL_SWITCH_ON = 3;

	/**
	 * This signal indicates that a manual override switch has been placed into
	 * the off position.
	 */
	public static final int MANUAL_SWITCH_OFF = 4;

	/**
	 * This signal indicates that motion has been detected in the area.
	 * Typically, this indicates that a motion sensor has gone off.
	 */
	public static final int MOTION_DETECTED = 5;

	/**
	 * This signal indicates that an intrusion has been detected. Perhaps a
	 * window has been opened or some other detection of intrusion has occurred.
	 */
	public static final int SECURITY_ALARM_TRIPPED = 6;

	/**
	 * This signal indicates that someone has cleared the active alarm. This is
	 * typically done by resetting the alarm.
	 */
	public static final int ALARM_CLEARED = 7;

	/**
	 * This signal indicates that a timer has expired.
	 */
	public final int LAMP_TIMER_EXPIRED = 8;

	/**
	 * This method provides a mechanism for a signal to be received by the light
	 * controller. The signal will be one of the defined values provided
	 * previously.
	 * 
	 * @param signal
	 *            This is the signal that is being received. It can be one of
	 *            LIGHT_SENSOR_DARKENED, LIGHT_SENSOR_LIGHTENED,
	 *            MANUAL_SWITCH_ON, MANUAL_SWITCH_OFF, MOTION_DETECTED,
	 *            SECURITY_ALARM_TRIPPED, ALARM_CLEARED, or LAMP_TIMER_EXPIRED.
	 *            \
	 * **/
	public void signalAction(int signal);

	/**
	 * This method will allow an external observer to subscribe to state
	 * machine, receiving updates when states change.
	 * 
	 * @param obs
	 *            This is the observer interface that is to be subscribed.
	 */
	public void subscribe(LightControllerStateMachineObserverInterface obs);

	/**
	 * This method will allow an external observer to unsubscribe to state
	 * machine, receiving updates when states change.
	 * 
	 * @param obs
	 *            This is the observer interface that is to be unsubscribed.
	 */
	public void unsubscribe(LightControllerStateMachineObserverInterface obs);

}
