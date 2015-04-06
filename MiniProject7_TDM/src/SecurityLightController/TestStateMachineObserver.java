package src.SecurityLightController;

import static org.junit.Assert.*;

public class TestStateMachineObserver implements
LightControllerStateMachineObserverInterface{
	
	//variable for when the state of machine changes
	int currentState = 0;

	//all valid states in the system
	int[] allValidStates = {LAMP_OFF_DAYLIGHT ,
			LAMP_ON_FULL_BRIGHTNESS, LAMP_OFF_NIGHTIME,
			LAMP_ON_NIGHTIME_BRIGHTNESS, MOTION_DETECTED,
			INTRUSION_DETECTED};

	@Override
	public void updateLightState(int newState) {
		currentState = newState;
		
		//test to see if valid state was achieved
		assertToTestValidState();

	}

	//test to see if state exists as a valid state
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
	
	//return the current state of the machine
	public int getState(){
		return currentState;
	}
	
}
