import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Lista para pares e lista para ímpares
        ListaLSE<Integer> pares = new ListaLSE<>();
        ListaLSE<Integer> impares = new ListaLSE<>();

        // Adiciona números nas listas
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            if (value % 2 == 0) {
                pares.add(value); // pares em ordem crescente
            } else {
                impares.add(value); // ímpares em ordem crescente inicialmente
            }
        }

        // Imprime os pares em ordem crescente
        pares.printList();

        // Reverte a ordem dos ímpares para exibir em ordem decrescente
        reversePrintList(impares);

        scanner.close();
    }

    // Função para imprimir uma lista em ordem reversa
    public static void reversePrintList(ListaLSE<Integer> lista) {
        int size = lista.size();
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(lista.get(i));
        }
    }
}

class ListaLSE<T extends Comparable<T>> {
    private Node<T> head;
    private int size;

    // Classe interna Node
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public ListaLSE() {
        this.head = null;
        this.size = 0;
    }

    // Adiciona elemento de forma ordenada
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null || head.value.compareTo(value) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.value.compareTo(value) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Remove o elemento especificado
    public boolean remove(T value) {
        if (head == null) return false;

        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.value.equals(value)) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        size--;
        return true;
    }

    // Retorna o elemento na posição especificada
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    // Verifica se a lista contém um elemento específico
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

    // Exibe a lista
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
