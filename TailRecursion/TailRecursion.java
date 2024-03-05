
import java.util.Scanner;

public class TailRecursion {

    // Compute power 2^n recursively.
    //
    // The computation must use _tail recursion_!
    // Note: This requires the implementation of a tail recursive
    //       auxiliary method that is called by pow2()!)
    //
    public static int pow2Tail(int n, int sum) { // The auxiliary method that is called by pow2()
        if (n == 0) { //If n is 0, the method returns the sum
            return sum;
        } else {     //Otherwise, it calls itself with n - 1 and sum * 2 as the new parameters.
            return pow2Tail(n - 1, sum * 2);
        }
    }
    public static int pow2(int n) { //This method calls the pow2Tail method with n and 1 as the initial parameters and returns the result
        // TODO: implementation
        return pow2Tail(n, 1);
    }

    // Compute the sum of factors (divisors) of n
    // The factors include 1 but exclude n, e.g., sumFactors(6) ==
    // 1+2+3 == 6 .
    //
    // The computation must use _tail recursion_!
    //
    private static int sumFactorsTail(int n, int i, int sum) {
        if (i == n) { //if i is equal to n, the method returns the sum
            return sum;
        } else if (n % i == 0) { //If n is divisible by i, it calls itself with n, i + 1, and sum + i as the new parameters.
            return sumFactorsTail(n, i + 1, sum + i);
        } else { //Otherwise, it calls itself with n, i + 1, ancd sum as the new parameters.
            return sumFactorsTail(n, i + 1, sum);
        }
    }
    public static int sumFactors(int n) { //It calls the sumFactorsTail method with n, 1, and 0 as the initial parameters and returns the result.
        // TODO: implementation
        return sumFactorsTail(n, 1, 0);
    }

    public static void main(String[] args) {
        // TODO: test
        // reads input, calls the pow2 and sumfactors methods and print the result.
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
         int pow2 = pow2(input);
         int sumFactors = sumFactors(input);
        System.out.println(pow2);
        System.out.println(sumFactors);

    }
}