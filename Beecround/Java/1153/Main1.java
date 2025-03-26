import java.util.Scanner;

public class Main1{
    public static void Main(String[] args){
        Scanner _scanner = new Scanner(System.in);
        
        int fatorial = 1;
        int n = _scanner.nextInt();

        for(int i = 1; i <= n; i++){
            fatorial *= i;
        }
        System.out.println(fatorial);
        _scanner.close();
    }
}
