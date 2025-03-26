import java.util.Scanner;

public class Main {
    
    static class Pilha {
        private int[] elementos;
        private int topo;
        private int capacidade;

        // Construtor da pilha
        public Pilha(int tamanho) {
            this.capacidade = tamanho;
            this.elementos = new int[tamanho];
            this.topo = 0; // Inicia o topo da pilha como 0
        }

        // Adiciona um elemento à pilha
        public void push(int numero) {
            if (topo < capacidade) {
                elementos[topo++] = numero; // Adiciona o elemento e aumenta o topo
            }
        }

        // Remove e retorna o elemento do topo da pilha
        public int pop() {
            if (topo > 0) {
                return elementos[--topo]; // Retorna o elemento e diminui o topo
            }
            return -1; // Se a pilha estiver vazia
        }

        // Retorna o tamanho atual da pilha
        public int size() {
            return topo;
        }

        // Verifica se a pilha está vazia
        public boolean isEmpty() {
            return topo == 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Pilha pilhaPar = new Pilha(5);
        Pilha pilhaImpar = new Pilha(5);
        
        // Ler 15 números
        for (int i = 0; i < 15; i++) {
            int numero = scanner.nextInt();

            if (numero % 2 == 0) {  // Número par
                pilhaPar.push(numero);
                if (pilhaPar.size() == 5) {  // Pilha cheia, imprime e reseta
                    imprimirPilha(pilhaPar, "par");
                }
            } else {  // Número ímpar
                pilhaImpar.push(numero);
                if (pilhaImpar.size() == 5) {  // Pilha cheia, imprime e reseta
                    imprimirPilha(pilhaImpar, "impar");
                }
            }
        }

        // Imprimir os elementos restantes
        imprimirRestantes(pilhaImpar, "impar");
        imprimirRestantes(pilhaPar, "par");

        scanner.close();
    }
    
    // Função para imprimir os elementos da pilha
    private static void imprimirPilha(Pilha pilha, String tipo) {
        for (int i = 0; i < 5; i++) {
            System.out.println(tipo + "[" + i + "] = " + pilha.pop());
        }
    }

    // Função para imprimir elementos restantes que não completaram a pilha
    private static void imprimirRestantes(Pilha pilha, String tipo) {
        while (!pilha.isEmpty()) {
            System.out.println(tipo + "[" + (5 - pilha.size()) + "] = " + pilha.pop());
        }
    }
}