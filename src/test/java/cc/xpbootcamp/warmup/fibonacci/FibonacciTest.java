package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    public void should_return_1_when_calculate_given_position_is_1(){
        Assert.assertEquals(1,FibonacciCalculater.calculateByPosition(1));
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2(){
        Assert.assertEquals(1,FibonacciCalculater.calculateByPosition(2));
    }

    @Test
    public void should_return_2_when_calculate_given_position_is_3(){
        Assert.assertEquals(2,FibonacciCalculater.calculateByPosition(3));
    }

    @Test
    public void should_return_3_when_calculate_given_position_is_4(){
        Assert.assertEquals(3,FibonacciCalculater.calculateByPosition(4));
    }

    @Test
    public void should_return_12586269025_when_calculate_given_position_is_50(){
        Assert.assertEquals(12586269025L,FibonacciCalculater.calculateByPosition(50));
    }



}
