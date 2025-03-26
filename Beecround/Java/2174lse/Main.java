import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Número de Pokémons capturados
        scanner.nextLine(); // Limpa o buffer

        // Lista para armazenar Pokémons capturados sem duplicatas
        ListaLSE<String> pokemonsCapturados = new ListaLSE<>();

        // Leitura dos Pokémons e adição na lista se ainda não estiverem presentes
        for (int i = 0; i < n; i++) {
            String pokemon = scanner.nextLine().trim();
            pokemonsCapturados.add(pokemon); // Adiciona apenas se for distinto
        }

        // Exibe a quantidade de Pokémons distintos capturados
        System.out.println("Falta(m) " + (151 - pokemonsCapturados.size()) + " pomekon(s).");

        scanner.close();
    }
}

class ListaLSE<T> {
    private Node<T> head;
    private int size;

    // Classe Node interna
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    // Construtor
    public ListaLSE() {
        this.head = null;
        this.size = 0;
    }

    // Método para adicionar um elemento, evitando duplicados
    public void add(T value) {
        if (!contains(value)) { // Evita duplicados
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    // Método para verificar se a lista contém um elemento
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Retorna o tamanho da lista
    public int size() {
        return size;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return size == 0;
    }
}
