package service;

import Enum.BarCodeEnum;
import Model.Robot;
import exceptions.RobotException;

public interface RobotService {
	
	public void walk(Robot robot, double kmtoWalk) throws RobotException;
	public void carryWeight(Robot robot, int weightToCarry) throws RobotException;
	public void sacnBarCode(BarCodeEnum barCodeEnum) throws RobotException;
	public void walikngCarryingWeight(Robot robot,int weightToCarry, int kilometreToWalk) throws RobotException;
	

}
