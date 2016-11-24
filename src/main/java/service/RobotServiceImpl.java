package service;

import Constants.RobotThresholdProperties;
import Enum.BarCodeEnum;
import Model.Robot;
import exceptions.RobotException;

public class RobotServiceImpl implements RobotService {

	public void walk(Robot robot, double distanceToWalk) throws RobotException {
		if (robot.getBatteryCharged() <= RobotThresholdProperties.lowBatteryInidicatorThreshold) {
			throw new RobotException("Low Battery");
		}

		//Asuming that maximum battery charged is 100%
		double batteryDrainPerKm = 100 / RobotThresholdProperties.maximumDistanceCanWalkWithFullCharge;
		double batteryConsumed = batteryDrainPerKm * distanceToWalk ;
		double batteryRemaining = robot.getBatteryCharged() - batteryConsumed;
		
		if(batteryRemaining < RobotThresholdProperties.lowBatteryInidicatorThreshold){
			robot.setHeadRedLight(true);
		}
		
		robot.setBatteryCharged(batteryRemaining);

	}

	public void carryWeight(Robot robot, int weightToCarry) throws RobotException {

		if (robot.getBatteryCharged() <= RobotThresholdProperties.lowBatteryInidicatorThreshold) {
			throw new RobotException("Low Battery");
		}

		if (weightToCarry > RobotThresholdProperties.maximumWeightCarry) {
			robot.setDisplayChestLED(true);
		} else if (weightToCarry < RobotThresholdProperties.maximumWeightCarry) {
			double currentBattery = robot.getBatteryCharged();
			double batteryConsumed = RobotThresholdProperties.batterDrainWalking * weightToCarry;
			double remainingBattery = currentBattery - batteryConsumed;
			
			if(remainingBattery < RobotThresholdProperties.lowBatteryInidicatorThreshold ){
				robot.setHeadRedLight(true);
			}
			robot.setBatteryCharged(remainingBattery);

		}
	}

	public void sacnBarCode(BarCodeEnum barCodeEnum) throws RobotException {
		if (barCodeEnum == BarCodeEnum.SUCCESS_BARCODE) {
			System.out.println(BarCodeEnum.SUCCESS_BARCODE.getbarcodeValue());
		} else if (barCodeEnum == BarCodeEnum.FAILURE_BARCODE) {
			throw new RobotException("Scan Failure");
		}
	}

	public void walikngCarryingWeight(Robot robot, int weightToCarry, int kilometerToWalk) throws RobotException {

			walk(robot,kilometerToWalk);
			carryWeight(robot, weightToCarry);
		
	}
}
