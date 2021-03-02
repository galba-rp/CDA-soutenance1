package Poker;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComboTest {

    @Test
    public void getHighestCombo(){

        Combo combo = new Combo("Ac Ad Ah As 5h");
        String test = "carre";
        System.out.println(test);
        Assert.assertEquals(test, combo.getHighestCombo());
    }
}