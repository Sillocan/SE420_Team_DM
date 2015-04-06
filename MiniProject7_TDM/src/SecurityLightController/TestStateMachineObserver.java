package src.SecurityLightController;

import static org.junit.Assert.*;

/** This class allows for an observer to exist for the state machine
 * @author Chris Silvano */
public class TestStateMachineObserver implements
LightControllerStateMachineObserverInterface{
	
	//variable for when the state of machine changes
	int currentState = 0;

	//all valid states in the system
	int[] allValidStates = {LAMP_OFF_DAYLIGHT ,
			LAMP_ON_FULL_BRIGHTNESS, LAMP_OFF_NIGHTIME,
			LAMP_ON_NIGHTIME_BRIGHTNESS, MOTION_DETECTED,
			INTRUSION_DETECTED};

	/** Allow for the change of the state of the state machine */
	@Override
	public void updateLightState(int newState) {
		currentState = newState;
		
		//test to see if valid state was achieved
		assertToTestValidState();

	}

	/** Test to see if state exists as a valid state */
	public void assertToTestValidState() {
		boolean isValidState = false;
		
		for(int oneValidState : allValidStates){
			
			if(currentState == oneValidState){
				isValidState = true;
			}
			
		}
		
		//will fail if the state is not a valid state
		assertTrue(isValidState);
	}
	
}
