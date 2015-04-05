package src.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.SecurityLightController.*;
import src.SecurityLightController.LightControllerStateMachineObserverInterface;
import src.UI.*;

/** This class will house all JUnit test cases for the
 *  Security Light application
 *  @author Chris Silvano, Alex Spradlin, Casey Layne */
public class TestSecurityControl {

	//used to determine which state you are in
	LightControllerStateMachineObserverInterface lightStateMachine;
	LightControllerCommandInterface lightControllerCommand;
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void securityAlarmTrippedNight() {
		assertEquals(5, 5);

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
