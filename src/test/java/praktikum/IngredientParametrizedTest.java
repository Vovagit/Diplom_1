package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientParametrizedTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getCredentials() {
        return new Object[][]{
                {IngredientType.FILLING,"name",1F},
                {IngredientType.SAUCE,"test",2F}
        };

    }

    @Before
    public void before(){
        ingredient = new Ingredient(ingredientType,name,price);
    }

    @Test
    public void getIngredientTypeTest(){
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(ingredientType,actualType);
    }


}
