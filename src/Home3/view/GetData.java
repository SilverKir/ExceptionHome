package Home3.view;

import java.util.Scanner;

public class GetData {

    public String getUserData(String message){
        Scanner scanner=new Scanner(System.in);
        System.out.println(message);
        String result=scanner.nextLine();
        scanner.close();
        return result;
    }
}
