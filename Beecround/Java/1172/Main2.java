import java.util.Scanner;

public class Main2{
    public static void Main(String[] args){
        Scanner _scanner = new Scanner(System.in);
        

        for (int i = 0; i < 10; i++){
            int n = _scanner.nextInt();

            
            if(n <= 0){
                n = 1;
            }

            System.out.println("X[" + i +"] = " + n );
        }
        _scanner.close();
    }
}
