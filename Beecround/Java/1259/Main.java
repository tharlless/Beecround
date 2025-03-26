import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        
        int N = sc.nextInt();

        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        for (int i =0; i < N; i++){
            int numero = sc.nextInt();

            if(numero % 2 == 0){
                pares.add(numero);
            }
            else{
                impares.add(numero);
            }
        }
        Collections.sort(pares);

        Collections.sort(impares, Collections.reverseOrder());

        for(int par : pares){
            System.out.println(par);
        }
        for(int imp : impares){
            System.out.println(imp);
        }
        sc.close();
    }



}