package SecurityLightController;

/**
 * This class implements a light timer.  It is used to control the timeouts associated with a given light.
 *
 */
public class LightTimer implements LightTimerInterface {
	/**
	 * This variable holds the delay in seconds until the timer expires.
	 */
	private int mydelay;
	/**
	 * This variable holds the callback which is invoked when the timer expires.
	 */
	private LightControllerCommandInterface callback;
	
	/**
	 * This variable holds the thread which is to tun for this timer.
	 */
	private Thread t;

	/**
	 * @param callback
	 *            This is the callback for when the timer expires.
	 */
	public LightTimer(LightControllerCommandInterface callback) {
		super();
		this.callback = callback;
		t = null;
	}

	/* (non-Javadoc)
	 * @see SecurityLightController.LightTimerInterface#startTimer(int)
	 */
	public void startTimer(int delay) {
		
		this.mydelay = delay;
		
		
		if ((t != null) && (t.isAlive() == true)) {
			// DO nothing, as the thread is already running.
		} else {
		
			t = new Thread(new Runnable() {
				
				@Override
				public void run() {

					while (mydelay != 0) {
						while (mydelay > 0) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
							}
							mydelay--;
						}
						callback
								.signalAction(LightControllerCommandInterface.LAMP_TIMER_EXPIRED);

					}
				}
			});
			t.start();
		}
	}
}
