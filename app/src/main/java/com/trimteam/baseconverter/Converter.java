package com.trimteam.baseconverter;

import android.support.annotation.IntegerRes;

/**
 * Created by pedroneto on 05/02/17.
 */
public class Converter {

//   private int [] values  = {0,1,2,3,4,5,6,7,8,9,10,'A','B','C','D','E','F'};

    public static String convertDecimalBinary(long decimal){
        return Long.toBinaryString(decimal);
    }
    public static String convertDecimalOctal(long decimal){
        return Long.toOctalString(decimal);
    }
    public static String convertDecimalHexa(long decimal){
        return Long.toHexString(decimal);
    }

    public static String convertBinaryDecimal(long binary){
        String binaryString = Long.toString(binary);
        long decimalString = 0;
        binaryString = new StringBuilder(binaryString).reverse().toString();
        for(int i  = 0;  i < binaryString.length(); i++){
            decimalString += Long.valueOf(binaryString.charAt(i) + "") * Math.pow(2,i);
        }
        return Long.toString(decimalString);
    }

    public static String convertBinaryOctal(long binary){
        long decimal = Long.valueOf(convertBinaryDecimal(binary));
        return convertDecimalOctal(decimal);
    }

    public static String convertBinaryHexa(long binary){
        long decimal = Long.valueOf(convertBinaryDecimal(binary));
        return convertDecimalHexa(decimal);
    }

    public static String convertOctalDecimal(long octal){
        String octalString = Long.toString(octal);
        long decimal = 0 ;
        octalString = new StringBuilder(octalString).reverse().toString();
        for(int i = 0 ; i<octalString.length(); i++){
            decimal += Long.valueOf((octalString.charAt(i) + "")) * Math.pow(8,i);
        }
        return Long.toString(decimal);
    }

    public static String convertOctalBinary(long octal){
        long decimal = Long.valueOf(convertOctalDecimal(octal));
        return convertDecimalBinary(decimal);
    }

    public static String convertOctalHexa(long octal){
        long decimal = Long.valueOf(convertOctalDecimal(octal));
        return convertDecimalHexa(decimal);
    }

    public static String convertHexaDecimal(String hexa){
        long decimal = 0;
        hexa =new StringBuilder(hexa).reverse().toString();
        for(int i = 0 ; i < hexa.length() ; i++){
            decimal += findIndice(hexa.charAt(i)) * Math.pow(16,i);
        }
        return Long.toString(decimal);
    }

    public static String convertHexaOctal(String hexa){
        String decimal = convertHexaDecimal(hexa);
        return convertDecimalOctal(Long.valueOf(decimal));
    }

    public static String convertHexaBinary(String hexa){
        String decimal = convertHexaDecimal(hexa);
        return convertDecimalBinary(Long.valueOf(decimal));
    }

    private static int findIndice(char indice){

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
