import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);

        Set<String> pokemonsCapturados = new HashSet<>();

        while (sc.hasNextLine()) {
            String pokemon = sc.nextLine().trim();
            pokemonsCapturados.add(pokemon);
        }

        int capturados = pokemonsCapturados.size();
        int faltamcapturar = 152 - capturados;

        System.out.println("Falta(m) " + faltamcapturar + " pomekon(s).");
    
        sc.close();
    
    }
}
