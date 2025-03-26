import java.util.Scanner;

public class Main3{
    public static void Main(String[] args){
        Scanner _scanner = new Scanner(System.in);

        
        for (int i = 0; i < 100; i++){
            double leitor = _scanner.nextDouble();

            if(leitor <=10.0){
                System.out.println("A[" + i + "] = " + leitor);
            }
        }
        _scanner.close();
    }
}
