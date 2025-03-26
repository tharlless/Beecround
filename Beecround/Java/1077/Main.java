import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCasos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCasos; i++) {
            String infix = scanner.nextLine();
            String posfixa = infixParaPosfixa(infix);
            System.out.println(posfixa);
        }
        scanner.close();
    }

    public static String infixParaPosfixa(String infix) {
        Pilha stack = new Pilha();
        StringBuilder posfixa = new StringBuilder();

        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                posfixa.append(ch); // Adiciona operandos diretamente
            } else if (ch == '(') {
                stack.push(ch); // Empilha parêntese de abertura
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    posfixa.append(stack.pop()); // Desempilha até encontrar '('
                }
                stack.pop(); // Remove o '(' da pilha
            } else if (Converter.ehOperador(ch)) {
                while (!stack.isEmpty() && Converter.precedencia(ch) <= Converter.precedencia(stack.peek())) {
                    posfixa.append(stack.pop()); // Desempilha operadores com maior ou igual precedência
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            posfixa.append(stack.pop()); // Adiciona operadores restantes na pilha
        }

        return posfixa.toString();
    }
}

class Converter {
    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static boolean ehOperador(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
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

    public char peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
