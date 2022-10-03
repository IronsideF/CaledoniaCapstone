package com.capstone.caledonia.converters;

public class HPConverter {
    public static double convertHPtoProgress(int currentHP, int maxHP){
        return (double)currentHP/(double)maxHP;
    }
}
