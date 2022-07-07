import java.util.ArrayList;

public class ThrottleController implements Quantizer {
private int cruiseSpeed;

//  setter
public void setCruiseSpeed(int cruiseSpeed){
	this.cruiseSpeed=cruiseSpeed;
}

public int calculateThrottle(int currentSpeed) {
	
//	to keep record of past range and throttle value
	ArrayList<Integer> ar= new ArrayList<Integer>();
	
	ar.add(currentSpeed); //current Speed
	ar.add(0);      //initial range
	ar.add(0);      //end range
	ar.add(0);      //previous throttle speed
	
	ThrottleController obj=new ThrottleController();
	int throttle=obj.quantize(currentSpeed,ar);
	
	return throttle;
	
}
}