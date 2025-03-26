import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while ((n = scanner.nextInt()) != 0) {
            while (true) {
                int[] target = new int[n];
                target[0] = scanner.nextInt();
                if (target[0] == 0) break;

                for (int i = 1; i < n; i++) {
                    target[i] = scanner.nextInt();
                }

                if (isPossible(n, target)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    public static boolean isPossible(int n, int[] target) {
        VagaoStack stack = new VagaoStack();
        int j = 0;

        for (int i = 1; i <= n; i++) {
            stack.push(i);

            while (!stack.isEmpty() && stack.peek() == target[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}

class VagaoStack {
    private Node top;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

