import Enum.BarCodeEnum;
import Model.Robot;
import exceptions.RobotException;
import service.RobotAction;
import service.RobotServiceImpl;

public class RobotAppTest {
	
	public static void main(String args[]) throws RobotException{
		
		Robot robot = Robot.getInstance();
	
		RobotAction robotAction = new RobotAction();
		
		robot.registerObserver(robotAction);
		
		//To check the red head light if battery is less than 15 
		//robot.setBatteryCharged(12);
		
		RobotServiceImpl robotServiceImpl = new RobotServiceImpl();
	
		/* Should display Chest Led since weight is more than 10 kg */
		//robotServiceImpl.carryWeight(robot, 11);
		
		
		 robotServiceImpl.walk(robot,1);
		 System.out.println(robot.getBatteryCharged());
		
		 robotServiceImpl.walikngCarryingWeight(robot, 3, 2);
		 System.out.println(robot.getBatteryCharged());
		 
		 
		// Successfully scan the barcode
		//robotServiceImpl.sacnBarCode(BarCodeEnum.SUCCESS_BARCODE);
		
		// Could not scan the barcode
		//robotServiceImpl.sacnBarCode(BarCodeEnum.FAILURE_BARCODE);

	}
}
