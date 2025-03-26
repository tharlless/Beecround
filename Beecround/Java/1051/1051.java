import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Lê o número de termos
        
        // Inicializa os dois primeiros termos da sequência de Fibonacci
        int a = 0, b = 1;

        // Para imprimir os primeiros N termos
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                System.out.print(a); // Último termo não tem espaço no final
            } else {
                System.out.print(a + " "); // Imprime com um espaço após cada termo
            }
            
            // Atualiza os valores de a e b
            int next = a + b;
            a = b;
            b = next;
        }
        
        System.out.println(); // Quebra de linha no final da saída
        sc.close();
    }
}
