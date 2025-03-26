import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); 
        FilaCircular fila = new FilaCircular(n);
        
        // Adiciona os IDs dos funcionários na fila
        for (int i = 0; i < n; i++) {
            int idFuncionario = scanner.nextInt();
            fila.enfileirar(idFuncionario);
        }

        int m = scanner.nextInt(); 
        int[] idsParaRemover = new int[m];
        
        // Leitura dos IDs dos funcionários que sairão
        for (int i = 0; i < m; i++) {
            idsParaRemover[i] = scanner.nextInt();
        }

        // Remove os IDs da fila
        FilaCircular novaFila = new FilaCircular(n);
        while (!fila.estaVazia()) {
            int idAtual = fila.desenfileirar();
            if (!deveRemover(idAtual, idsParaRemover)) {
                novaFila.enfileirar(idAtual);
            }
        }

        // Exibe a fila final dos funcionários restantes, sem espaços extras
        boolean primeiro = true;
        while (!novaFila.estaVazia()) {
            if (!primeiro) {
                System.out.print(" ");
            }
            System.out.print(novaFila.desenfileirar());
            primeiro = false;
        }
        System.out.println();
        
        scanner.close();
    }

    // Função auxiliar para verificar se o ID deve ser removido
    public static boolean deveRemover(int id, int[] idsParaRemover) {
        for (int idRemover : idsParaRemover) {
            if (id == idRemover) {
                return true;
            }
        }
        return false;
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

    public void enfileirar(int elemento) {
        if (tamanho == capacidade) {
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
