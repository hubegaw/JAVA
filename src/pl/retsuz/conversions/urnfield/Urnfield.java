package pl.retsuz.conversions.urnfield;

import pl.retsuz.conversions.GenericNumeralSystem;

public class Urnfield implements GenericNumeralSystem {
    @Override
    public String fromArabic(int val) {
        String urnfieldVal, urnfieldOnes;
        StringBuilder urnfieldHT = new StringBuilder();

        if (val < 1 || val > 29) {
            throw new UnsupportedOperationException();
        }

        if(val%5==0) {
            urnfieldHT.append("\\".repeat(val / 5));
            return urnfieldHT.toString();
        } else {
            urnfieldOnes = urnfieldSigns(val%10);
            urnfieldHT.append("\\".repeat((val - (val % 5)) / 5));
            urnfieldVal = urnfieldOnes + urnfieldHT;
        }

        return urnfieldVal;
    }

    private String urnfieldSigns(int val) {
        switch(val) {
            case 1,6 -> {return "/";}
            case 2,7 -> {return "//";}
            case 3,8 -> {return "///";}
            case 4,9 -> {return "////";}
        }
        return "";
    }

    @Override
    public int toArabic(String val) {
        int arabicVal = 0;
        String[] numbers = val.split("",0);

        for(int i = 0; i < val.length(); i++) {
            arabicVal += arabicDigits(numbers[i]);
        }

        if (arabicVal < 1 || arabicVal > 29) {
            throw new UnsupportedOperationException();
        }

        return arabicVal;
    }

    private int arabicDigits(String number) {
        switch(number) {
            case "/" -> {return 1;}
            case "\\" -> {return 5;}
            default -> throw new UnsupportedOperationException();
        }
    }
}