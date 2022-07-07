
public class ThrottleControllerImpl {

	public static int cruiseSpeeed=10;
	
	public static void main(String args[]) {
		
//		driver code
		ThrottleController throttleController = new ThrottleController();
		throttleController.setCruiseSpeed(getCruiseSpeed());
		final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed());
		setThrottleValue(throttleControlValue);
	}
	
	private static void setThrottleValue(Integer throttleControlValue) {

		System.out.print(throttleControlValue);
	}

	private static int getCurrentSpeed() {
		return 10;
	}

	public static int getCruiseSpeed() {
		
		return cruiseSpeeed;
	}
}