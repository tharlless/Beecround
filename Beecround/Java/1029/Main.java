import java.util.Scanner;

public class Main {
    
    public static int cont = 0; // Variável global para contar as chamadas recursivas

    public static void main(String[] args) {

        Scanner _sc = new Scanner(System.in);

        int n = _sc.nextInt();

        for(int i = 0; i < n; i++){
        
        int b = _sc.nextInt(); // Número para o qual queremos calcular o Fibonacci
        int resultado = fib(b); // Chama a função fib e guarda o resultado

        // Imprime o número de chamadas recursivas
        System.out.printf("fib(%d) = %d ", b, cont - 1); 
        // Imprime o resultado final do Fibonacci
        System.out.printf("calls = %d\n", resultado);
        
        cont = 0;
        }
    }

    public static int fib(int n) {
        // Contar a chamada da função
        cont++;
        if (n < 2) {
            return n;
        }else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
