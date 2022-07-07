import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class quantizeTestCase implements Quantizer {

	@Test
	public void validateQuantize() {
		
		quantizeTestCase obj=new quantizeTestCase();
		
		ArrayList<Integer> ar= new ArrayList<Integer>();
		
		ar.add(10);
		ar.add(0);
		ar.add(0);
		ar.add(0);
		int i=obj.quantize(9, ar);
		
		assertEquals(i,1);
		
		
	}

}