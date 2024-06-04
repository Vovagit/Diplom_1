package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    public IngredientType type = IngredientType.SAUCE;
    public String name = "test";
    public float price = 1F;

    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price,actualPrice,0.002);
    }
    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name,actualName);
    }
}
