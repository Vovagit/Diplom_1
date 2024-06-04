package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.constants.TestValues;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Spy
    private Burger burger = new Burger();

    private float expectedBurderPrice;
    List<Ingredient> ingredientList = new ArrayList<>();
    private final String expectedReceipt = "(==== TestBun ====)\r\n= sauce sauce ingredient =\r\n= filling filling ingredient =\r\n(==== TestBun ====)\r\n\r\nPrice: 1,000000\r\n";
    public final int testBurgerIteration=10;
    public final float IngredientPrice=2.5055f;


    @Before
    public void before(){
        ingredientList.add(new Ingredient(IngredientType.SAUCE,"sauce ingredient",1.5F));
        ingredientList.add(new Ingredient(IngredientType.FILLING,"filling ingredient",2F));
        expectedBurderPrice = (TestValues.BUN_PRICE * 2) + IngredientPrice * testBurgerIteration;
    }

    @Test
    public void getPriceFloatTest(){

        burger.setBuns(bun);

        for (int i = 0; i < testBurgerIteration; i++) {
            burger.addIngredient(ingredient);
        }

        Mockito.when(bun.getPrice()).thenReturn(TestValues.BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(IngredientPrice);

        float actualPrice = burger.getPrice();
        Mockito.verify(ingredient, Mockito.times(testBurgerIteration)).getPrice();

        Assert.assertEquals(expectedBurderPrice,actualPrice,0.0002);
    }

    @Test
    public void getReceiptStringForTest(){

        burger.setBuns(bun);
        burger.ingredients=ingredientList;

        Mockito.when(bun.getName()).thenReturn(TestValues.BUN_NAME);
        Mockito.when(burger.getPrice()).thenReturn(1F);
        String actualReceipt = burger.getReceipt();

        Assert.assertEquals(expectedReceipt,actualReceipt);

    }

    @Test
    public void addIngredientArrayTest(){

        burger.setBuns(bun);
        for (int i = 0; i < testBurgerIteration ; i++) {
            burger.addIngredient(ingredient);
        }

        Assert.assertEquals(testBurgerIteration,burger.ingredients.size());

    }

    @Test
    public void removeIngredientArrayTest(){

        burger.setBuns(bun);
        for (int i = 0; i < testBurgerIteration ; i++) {
            burger.addIngredient(ingredient);
        }
        burger.removeIngredient(1);
        Assert.assertEquals(testBurgerIteration-1,burger.ingredients.size());
    }

    @Test
    public void moveIngredientArrayTest(){

        burger.setBuns(bun);
        for (int i = 0; i <= testBurgerIteration ; i++) {
            if (i==0){
                burger.addIngredient(ingredient);
            }else{
                burger.addIngredient(null);
            }
        }
        burger.moveIngredient(0,testBurgerIteration);
        Assert.assertNotNull(burger.ingredients.get(testBurgerIteration));
    }

}
