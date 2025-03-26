import java.util.*;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < N;i++){
            String[] itens = sc.nextLine().split(" ");

            Set<String> conjuntosItems = new TreeSet<>(Arrays.asList(itens));

            StringBuilder resultado = new StringBuilder();

            for(String item : conjuntosItems){
                if(resultado.length() > 0){
                    resultado.append(" ");
                }
                resultado.append(item);
            }

            System.out.println(resultado.toString());

        }
        sc.close();
    }
}
