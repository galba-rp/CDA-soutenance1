package Poker;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComboTest {

    @Test
    public void getHighestCombo(){

        Combo carre = new Combo("Ac Ad Ah As 5h");
        Assert.assertEquals("carre", carre.getHighestCombo());

        Combo quinteFR = new Combo("Ac Kc Qc Jc Tc");
        Assert.assertEquals("quinte flush royale",  quinteFR.getHighestCombo());

        Combo quiteF = new Combo("9c Kc Qc Jc Tc");
        Assert.assertEquals("quinte flush",  quiteF.getHighestCombo());

        Combo full = new Combo("Kd Kc Kh Jc Jh");
        Assert.assertEquals("full",  full.getHighestCombo());

        Combo flush = new Combo("Kd Jd 9d 6d 5d");
        Assert.assertEquals("flush",  flush.getHighestCombo());

        Combo suite = new Combo("9c 8h Qh Js Tc");
        Assert.assertEquals("suite", suite.getHighestCombo());

        Combo brelan = new Combo("9c 9h 9d Js Tc");
        Assert.assertEquals("brelan", brelan.getHighestCombo());

        Combo two = new Combo("9c 9h Jd Js Tc");
        Assert.assertEquals("double paire", two.getHighestCombo());

        Combo pair = new Combo("9c 9h Jd Ks Tc");
        Assert.assertEquals("paire", pair.getHighestCombo());

        Combo carte = new Combo("9c Kh Jd 3s Tc");
        Assert.assertEquals("carte haute", carte.getHighestCombo());
    }
}