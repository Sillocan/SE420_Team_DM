package src.SecurityLightController;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.SecurityLightController.*;

/** This class will house all JUnit test cases for the
 *  Security Light application
 *  @author Chris Silvano, Alex Spradlin, Casey Layne */
public class TestSecurityControl {

	//used to determine which state you are in
	LightControllerStateMachineObserverInterface lightStateMachineObserverInterface;
	LightControllerStateMachine lightStateMachine;
	LightTimerInterface lightTimerInterface;
	LightDeviceInterface lightDeviceInterface;
	TestStateMachineObserver testStateMachineObserver;
	
	@Before
	public void setUpTests(){
		testStateMachineObserver = new TestStateMachineObserver();
		lightStateMachine = new LightControllerStateMachine();
		
		//subscribe for notifications
		lightStateMachine.subscribe(testStateMachineObserver);
		
		//new timer
		lightStateMachine.setTmr(new LightTimer(lightStateMachine));
	}
	
	/** Test initial boot-up of system into correct state */
	@Test
	public void initialStartUp(){
		testStateMachineObserver.assertToTestValidState();
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void securityAlarmTrippedNight() {
		lightStateMachine.signalAction(lightStateMachine.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);		
		
		lightStateMachine.signalAction(lightStateMachine.SECURITY_ALARM_TRIPPED);
		
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light
		
		//
		
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
