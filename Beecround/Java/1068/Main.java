import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (isBalanced(expression)) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }

        scanner.close();
    }

    public static boolean isBalanced(String expression) {
        Pilha stack = new Pilha();

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Se tenta fechar sem abrir
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // Se a pilha está vazia, está balanceado
    }
}

class Pilha {
    private Node top;

    private class Node {
        char value;
        Node next;

        Node(char value) {
            this.value = value;
            this.next = null;
        }
    }

    public void push(char value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        char value = top.value;
        top = top.next;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public char peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return top.value;
    }
}
