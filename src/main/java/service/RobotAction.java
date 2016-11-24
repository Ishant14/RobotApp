package service;

import exceptions.RobotException;

public class RobotAction implements Observer{

	public void switchOnChestLedLight() throws RobotException {
		throw new RobotException("Chest LED Displayed");
	}

	public void switchOnHeadRedLight() throws RobotException {
		throw new RobotException("Red Head Light Displayed");
	}
	
}
