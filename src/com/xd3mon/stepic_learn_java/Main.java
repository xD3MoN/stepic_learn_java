package com.xd3mon.stepic_learn_java;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static boolean isPowerOfTwo(int value){
        int f = Math.abs(value);
        int d = (int)(Math.log(f+1) / Math.log(2));
        boolean ans = (f == 1 << d);
        if (f == 1)  ans = true;
        return ans;
    }

    public static boolean isPalindrome(String text) {
        String tmp = text.replaceAll("[^A-Za-z1-9]", "").toLowerCase();
        String tmp2 = new StringBuilder(tmp).reverse().toString();
        return tmp.equals(tmp2); // your implementation here
    }

    public static BigInteger factorial(int value) {
        BigInteger ans = BigInteger.valueOf(1);
        while ( value > 0)
        {
            ans = ans.multiply(BigInteger.valueOf(value));
            value--;
        }
        return ans; // your implementation here
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] ans = new int[a1.length+a2.length];
        int atmp = 0, btmp = 0;
        for (int i=0; i < ans.length; i++) {
            if (atmp < a1.length && btmp < a2.length)
            {
                if (a1[atmp] < a2[btmp]) {
                    ans[i] = a1[atmp];
                    atmp++;
                } else {
                    ans[i] = a2[btmp];
                    btmp++;
                }
            } else if (atmp < a1.length && btmp == a2.length) {
                ans[i] = a1[atmp];
                atmp++;
            } else if (atmp==a1.length && btmp < a2.length) {
                ans[i] = a2[btmp];
                btmp++;
            }
        }
//        System.arraycopy(a1, 0, ans, 0, a1.length);
//        System.arraycopy(a2, 0, ans, a1.length, a2.length);
//        Arrays.sort(ans);
        return ans; // your implementation here
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder("");
        StringBuilder[] ans;
        ans = new StringBuilder[roles.length];
        for (int i=0; i<ans.length;i++) {ans[i] = new StringBuilder();}
        for (int i=0; i<textLines.length;i++) {
            String[] splited = textLines[i].split(":");
            String role = splited[0];
            splited[0] = "";
            StringBuilder text = new StringBuilder();
            for (String elem: splited) if (!(elem.equals(""))) text.append(String.format("%1s:", elem));

            text.delete(text.length()-1, text.length());

            for (int j=0; j<roles.length; j++) {
                if (role.equals(roles[j])) {
                    ans[j].append(String.format("%1d)%2s%n", i+1, text.toString()));
                }
            }
        }
        for (int i = 0; i < roles.length; i++)
        {
            result.append(String.format("%1s%n", roles[i]));
            result.append(ans[i]);
            if (i < roles.length - 1) {
                result.append("\r\n");
            }

        }
        return result.toString();
    }

    public static boolean isSumOfTwoSquares(int value) {
        int sqrt_value = (int)Math.sqrt(value);
        for (int i = 0; i < sqrt_value+1; i++){
            for (int j=0; j<sqrt_value+1;j++) {
                if (i*i+j*j==value) {return true;}
            }
        }
        return false; // your implementation here
    }

    public static boolean areAnagrams(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        if (len_a != len_b) {return false;}

        char[] ca = a.toLowerCase().toCharArray();
        char[] cb = b.toLowerCase().toCharArray();

        for (int i = 0; i < len_a; i++) {
            boolean isThis = false;
            for (int j = 0; j < len_b; j++) {
                if (ca[i] == cb[j]) {
                    isThis = true;
                }
            }
            if (isThis == false) { return false;}
        }

        return true; // your implementation here
    }

    public static void main(String[] args) {
        int[] a = {0,2};
        int[] b = {1,3};

        String[] roles = { "Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String[] textLines ={ "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
        "Аммос Федорович: Как ревизор?",
        "Артемий Филиппович: Как ревизор?",
        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
        "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",};


        String na = "Апельсин";
        String nb = "Спаниель";
        System.out.print(areAnagrams(na, nb));
        //int value = 232;
        //System.out.print(isSumOfTwoSquares(value));

        //System.out.print(printTextPerRole(roles, textLines));
       // byte[] ololo = {(byte)0xd0, (byte)0xa1, (byte)0xd0, (byte)0xa2, (byte)0xd0, (byte)0x95, (byte)0xd0, (byte)0x9f, (byte)0xd0, (byte)0x98, (byte)0xd0, (byte)0x9a, (byte)0x3a, (byte)0x29};
        //String olo = new String(ololo);
        //System.out.print(olo);
//        for (int value:mergeArrays(a,b)) System.out.println(value);


	// write your code here
    }
}



