package praktikum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.constants.TestValues;

public class BunTest {

    @Test
    public void getNameTest(){
        Bun bun = new Bun(TestValues.BUN_NAME, TestValues.BUN_PRICE);
        String actualName = bun.getName();
        Assert.assertEquals(TestValues.BUN_NAME,actualName);
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun(TestValues.BUN_NAME,TestValues.BUN_PRICE);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(TestValues.BUN_PRICE,actualPrice,0.0002);
    }


}
