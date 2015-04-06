package src.SecurityLightController;

import static org.junit.Assert.assertEquals;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import src.SecurityLightController.*;
import src.UI.*;

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
		
		JFrame frame = new JFrame("Security Light Controller GUI");
		SecurityLampSimulatedUI cwrb1 = new SecurityLampSimulatedUI(lightStateMachine);
		frame.setContentPane(cwrb1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBounds(300, 0, 20, 10);
		frame.pack();
		frame.setVisible(true);

		lightStateMachine.setLight(cwrb1);
		lightStateMachine.setTmr(new LightTimer(lightStateMachine));
	}
	
	/** Test initial boot-up of system into correct state */
	@Test
	public void initialStartUp(){
		
		//doesn't pass without this line...
		//it shouldn't need this line
		//testStateMachineObserver.updateLightState(TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
		
		testStateMachineObserver.assertToTestValidState();
		
		assertEquals(testStateMachineObserver.currentState, TestStateMachineObserver.LAMP_OFF_DAYLIGHT);
	}
	
	/** This method
	 *  - author Chris Silvano */
	@Test 
	public void securityAlarmTrippedNight() {

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
