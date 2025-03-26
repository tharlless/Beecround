import java.util.Scanner;

public class Main {

    // Função para resolver o problema de Josephus ajustada
    public static int engProblem(int nPolos, int mDesligados) {
        int lightsOn = 0;
        // Ajustando para iniciar do índice 2, pois estamos sempre eliminando uma posição
        for (int i = 2; i <= nPolos; i++) {
            lightsOn = (lightsOn + mDesligados) % i;
        }
        // Retorna a posição ajustada para base 1
        return lightsOn + 1;
    }

    // Função para encontrar o menor mDesligados tal que Wellington (posição 13) é o último a ser desligado
    public static int foundLast(int nPolos) {
        int mDesligados = 1;
        // Buscando o menor m tal que Wellington (posição 13) é a última a ser desligada
        while (true) {
            if (engProblem(nPolos, mDesligados) == 13) {
                return mDesligados;
            }
            mDesligados++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) { 
            int nPolos = sc.nextInt(); // Número de regiões
            if (nPolos == 0) { // Condição de saída
                break;
            }
            int minimumValue = foundLast(nPolos); // Calcula o m para que Wellington seja o último
            System.out.println(minimumValue); // Imprime o resultado
        }

        sc.close();
    }
}
