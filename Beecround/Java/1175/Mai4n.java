import java.util.Scanner;

public class Mai4n{
    public static void Main(String[] args){
    Scanner _scanner = new Scanner(System.in);

    int [] SaveNumber = new int[20];
    
    for (int i = 0; i < 20; i++){

        SaveNumber[19-i] = _scanner.nextInt();

    }
    for(int i = 0; i <20; i++){
        System.out.println("N[" + i + "] = " + SaveNumber[i]);
    }
    _scanner.close();
    }
}
