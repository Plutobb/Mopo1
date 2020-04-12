package MoPo_ALG;

public class test {
    public static void help(int x){
        if (x <= 0){
            return;
        }
        int i = x%10;
        x = x/10;
        //System.out.println(i);
        help(x);
        System.out.println(i);
    }

    public static void main(String[] args) {
        help(100);
    }
}
