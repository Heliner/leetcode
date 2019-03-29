import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(24, 3));
    }
}
