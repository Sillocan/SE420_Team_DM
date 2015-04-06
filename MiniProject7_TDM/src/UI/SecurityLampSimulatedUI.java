package src.UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.SecurityLightController.LightControllerCommandInterface;
import src.SecurityLightController.LightDeviceInterface;

/**
 * This class implements a basic UI for usage with the light controller. It
 * simulates that which would exist in a real world light timer implementation.
 * 
 */
public class SecurityLampSimulatedUI extends JPanel implements
		LightDeviceInterface {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> overrideSwitch;
	private JComboBox<String> lightSensor;
	private JLabel lamp;
	private LightControllerCommandInterface lcsm;

	/**
	 * This constructor will instantiate a new GUI instance.
	 * 
	 * @param lcsm
	 *            This is the instance of the light controller state machine
	 *            that is to be used.
	 */
	public SecurityLampSimulatedUI(LightControllerCommandInterface lcsm) {
		super();
		this.lcsm = lcsm;
		this.setLayout(new GridBagLayout());
		this.addContents();
	}

	/**
	 * This method will add the contents to the given panel.
	 */
	private void addContents() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;

		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 0.0;
		this.add(new JLabel("Manual Lamp Override"), gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;

		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 0.0;
		String[] switchPositions = { "Off", "On" };
		overrideSwitch = new JComboBox<String>(switchPositions);
		this.add(overrideSwitch, gbc);

		overrideSwitch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (((String) overrideSwitch.getSelectedItem())
						.equalsIgnoreCase("On")) {
					lcsm
							.signalAction(LightControllerCommandInterface.MANUAL_SWITCH_ON);
				} else if (((String) overrideSwitch.getSelectedItem())
						.equalsIgnoreCase("Off")) {
					lcsm
							.signalAction(LightControllerCommandInterface.MANUAL_SWITCH_OFF);
				}
			}
		});

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;

		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 0.0;
		this.add(new JLabel("Light Sensor"), gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;

		gbc.gridheight = 1;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		String[] sensorOptions = { "Light", "Dark" };
		lightSensor = new JComboBox<String>(sensorOptions);
		this.add(lightSensor, gbc);

		lightSensor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (((String) lightSensor.getSelectedItem())
						.equalsIgnoreCase("Dark")) {
					lcsm
							.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_DARKENED);
				} else if (((String) lightSensor.getSelectedItem())
						.equalsIgnoreCase("Light")) {
					lcsm
							.signalAction(LightControllerCommandInterface.LIGHT_SENSOR_LIGHTENED);
				}
			}
		});

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;

		gbc.gridheight = 1;
		gbc.weightx = 0.25;
		gbc.weighty = 0.25;
		JButton motionDetectedButton = new JButton("Motion Detected");
		motionDetectedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lcsm
						.signalAction(LightControllerCommandInterface.MOTION_DETECTED);
			}
		});
		this.add(motionDetectedButton, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		JButton alarmTripped = new JButton("Alarm Tripped");
		alarmTripped.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lcsm
						.signalAction(LightControllerCommandInterface.SECURITY_ALARM_TRIPPED);
			}
		});
		this.add(alarmTripped, gbc);

		gbc.gridx = 2;
		gbc.gridy = 5;
		JButton cancelButton = new JButton("Cancel Alarm");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lcsm
						.signalAction(LightControllerCommandInterface.ALARM_CLEARED);
			}
		});
		this.add(cancelButton, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;

		gbc.gridheight = 3;
		gbc.weightx = 0.5;
		gbc.weighty = 0.0;
		this.lamp = new JLabel(this.createImageIcon("dark.gif",
				"A darkened lamp"));
		this.add(this.lamp, gbc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SecurityLightController.LightDeviceInterface#turnLightOff()
	 */
	public void turnLightOff() {
		this.lamp.setIcon(this.createImageIcon("dark.gif", "A darkened lamp"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SecurityLightController.LightDeviceInterface#turnLightOnFullBrightness()
	 */
	public void turnLightOnFullBrightness() {
		this.lamp.setIcon(this.createImageIcon("bright.gif", "A bright lamp"));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * SecurityLightController.LightDeviceInterface#turnLightOnNightimeBrightness
	 * ()
	 */
	public void turnLightOnNightimeBrightness() {
		this.lamp.setIcon(this.createImageIcon("dim.gif", "A dim lamp"));
	}

	/**
	 * This method will create an image icon.
	 * 
	 * @param path
	 *            This is the path to the icon.
	 * @param description
	 *            This is a description of the icon.
	 * @return Returns an ImageIcon, or null if the path was invalid.
	 */
	private ImageIcon createImageIcon(String path, String description) {
		ClassLoader cldr = this.getClass().getClassLoader();
		java.net.URL imageURL = cldr.getResource(path);

		if (imageURL != null) {
			return new ImageIcon(imageURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
