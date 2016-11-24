package service;

import exceptions.RobotException;

public interface Observer {

	public void switchOnChestLedLight() throws RobotException;
	public void switchOnHeadRedLight() throws RobotException;
}
