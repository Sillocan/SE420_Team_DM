package src.SecurityLightController;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.SecurityLightController.*;
import src.UI.SecurityLampSimulatedUI;

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
	SecurityLampSimulatedUI lampGUI;
	
	@Before
	public void setUpTests(){
		testStateMachineObserver = new TestStateMachineObserver();
		lightStateMachine = new LightControllerStateMachine();
		
		//subscribe for notifications
		lightStateMachine.subscribe(testStateMachineObserver);
<<<<<<< Updated upstream
		
		//create new instance of the GUI for light timer
		lampGUI = new SecurityLampSimulatedUI(lightStateMachine);
		lightStateMachine.setLight(lampGUI);
=======

		SecurityLampSimulatedUI cwrb1 = new SecurityLampSimulatedUI(lightStateMachine);

		lightStateMachine.setLight(cwrb1);
>>>>>>> Stashed changes
		lightStateMachine.setTmr(new LightTimer(lightStateMachine));
	}
	
	/** Test initial boot-up of system into correct state */
	@Test
	public void initialStartUp(){
		testStateMachineObserver.assertToTestValidState();
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
	}
	
	private void updateState(int state) {
		
		lightStateMachine.setCurrentState(state);
	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void securityAlarmTrippedNight() {
<<<<<<< Updated upstream
		
		lightStateMachine.signalAction(lightStateMachine.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		lightStateMachine.signalAction(lightStateMachine.SECURITY_ALARM_TRIPPED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light
		
=======

		//updateState(TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		//assertEquals(testStateMachineObserver.getCurrentState(), TestStateMachineObserver.);
		//lightStateMachine.signalAction(request);
		//assertEquals(testStateMachineObserver.getCurrentState(), TestStateMachineObserver.<>);
>>>>>>> Stashed changes
	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void securityAlarmTrippedMotion() {
		
		lightStateMachine.signalAction(lightStateMachine.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		lightStateMachine.signalAction(lightStateMachine.MOTION_DETECTED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.MOTION_DETECTED);
		
		lightStateMachine.signalAction(lightStateMachine.SECURITY_ALARM_TRIPPED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light

	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void alarmClearedLampOn() {
		
		lightStateMachine.signalAction(lightStateMachine.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		lightStateMachine.signalAction(lightStateMachine.SECURITY_ALARM_TRIPPED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light
		
		
		lightStateMachine.signalAction(lightStateMachine.ALARM_CLEARED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffDaylightSwitchOn() {

	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffDaylightSensorDark() {

	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffNighttimeSensorLight() {

	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffNighttimeMotion() {

	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
	public void lampOnSwitchOff() {

	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
<<<<<<< Updated upstream
	public void alarmClearedLampOff() {
		
		lightStateMachine.signalAction(lightStateMachine.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		lightStateMachine.signalAction(lightStateMachine.SECURITY_ALARM_TRIPPED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light
		
		
		lightStateMachine.signalAction(lightStateMachine.ALARM_CLEARED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
=======
	public void lampOnAlarmTripped() {

>>>>>>> Stashed changes
	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
	public void lampOnNightSwitchOff() {

	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
	public void lampOnNightSensorLight() {

	}
	
	/** This method
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffNighttimeSwitchOn() {
		
	}
}
