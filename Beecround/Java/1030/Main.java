
import java.util.Scanner;

public class Main{
    public static int josephus(int nPessoas, int killposition){
        if(nPessoas == 1){
            return 1;
        }else{
            return (josephus(nPessoas-1, killposition) + killposition - 1) % nPessoas + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teste = sc.nextInt();

        for(int i = 1; i <= teste; i++){
            int nPessoas = sc.nextInt();
            int killposition = sc.nextInt();
            int survive = josephus(nPessoas, killposition);
            System.out.println("Case " + i + ": " + survive);
        }
        sc.close();
    }
}