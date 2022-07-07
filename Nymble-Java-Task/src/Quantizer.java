import java.util.ArrayList;

// interface
public interface Quantizer {


	 default int quantize(int currentSpeed , ArrayList<Integer> ar) {
		
		if(currentSpeed>70) {
			return 7;
		}else if(currentSpeed<0) {
			
			return 0;
		}else {
			int throttle=checkIfInRange(currentSpeed,ar);
			return throttle;
		}
		
	}

//	 method to check if speed in range
	static int checkIfInRange(int currentSpeed,  ArrayList<Integer> ar) {
		
		if(currentSpeed>=ar.get(1) && currentSpeed<=ar.get(2)) {
			return ar.get(3);
		}else {
			int throttle=checkInOriginalRange(currentSpeed,ar);
			return throttle;
		}
	};

	
//  method to calculate throttle
	static int checkInOriginalRange(int i,  ArrayList<Integer> ar) {
		int endRange=ar.get(1);
		int initRange=ar.get(2);
		int prevThrottle=ar.get(3);;
		if(i>=0 && i<=10) {
			endRange=12;
			initRange=8;
			prevThrottle=1;
			return 1;
		}else if(i>10 && i<=20) {
			endRange=22;
			initRange=18;
			prevThrottle=2;
			return 2;
			
		}else if(i>20 && i<=30) {
			endRange=32;
			initRange=28;
			prevThrottle=3;
			return 3;
			
		}else if(i>30 && i<=40) {
			endRange=42;
			initRange=38;
			prevThrottle=4;
			return 4;
			
		}else if(i>40 && i<=50) {
			endRange=52;
			initRange=48;
			prevThrottle=5;
			return 5;
			
		}else if(i>50 && i<=60) {
			endRange=62;
			initRange=58;
			prevThrottle=6;
			return 6;
			
		}else if(i>60 && i<=70) {
			endRange=72;
			initRange=68;
			prevThrottle=7;
			return 7;
			
		}else {
			return 0;
		}
		
	}
	

}