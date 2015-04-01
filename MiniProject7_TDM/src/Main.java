import javax.swing.JFrame;
import SecurityLightController.LightControllerStateMachine;
import SecurityLightController.LightTimer;
import UI.SecurityLampSimulatedUI;

/**
 * This is the main class. It instantiates instances of the GUI and ties it
 * together with the state machine.
 * 
 */
public class Main {
	public static void main(String[] args) {

		LightControllerStateMachine lcsm = new LightControllerStateMachine();

		JFrame frame = new JFrame("Security Light Controller GUI");
		SecurityLampSimulatedUI cwrb1 = new SecurityLampSimulatedUI(lcsm);
		frame.setContentPane(cwrb1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBounds(300, 0, 20, 10);
		frame.pack();
		frame.setVisible(true);

		lcsm.setLight(cwrb1);
		lcsm.setTmr(new LightTimer(lcsm));
	}

}
