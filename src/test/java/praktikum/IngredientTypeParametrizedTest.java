package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeParametrizedTest {

    private final IngredientType type;
    private final String typeValue;

    public IngredientTypeParametrizedTest(IngredientType type, String typeValue) {
        this.type = type;
        this.typeValue = typeValue;
    }

    @Parameterized.Parameters
    public static Object[] getCredentials() {
        return new Object[][]{
                {IngredientType.SAUCE,"SAUCE"},
                {IngredientType.FILLING,"FILLING"}
        };

    }

    @Test
    public void ingredientType(){
    Assert.assertEquals(type,IngredientType.valueOf(typeValue));
    }
}
