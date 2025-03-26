import java.util.ArrayList;
import java.util.Scanner;

public class Quest1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        
        while ((n = scanner.nextInt()) != 0) {
            FilaCircular fila = new FilaCircular(n);
            ArrayList<Integer> descartadas = new ArrayList<>();

            // Inicializa a fila com cartas de 1 até n
            for (int i = 1; i <= n; i++) {
                fila.enfileirar(i);
            }

            // Processa as cartas conforme a regra do problema
            while (fila.getTamanho() > 1) {
                // Remove a carta do topo e adiciona à lista de descartadas
                descartadas.add(fila.desenfileirar());
                // Move a próxima carta para o final da fila
                fila.enfileirar(fila.desenfileirar());
            }

            // Exibe os resultados
            System.out.println("Discarded cards: " + descartadas.toString().replace("[", "").replace("]", ""));
            System.out.println("Remaining card: " + fila.desenfileirar());
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

    public int getTamanho() {  // Adicionei o método getTamanho()
        return tamanho;
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

    public int espiar() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
            return -1;
        }
        return fila[inicio];
    }
}
