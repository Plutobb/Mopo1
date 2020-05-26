package MoPo_Test;

import java.util.Scanner;

public class testJava {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        StringBuffer b = new StringBuffer(a);
        int i = 0;
        while (i < b.length()){
            char c = b.charAt(i);
            if (c == ' '){
                b.deleteCharAt(i);
            }else {
                i++;
            }
        }
        System.out.println(b.toString());
    }
}
