import java.util.Scanner;

// Classe que representa uma criança com nome e ficha.
class Crianca {
    String nome;
    int ficha;

    // Construtor que inicializa o nome e a ficha da criança.
    public Crianca(String nome, int ficha) {
        this.nome = nome;
        this.ficha = ficha;
    }
}

// Classe que representa um deque circular para armazenar as crianças.
class DequeCircular {
    private Crianca[] deque;  // Array para armazenar as crianças.
    private int frente;       // Índice do início do deque.
    private int traseira;     // Índice do final do deque.
    private int tamanho;      // Quantidade de crianças no deque.
    private int capacidade;   // Capacidade máxima do deque.

    // Construtor que inicializa o deque com uma capacidade específica.
    public DequeCircular(int capacidade) {
        this.capacidade = capacidade;
        this.deque = new Crianca[capacidade];
        this.frente = -1;
        this.traseira = -1;
        this.tamanho = 0;
    }

    // Método que verifica se o deque está vazio.
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Método que verifica se o deque está cheio.
    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    // Método que insere uma criança no final do deque.
    public void inserirNoFinal(Crianca crianca) {
        if (estaCheia()) throw new RuntimeException("Deque cheio");
        if (estaVazia()) {
            frente = traseira = 0; // Primeiro elemento inserido
        } else {
            traseira = (traseira + 1) % capacidade; // Ajusta a posição da traseira
        }
        deque[traseira] = crianca; // Coloca a criança na posição traseira
        tamanho++;
    }

    // Método que remove a criança em uma posição específica.
    public Crianca removerPosicao(int posicao) {
        if (estaVazia()) throw new RuntimeException("Deque vazio");

        Crianca removida = deque[(frente + posicao) % capacidade]; // Criança a ser removida
        for (int i = posicao; i != traseira; i = (i + 1) % capacidade) {
            deque[i] = deque[(i + 1) % capacidade]; // Move elementos para frente
        }
        traseira = (traseira - 1 + capacidade) % capacidade; // Ajusta o índice da traseira
        tamanho--;

        // Verifica se o deque ficou vazio e redefine os índices
        if (tamanho == 0) frente = traseira = -1;

        return removida; // Retorna a criança removida
    }

    // Método que obtém a criança em uma posição específica.
    public Crianca obterCriancaNaPosicao(int posicao) {
        if (estaVazia()) throw new RuntimeException("Deque vazio");
        return deque[(frente + posicao) % capacidade]; // Retorna a criança na posição
    }

    // Método que obtém a criança no início do deque.
    public Crianca obterInicio() {
        if (estaVazia()) throw new RuntimeException("Deque vazio");
        return deque[frente];
    }

    // Método que retorna o tamanho atual do deque.
    public int obterTamanho() {
        return tamanho;
    }
}

// Classe principal que executa o programa.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o número de casos
        int numeroDeCasos = scanner.nextInt();

        if (numeroDeCasos == 0) {
            //System.out.println("Nenhum caso para processar.");
            scanner.close();
            return;
        }

        // Para cada caso, processa o número de crianças e a lógica de eliminação.
        for (int i = 1; i <= numeroDeCasos; i++) {
            //System.out.print("Digite o número de crianças no caso " + i + ": ");
            int numeroDeCriancas = scanner.nextInt();
            scanner.nextLine();  // Limpa o buffer

            // Cria um deque circular para o caso atual.
            DequeCircular circulo = new DequeCircular(numeroDeCriancas);
            for (int j = 0; j < numeroDeCriancas; j++) {
                //System.out.print("Digite o nome e a ficha da criança " + (j + 1) + ": ");
                String nome = scanner.next();
                int ficha = scanner.nextInt();
                circulo.inserirNoFinal(new Crianca(nome, ficha)); // Insere a criança no deque
            }

            int posicaoAtual = 0; // Inicia na primeira criança
            while (circulo.obterTamanho() > 1) { // Continua enquanto houver mais de uma criança
                Crianca atual = circulo.obterCriancaNaPosicao(posicaoAtual); // Obtém a criança atual
                int passos = atual.ficha;

                // Remove a criança atual e informa a eliminação
                System.out.println("Criança eliminada: " + circulo.removerPosicao(posicaoAtual).nome);

                if (circulo.obterTamanho() == 0) break; // Verifica se o deque está vazio

                // Define a nova posição de acordo com o número de passos e paridade da ficha
                if (passos % 2 == 0) { // Par: horário
                    posicaoAtual = (posicaoAtual + (passos -1)) % circulo.obterTamanho();
                } else { // Ímpar: anti-horário
                    posicaoAtual = (posicaoAtual - (passos -1) + circulo.obterTamanho()) % circulo.obterTamanho();
                }
            }

            // Exibe a criança vencedora
            System.out.println("Vencedor(a): " + circulo.obterInicio().nome);
        }

        scanner.close(); // Fecha o scanner após o processamento
    }
}