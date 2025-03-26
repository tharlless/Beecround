import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner _scanner = new Scanner(System.in);

        int []par = new int[5];
        int []impar = new int[5];

        int parIndex = 0, imparIndex = 0;

        for(int i = 0; i < 15; i++){
            int num  = _scanner.nextInt();

            if(num % 2 == 0){
                par[parIndex] = num;
                parIndex++;
            }
            else{
                impar[imparIndex] = num;
                imparIndex++;
            }

            if(parIndex == 5){
                for (int j = 0; j < 5; j++) {
                    System.out.println("par[" + j + "] = " + par[j]);
                }
                parIndex = 0;
            }
            if(imparIndex == 5){
                for (int j = 0; j < 5; j++) {
                    System.out.println("impar[" + j + "] = " + impar[j]);
                }
                imparIndex = 0;
            }
        }

        for( int j = 0; j < imparIndex; j++){
            System.out.println("par[" + j + "] = " + par[j]);            
        }
        
        _scanner.close();
    }
}
