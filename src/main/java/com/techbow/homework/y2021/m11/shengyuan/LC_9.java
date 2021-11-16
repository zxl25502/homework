package com.techbow.homework.y2021.m11.shengyuan;

public class LC_9 {
    public boolean ifPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return x == num || x == num / 10;
    }
    public static void main(String[] args) {
        LC_9 test = new LC_9();
        int input = 1221;
        boolean result = test.ifPalindrome(input);
        System.out.println(result);
    }
}
