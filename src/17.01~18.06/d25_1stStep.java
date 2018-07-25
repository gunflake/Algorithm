import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NamHyukMin on 2017. 4. 25..
 */
public class d25_1stStep {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al = new ArrayList<>();
        for(;sc.hasNextLine();){
            al.add(sc.nextLine());
        }
        for(int i=0;i<al.size();i++)
            System.out.println(al.get(i));
    }
}
