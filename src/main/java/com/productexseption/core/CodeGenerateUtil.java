package com.productexseption.core;

public class CodeGenerateUtil {
    public static String generateCode(int n) {
        char[] pw = new char[n];
        int c;
        for (int i = 0; i < n; i++) {
            c = '0' + (int) (Math.random() * 10);
            pw[i] = (char) c;
        }
        return new String(pw);
    }
}
