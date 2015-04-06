package src.SecurityLightController;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.SecurityLightController.*;
import src.UI.*;

/** This class will house all JUnit test cases for the
 *  Security Light application
 *  @author Chris Silvano, Alex Spradlin, Casey Layne */
public class TestSecurityControl {

	//used to determine which state you are in
	LightControllerStateMachineObserverInterface lightStateMachineObserver;
	LightControllerStateMachine lightStateMachine;
	LightTimerInterface lightTimerInterface;
	LightDeviceInterface lightDeviceInterface;
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void securityAlarmTrippedNight() {
		
		//initial test of program being in correct initial state
		//this returns null pointer right now...
		assertEquals(lightStateMachine.getCurrentState(), lightStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);

	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void securityAlarmTrippedMotion() {

	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void alarmClearedLampOn() {

	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void alarmClearedLampOff() {

	}
		
}
