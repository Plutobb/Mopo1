package MoPo_ALG;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int sum1 = 0;
//        int sum2 = 1;
//        while (true){
//            int tmp = sum2;
//            sum2 = sum1 + sum2;
//            sum1 = tmp;
//            if (sum1 <= x && sum2 >=x){
//                int a = x - sum1;
//                int b = sum2 - x;
//                System.out.print(Math.min(a, b));
//                break;
//            }
//        }
        Scanner in = new Scanner(System.in);
        String[] total = new String[2500];
        int size = 0;
        while (in.hasNext()){
            String str = in.next();
            int same = 0;
            for (int i = 0; i < size; i++) {
                if (total[i].equals(str)) {
                    same = 1;
                    break;
                }
            }
            if (same == 0){
                total[size] = str;
                size++;
            }
        }
        System.out.println(size);
    }
}
