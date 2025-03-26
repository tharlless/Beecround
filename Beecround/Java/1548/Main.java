import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int casos = scanner.nextInt();

        for (int i = 0; i < casos; i++) {
            int n = scanner.nextInt();
            int[] notas = new int[n];
            
            FilaCircular fila = new FilaCircular(n);

            for (int j = 0; j < n; j++) {
                int nota = scanner.nextInt();
                fila.enfileirar(nota);
                notas[j] = nota;
            }

            Arrays.sort(notas);
            int[] notasOrdenadas = new int[n];
            for (int j = 0; j < n; j++) {
                notasOrdenadas[j] = notas[n - j - 1];
            }

            int alunosPosicaoCorreta = 0;
            for (int j = 0; j < n; j++) {
                if (fila.desenfileirar() == notasOrdenadas[j]) {
                    alunosPosicaoCorreta++;
                }
            }

            System.out.println(alunosPosicaoCorreta);
        }
        
        scanner.close();
    }
}

class FilaCircular {
    private int[] fila;
    private int inicio, fim, tamanho, capacidade;

    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        fila = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    public void enfileirar(int elemento) {
        if (estaCheia()) {
            System.out.println("Fila cheia!");
            return;
        }
        fim = (fim + 1) % capacidade;
        fila[fim] = elemento;
        tamanho++;
    }

    public int desenfileirar() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
            return -1;
        }
        int elemento = fila[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elemento;
    }
}
