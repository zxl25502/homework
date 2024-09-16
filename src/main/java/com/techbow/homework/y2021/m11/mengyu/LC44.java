package com.techbow.homework.y2021.m11.mengyu;

public class LC44 {
    public boolean isMatch (String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        int i = 0;
        int j = 0;
        int star = -1;
        int match = 0;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }else return false;
        }
        while (j < p.length() && p.charAt(j) == '*') j++;
        return j == p.length();
    }
}
