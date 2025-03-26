import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        int count = 0;

        for(int i = 0; i < c; i++){
            int status = sc.nextInt();
            if(status == 1){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}