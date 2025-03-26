import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner _scanner = new Scanner(System.in);

        long[] fib = new long[61];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= 60; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        int T = _scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = _scanner.nextInt();
            System.out.println("Fib(" + N + ") = " + fib[N]);    
        }
        
        _scanner.close();
    }
}
