# Eat-with-Nymble

1. We are implementing a cruise control software. In that software there is a class called `ThrottleController`. \
2. This class has a setter for requested cruise speed and a method to calculate the throttle speed given the current speed of the vehicle. \
3. This method `calculateThrottle` takes the current speed as an argument and uses the class data member `cruiseSpeed` to calculate the throttle speed which maintains the vehicle at the given cruise speed. \
4. The method also uses an implementation of the interface `Quantizer<Integer>` . \
5. This interface has a method `quantize` .
    - What does it do?
        1. It takes an integer belonging to a continuous range and then converts (quantize) it into one of the 7 levels which in our case 7 different level of throttle.
        2. The relation of the input of the quantize method with the output is shown below, where x-axis is the input and y-axis is the output for all input greater than 70 the method should return 7 and for all negative integers the method should return 0.
        
        
        1. There is a problem with this method of quantization. Consider at t = 1 second, the input is 9, therefore the throttle would be set to 1, at t = 1.1 second, the input is 11, then the throttle would set to 2 and at t = 1.2, the input again goes back to 9 and then throttle will again switch back to 1.
        2. These rapid changes to the throttle are not allowed by the physical system. Therefore, the quantize method will have to handle such boundary condition. 
        3. This can be done through the concept called hysteresis. It enables us to not only consider the current value of input but also the previous value of the input (historical value).
        4. Let's define a range of +-2 speed units around the speed 10. And consider the above example.
        5.  The hysteresis will work as follows:
            1. At t = 1 second the input was 9 and then throttle was set to 1. At t = 1.1 seconds the input was 11. Now, we don't return 2 as the quantized value.
            2. Recall that we had define a range of +- 2 speed units around the speed of 10 and let's call it the hysteresis range. This range computes to be 8 to 12. We only return the output as 2 when the input exceeds the value of 12. While in the hysteresis range we do not change the output and retain the previously calculated value.
            3. Similarly, if the output calculate at a previous iteration was 2. And the current input is 9, we retain the previous output value and return  2. We return 1 only if the input goes beyond 8.
            4. The hysteresis range can be calculated for other decision boundaries as well in a similar way.
        6. It can be assumed that the input to the method won't change by more than 5 units in consecutive iteration. 
        7. In a situation where the input does change rapidly more than unit 5 units, we can increase our hysteresis range from +- 2 to some higher value.
        8. This possible future change must be kept in mind while implementing the `quantize` method.
