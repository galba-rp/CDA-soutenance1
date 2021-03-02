package Poker;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Combo {
    private String combo;
    String result = "";
    int counter = 0;
    private Multimap<String, String> colorsMap = ArrayListMultimap.create();
    private Multimap<String, String> valuesMap = ArrayListMultimap.create();
    private ArrayList<Integer> cValues = new ArrayList<Integer>();


    public Combo(String args) {
        this.combo = args;
    }

    public String getCombo() {
        return combo;
    }


    public String[] handFormatting() {
        String arg = this.combo.replaceAll(" ", "");
        String[] s = arg.split("");
        return s;
    }

    public String[] cardNamesToNumbers() {
        String[] s = this.handFormatting();
        int j = 0;
        while (j < s.length) {
            switch (s[j]) {
                case "A":
                    s[j] = "14";
                    break;
                case "K":
                    s[j] = "13";
                    break;
                case "Q":
                    s[j] = "12";
                    break;
                case "J":
                    s[j] = "11";
                    break;
                case "T":
                    s[j] = "10";
                    break;
                default:
                    break;
            }
            j += 2;
        }
        return s;
    }

    public void createColorsMap() {
        String[] string  = cardNamesToNumbers();
        int i = 0;
        while (i < string.length) {
            this.colorsMap.put(string[i + 1], string[i]);
            i += 2;
        }
    }

    private void createValuesMap() {
        String[] string  = cardNamesToNumbers();
        int i = 0;
        while (i < string.length) {
            this.valuesMap.put(string[i], string[i+1]);
            i +=2;
        }
    }

    // converting Collection of strings to arrayList of integers and sorting for comparison
    private void sortValuesAscending(){
        Collection<String> cardValues = this.colorsMap.values();
        for(String numeric : cardValues)
        {
            this.cValues.add(Integer.parseInt(numeric));
        }
        Collections.sort(this.cValues);

    }

    private int sameValuesCheck(){
        int value = 0;
        for(String key: valuesMap.keySet()){
            Collection values = valuesMap.get(key);
            if (values.size() == 2) value = 2;
        }
        return value;
    }

    private int valuesOrderCheck(){
        sortValuesAscending();
        counter = 0;
        for(int i = 1; i < cValues.size(); i++){
            if(cValues.get(i) != (cValues.get(i-1) + 1)) counter++;
            if(counter > 0) i = cValues.size();
        }

        return counter;
    }

    public String getHighestCombo(){
        createColorsMap();
        createValuesMap();
        counter = valuesOrderCheck();
        if(colorsMap.keySet().size() == 1){
            if(counter > 0){
                result = "flush";
            }else if(cValues.get(0) == 10){
                result = "quinte flush royale";
            }else  result = "quinte flush";
        } else {
            int value = 0;
            switch (valuesMap.keySet().size()){
                case 2:
                    value = sameValuesCheck();
                    result = (value == 0) ?"carre" : "full";
                    break;
                case 3:
                    value = sameValuesCheck();
                    result = (value == 2) ? "double paire" : "brelan";
                    break;
                case 4:
                    result = "paire";
                    break;
                default:
                    //System.out.println(cValues);
                    counter = valuesOrderCheck();
                    if(counter == 0){
                        result = "suite";
                    } else{
                        result  = "carte haute";
                    }
            }
        }
        return result;
    }
}
