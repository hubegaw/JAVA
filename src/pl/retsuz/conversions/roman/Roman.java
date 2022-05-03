package pl.retsuz.conversions.roman;

import pl.retsuz.conversions.GenericNumeralSystem;

public class Roman implements GenericNumeralSystem {

    @Override
    public String fromArabic(int val) {
        String romanVal = "";
        int scale = 10;

        if (val < 1 || val > 3000) {
            throw new UnsupportedOperationException();
        }

        String romanOnes = romanDigits(val % 10, "I", "V", "X");
        val /= scale;
        String romanTens = romanDigits(val % 10, "X", "L", "C");
        val /= scale;
        String romanHundreds = romanDigits(val % 10, "C", "D", "M");
        val /= scale;
        String romanThousands = romanDigits(val % 10, "M", "", "");
        romanVal = romanThousands + romanHundreds + romanTens + romanOnes;

        return romanVal;
    }

    private String romanDigits(int val, String one, String five, String ten) {
        switch(val) {
            case 1 -> {return one;}
            case 2 -> {return one+one;}
            case 3 -> {return one+one+one;}
            case 4 -> {return one+five;}
            case 5 -> {return five;}
            case 6 -> {return five+one;}
            case 7 -> {return five+one+one;}
            case 8 -> {return five+one+one+one;}
            case 9 -> {return one+ten;}
        }
        return "";
    }

    @Override
    public int toArabic(String val) {
        int arabicVal=0;
        String[] numbers = val.split("",0);
        for(int i = 0; i < val.length(); i++) {
            arabicVal += arabicDigits(numbers[i]);
        }

        if (arabicVal < 1 || arabicVal > 3000) {
            throw new UnsupportedOperationException();
        }

        return arabicVal;
    }

    private int arabicDigits(String number) {
            switch(number) {
                case "M" -> {return 1000;}
                case "D" -> {return 500;}
                case "C" -> {return 100;}
                case "L" -> {return 50;}
                case "X" -> {return 10;}
                case "V" -> {return 5;}
                case "I" -> {return 1;}
                default -> throw new UnsupportedOperationException();
            }
    }
}
