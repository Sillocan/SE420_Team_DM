package src.SecurityLightController;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
	
	/** Set-up JUnit test cases. Allow for same initial state machine to be used
	 */
	@Before
	public void setUpTests(){
		testStateMachineObserver = new TestStateMachineObserver();
		lightStateMachine = new LightControllerStateMachine();
		
		//subscribe for notifications
		lightStateMachine.subscribe(testStateMachineObserver);
		
		//create new instance of the GUI for light timer
		lampGUI = new SecurityLampSimulatedUI(lightStateMachine);
		lightStateMachine.setLight(lampGUI);
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
		
		lightStateMachine.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		lightStateMachine.signalAction(LightControllerCommandInterface.SECURITY_ALARM_TRIPPED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light
		
	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void securityAlarmTrippedMotion() {
		
		lightStateMachine.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		lightStateMachine.signalAction(LightControllerCommandInterface.MOTION_DETECTED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.MOTION_DETECTED);
		
		lightStateMachine.signalAction(LightControllerCommandInterface.SECURITY_ALARM_TRIPPED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light

	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void alarmClearedLampOn() {
		
		lightStateMachine.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		lightStateMachine.signalAction(LightControllerCommandInterface.SECURITY_ALARM_TRIPPED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light
		
		
		lightStateMachine.signalAction(LightControllerCommandInterface.ALARM_CLEARED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void alarmClearedLampOff() {
		
		lightStateMachine.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_DARKENED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		lightStateMachine.signalAction(LightControllerCommandInterface.SECURITY_ALARM_TRIPPED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.INTRUSION_DETECTED);
		
		//test state of light
		
		
		lightStateMachine.signalAction(LightControllerCommandInterface.ALARM_CLEARED);
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_NIGHTIME);
	}
		
	
	/** This method tests the state transition from Lamp Off Daylight to
	 * Lamp Off Nighttime with the event LIGHT_SENSOR_DARKENED.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffDaySensorDark() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_DARKENED);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.OFF);
	}
	
	
	/** This method tests the state transition from Lamp Off Nighttime to
	 * Lamp Off Daylight with the event LIGHT_SENSOR_LIGHTENED.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffNightSensorLight() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_LIGHTENED);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.OFF);
	}
	
	
	/** This method tests the state transition from Lamp Off Daylight to
	 * Lamp On Full with the event MANUAL_SWITCH_ON.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffDaySwitchOn() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.MANUAL_SWITCH_ON);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.BRIGHT);
	}
	
	
	/** This method tests the state transition from Lamp On Full to
	 * Lamp Off Daylight with the event MANUAL_SWITCH_OFF.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOnFullSwitchOff() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.MANUAL_SWITCH_OFF);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.OFF);
	}
	
	
	/** This method tests the state transition from Lamp Off Nighttime to
	 * Lamp On Nighttime Brightness with the event MANUAL_SWITCH_ON.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffNightSwitchOn() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.MANUAL_SWITCH_ON);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.DIM);
	}
	
	
	/** This method tests the state transition from Lamp On Nighttime Brightness to
	 * Lamp Off Nighttime with the event MANUAL_SWITCH_OFF.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOnNightSwitchOff() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.MANUAL_SWITCH_OFF);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.OFF);
	}
	
	
	/** This method tests the state transition from Lamp On Full to
	 * Lamp On Nighttime Brightness with the event LIGHT_SENSOR_DARKENED.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOnFullSensorDark() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_DARKENED);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.DIM);
	}
	
	
	/** This method tests the state transition from Lamp On Nighttime Brightness to
	 * Lamp On Full with the event LIGHT_SENSOR_LIGHTENED.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOnNightSensorLight() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_LIGHTENED);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.BRIGHT);
	}
	
	
	/** This method tests the state transition from Lamp Off Nighttime to
	 * Motion Detected with the event MOTION_DETECTED.
	 *  - author Alex Spradlin */
	@Test 
	public void lampOffNightMotion() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.MOTION_DETECTED);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.MOTION_DETECTED);
	}
	
	
	/** This method tests what happens when a signal tells it not to change states.
	 *  - author Alex Spradlin */
	@Test 
	public void testImproperLightOffDay() {
		
		//the initial state is Lamp Off Daylight
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		//signal an event that shouldn't change states
		lightStateMachine.signalAction(LightControllerCommandInterface.MANUAL_SWITCH_OFF);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.OFF);
	}
	
	
	/** This method tests signalling an irrelevant event from the state Lamp On Full
	 *  - author Alex Spradlin */
	@Test 
	public void testImproperLampOnFull() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.MOTION_DETECTED);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_FULL_BRIGHTNESS);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.BRIGHT);
	}
	
	
	/** This method tests signalling an irrelevant event from the state Lamp Off Nighttime
	 *  - author Alex Spradlin */
	@Test 
	public void testImproperLampOffNight() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.MANUAL_SWITCH_OFF);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.OFF);
	}
	
	
	/** This method tests signalling an irrelevant event from the state Lamp On Nighttime Brightness
	 *  - author Alex Spradlin */
	@Test 
	public void testImproperLampOnNight() {
		
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//test that it is in initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//signal an event
		lightStateMachine.signalAction(LightControllerCommandInterface.MOTION_DETECTED);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_ON_NIGHTIME_BRIGHTNESS);
		
		//check the state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.DIM);
	}
	
	
	/** This method tests unsubscribing an observeer
	 *  - author Alex Spradlin */
	@Test 
	public void testUnsubscribe() {
		
		//unsubscribe this
		lightStateMachine.unsubscribe(testStateMachineObserver);
	}
	
	/** This method tests the LAMP_TIMER_EXPIRED event during Motion Detected state.
	 * @author William Layne
	 */
	@Test
	public void testTimerExpired(){
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.MOTION_DETECTED);
		
		//test the initial state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.MOTION_DETECTED);
		
		//signal event
		lightStateMachine.signalAction(LightControllerCommandInterface.LAMP_TIMER_EXPIRED);
		
		//test final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.LAMP_OFF_NIGHTIME);
		
		//check state of the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.OFF);
	}
	
	/** This method tests the LAMP_TIMER_EXPIRED event during INTRUSION_DETECTED LAMP_ON state,
	 *  and then check the LAMP_TIMER_EXPIRED event during INTRUSION_DETECTED LAMP_OFF state.
	 *  @author William Layne
	 */
	@Test
	public void testIntrusionDetectedLampOnExpired(){
		//set initial state
		lightStateMachine.setCurrentState(TestStateMachineObserver.INTRUSION_DETECTED);
		//check if the lamp is on
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.BRIGHT);
		//signal event
		lightStateMachine.signalAction(LightControllerCommandInterface.LAMP_TIMER_EXPIRED);
		//check the final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.INTRUSION_DETECTED);
		//check the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.OFF);
		
		//check for the lamp off
		//signal event
		lightStateMachine.signalAction(LightControllerCommandInterface.LAMP_TIMER_EXPIRED);
		//check the final state
		assertEquals(lightStateMachine.getCurrentState(), TestStateMachineObserver.INTRUSION_DETECTED);
		//check the light
		assertEquals(lampGUI.getBrightness(), LightDeviceInterface.BRIGHT);
				
				
	}
}
