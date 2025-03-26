import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //entrada para o numero de testes

        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(MDC(a, b));
        }
        sc.close();
    }
    /* 
    * 
    public static int  ContadorRepeticao(int j){
        int cont = 0;
        if(cont < j){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(MDC(a, b));
        }
        return ContadorRepeticao(j);
    }
    
*/
    public static int MDC(int a, int b){//Loop para quando receber loop
        if(b == 0){
            return a;
        }
        return MDC(b, a % b);
    }
}
