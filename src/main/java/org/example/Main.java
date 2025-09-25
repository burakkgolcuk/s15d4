// src/main/java/org/example/Main.java
package org.example;

import java.util.Stack;

public class Main {

    // Challenge I: Palindrome kontrolü (Stack ile)
    public static boolean checkForPalindrome(String input) {
        if (input == null) return false;

        // harf/rakam dışını at, lower-case
        StringBuilder cleaned = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                cleaned.append(Character.toLowerCase(ch));
            }
        }

        String s = cleaned.toString();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder reversed = new StringBuilder(s.length());
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return s.equals(reversed.toString());
    }

    // Challenge III: Decimal -> Binary (Stack ile)
    public static String convertDecimalToBinary(int n) {
        if (n == 0) return "0";
        if (n < 0) {
            // negatifler için basit yaklaşım
            return "-" + convertDecimalToBinary(-n);
        }

        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
