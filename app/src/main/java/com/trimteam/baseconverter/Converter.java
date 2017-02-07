package com.trimteam.baseconverter;

import android.support.annotation.IntegerRes;

/**
 * Created by pedroneto on 05/02/17.
 */
public class Converter {

//   private int [] values  = {0,1,2,3,4,5,6,7,8,9,10,'A','B','C','D','E','F'};

    public String convertDecimalBinary(int decimal){
        return Integer.toBinaryString(decimal);
    }
    public String convertDecimalOctal(int decimal){
        return Integer.toOctalString(decimal);
    }
    public String convertDecimalHexa(int decimal){
        return Integer.toHexString(decimal);
    }

    public String convertBinaryDecimal(int binary){
        String binaryString = Integer.toString(binary);
        int decimalString = 0;
        for(int i  = 0;  i < binaryString.length(); i++){
            decimalString += Integer.getInteger(binaryString.charAt(i) + "") * Math.pow(2,i);
        }
        return Integer.toString(decimalString);
    }

    public String convertBinaryOctal(int binary){
        int decimal = Integer.getInteger(convertBinaryDecimal(binary));
        return convertDecimalOctal(decimal);
    }

    public String convertBinaryHexa(int binary){
        int decimal = Integer.getInteger(convertBinaryDecimal(binary));
        return convertDecimalHexa(decimal);
    }

    public String convertOctalDecimal(int octal){
        String octalString = Integer.toString(octal);
        int decimal = 0 ;
        for(int i = 0 ; i<octalString.length(); i++){
            decimal += Integer.getInteger((octalString.charAt(i) + "")) * Math.pow(8,i);
        }
        return Integer.toString(decimal);
    }

    public String convertOctalBinary(int octal){
        int decimal = Integer.getInteger(convertOctalDecimal(octal));
        return convertDecimalBinary(decimal);
    }

    public String convertOctalHexa(int octal){
        int decimal = Integer.getInteger(convertOctalDecimal(octal));
        return convertDecimalHexa(decimal);
    }

    public String convertHexaDecimal(String hexa){
        int decimal = 0;
        for(int i = 0 ; i < hexa.length() ; i++){
            decimal += findIndice(hexa.charAt(i)) * Math.pow(16,i);
        }
        return Integer.toString(decimal);
    }

    public String convertHexaOctal(String hexa){
        String decimal = convertHexaDecimal(hexa);
        return convertDecimalOctal(Integer.valueOf(decimal));
    }

    public String convertHexaBinary(String hexa){
        String decimal = convertHexaDecimal(hexa);
        return convertDecimalBinary(Integer.valueOf(decimal));
    }

    private int findIndice(char indice){

        switch (indice){
            case 'A' : return 10;
            case 'B' : return 11;
            case 'C' : return 12;
            case 'D' : return 13;
            case 'E' : return 14;
            case 'F' : return 15;
            default: return Integer.valueOf(indice + "");
        }

    }

}
