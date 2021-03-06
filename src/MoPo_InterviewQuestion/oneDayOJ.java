package MoPo_InterviewQuestion;

import java.util.*;

public class oneDayOJ {
    public static Boolean huiWen(String c){
        int i = 0;
        int j = c.length()-1;
        while (i <= j){
            if (c.charAt(i) == c.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static int level(String a,String b){
        int ans = 0;
        String c;
        for (int i = 0; i <= a.length(); i++) {
            Boolean isHuiWen = false;
            String sub1 = a.substring(0,i);
            String sub2 = a.substring(i,a.length());
            c = sub1 + b + sub2;
            isHuiWen = huiWen(c);
            if (isHuiWen){
                ans++;
            }
        }
        return ans;
    }
    //回文字符转判断;
    public static void oj1(){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(level(a,b));
    }
    //----------------------------------------------------------------------------------------------------------
    public static int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> queue = new PriorityQueue(K);
        for (int i = 0; i < n; i++) {
            if (queue.size() < K){
                queue.add(a[i]);
                continue;
            }
            if (a[i] > queue.peek()){
                queue.poll();
                queue.add(a[i]);
            }
        }
        return queue.peek();
    }
    //寻找第K大
    public static void oj2(){
        int[] a = {1,2,5,3,2};
        System.out.println(findKth(a,5,3));
    }
    // ---------------------------------------------------------------------------------------------------
    //空瓶子换汽水问题；
    public static void waterNum(int n){
        int water = 0;
        int emptyBottle = n;
        int changeBottle = 0;
        //换完不够换的瓶子 < 3；
        int surplusBottle = 0;
        //总共换来的汽水；
        do {
            changeBottle = emptyBottle / 3;
            surplusBottle = emptyBottle % 3;
            water += changeBottle;
            emptyBottle = changeBottle + surplusBottle;
        } while (emptyBottle >= 3);
        if (emptyBottle == 2)
            water++;
        System.out.println(water);

    }
    public static void oj3(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            waterNum(n);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //有一数组任意找两个数如果前面数大于后面则成为逆序对，求出数组逆序对个数；
    public static int count(int[] A, int n) {
        // write code here
        int num = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (A[i] > A[j]){
                    num++;
                }
            }
        }
        return num;
    }
    public static void oj4(){
        int[] a = {1,2,3,4,5,6,7,0};
        System.out.println(count(a,8));
    }
    //---------------------------------------------------------------------------------------------------
    //读入一个字符串str，输出字符串中最长的数子串；
    public static String maxNUmString(String str){
        int begin = 0,end=0,max=0;
        String ret = null;
        Boolean isSameNumString = false;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= '0') && (str.charAt(i) <= '9')){
                if (!isSameNumString) {
                    begin = i;
                    isSameNumString = true;
                }
                if ((i+1) == str.length() || ((str.charAt(i+1) < '0') || (str.charAt(i+1) > '9'))){
                    end = i+1;
                    if (end > begin) {
                        isSameNumString = false;
                        if ((end - begin) > max) {
                            max = end - begin;
                            ret = str.substring(begin, end);
                        }
                    }
                }
            }
        }
        return ret;
    }
    public static void oj5(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(maxNUmString(str));
    }
    //---------------------------------------------------------------------------------------------------
    //给定一个字符串，设计算法判断括号是否合法；
    public static boolean chkParenthesis(String A, int n) {
        int left = 0,right = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') left++;
            else if (A.charAt(i) == ')') right++;
            else return false;
            if (left < right) return false;
        }
        return true;
    }
    public static void oj6(){
        String a = "()a()()";
        System.out.println(chkParenthesis(a,7));
    }
    //---------------------------------------------------------------------------------------------------
    //购买n个水果，使用可以装6个和8个的袋子，必须装满，求最少需要用到的袋子数，如果装不满，返回-1；
    public static int bagMinNum(int n){
        //最多需要8量装的袋子数；
        int max8 = n / 8;
        int need6 = n % 8;
        //当8量装袋子刚好够直接返回；
        if (need6 == 0){
            return max8;
        }else {
            for (int i = max8; i >= 0; i--) {
                need6 = (n - i * 8) / 6;
                if ((n - i * 8) % 6 == 0){
                    return i + need6;
                }
            }
            return -1;
        }
    }
    public static void oj7(){
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(bagMinNum(n));
    }
    //---------------------------------------------------------------------------------------------------
    //给两个字符串，删除第一个中含有第二个字符串中的所有字符；
    public static String deleteChar(String a,String b){
        StringBuilder aBuffer = new StringBuilder(a);
        HashSet<Character> bChar = new HashSet<>();
        for (Character character : b.toCharArray()){
            bChar.add(character);
        }
        for (int i = 0; i < aBuffer.length(); i++) {
            if (bChar.contains(aBuffer.charAt(i))){
                aBuffer.deleteCharAt(i);
                i--;
            }
        }
        return aBuffer.toString();
    }
    public static void oj8(){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(deleteChar(a,b));
    }
    //---------------------------------------------------------------------------------------------------
    //神奇的口袋问题,递归法;
    private static int[] a;
    public static int bag40(int n,int capacity){
        if (capacity == 0) return 1;
        if (n <= 0) return 0;
        //物品放不放如分别走两个方法;
        return bag40(n-1,capacity) + bag40(n-1,capacity - a[n-1]);
    }
    public static void oj9(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(bag40(n,40));
    }
    //---------------------------------------------------------------------------------------------------
    //两个栈实现队列;
    //stack1作为出口;
    Stack<Integer> stack1 = new Stack<Integer>();
    //stack2作为入口;
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);
    }
    public int pop() {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        int ret = stack1.pop();
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return ret;
    }
    public static void oj10(){
    }
    //---------------------------------------------------------------------------------------------------
    //计算糖果数量；
    public static void tangGuoNum(int a,int b,int c,int d){
        // a 代表 A-B；
        // b 代表 B-C；
        // c 代表 A+B；
        // d 代表 B+C；
        double A = (a+c)/2.0;
        double B = (b+d)/2.0;
        double C = (d-b)/2.0;
        if ((int)A == A && A >= 0){
            if ((int)B == B && B >= 0){
                if ((int) C == C && C >= 0){
                    System.out.print((int)A+" ");
                    System.out.print((int)B+" ");
                    System.out.print((int)C);
                    return;
                }
            }
        }
        System.out.print("No");
    }
    public static void oj11(){
        Scanner sc = new Scanner(System.in);
        int a,b,c,d;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        tangGuoNum(a,b,c,d);
    }
    //---------------------------------------------------------------------------------------------------
    //找出出现次数大于等于n/2的数；
    public static void findNum(int[] a){
        int size = a.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < size;i++) {
            int value = a[i];
            map.put(value, map.getOrDefault(value, 0) + 1);
            if(map.get(value) >= size/2){
                System.out.println(value);
                break;
            }
        }
    }
    public static void oj12(){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100];
        int size = 0;
        while (sc.hasNextInt()){
            a[size++] = sc.nextInt();
        }
        findNum(a);
    }
    //---------------------------------------------------------------------------------------------------
    //不要二,在网格W*H的盒子中,放物品每两个物品间欧几里得距离不能等于二;求最大能放的物品数;
    public static int noTwo(int h,int w){
        int[][] arr = new int[h][w];
        int maxNum = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int value = arr[i][j];
                if (value == 0){
                    maxNum++;
                    if (j + 2 < w){
                        arr[i][j+2] = 1;
                    }
                    if (i + 2 < h){
                        arr[i+2][j] = 1;
                    }
                }
            }
        }
        return maxNum;
    }
    public static void oj13(){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        System.out.println(noTwo(h,w));
    }
    //---------------------------------------------------------------------------------------------------
    //最小公倍数;
    public static int minGongBei(int a,int b){
        //求最小公倍数需要先找到最大公约数;
        //辗转相减法求出最大公约数;
       int maxGongBei = maxGongBei(a,b);
       return a * b / maxGongBei;
    }
    public static int maxGongBei(int a,int b){
        if (a != b) {
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
        }
        return a;
    }
    public static void oj14(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(minGongBei(a,b));
    }
    //---------------------------------------------------------------------------------------------------
    //输入n,代表数组有n个数,每隔两个删除一个,循环删除,直到剩下最后一个,返回下标;
    public static int endIndex(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1){
            index =(index + 2) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
    public static void oj15(){
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNextInt()){
            n = sc.nextInt();
            if (n > 1000) n = 1000;
            System.out.println(endIndex(n));
        }
    }
    //---------------------------------------------------------------------------------------------------
    //n个数中最小的k个,按升序输出;
    public static void minKNum(Integer[] a, int k){
        //这里测试比较器,删除比较器结果是升序;
        Arrays.sort(a,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void oj16(){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()){
            list.add(sc.nextInt());
        }
        Integer[] a = new Integer[list.size()-1];
        int k = list.get(list.size()-1);
        for (int i = 0; i < list.size()-1; i++) {
            a[i] = list.get(i);
        }
        minKNum(a,k);
    }
    //---------------------------------------------------------------------------------------------------
    //给定一个n,求出最小距离到斐波那契数;
    public static int changeToFibonacci(int n){
        int f1 = 0;
        int f2 = 1;
        while (f2 < n){
            int tmp = f2;
            f2 = f1 + f2;
            f1 = tmp;
        }
        int minStep = Math.min(f2-n,n-f1);
        return minStep;
    }
    public static void oj17(){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(changeToFibonacci(n));
    }
    //---------------------------------------------------------------------------------------------------
    //机器人走网格,X*Y的网格,每次只能往右走或者往下走,求出走路的方法数;
    public static int countWays(int x, int y) {
        // write code here
        //退出递归的条件;
        if (x==1 && y==1){
            //符合题目
            return 1;
        }
        if (x < 1||y < 1){
            //越界返回0
            return 0;
        }
        //x-1,代表往右走,y-1代表往下走,这里运用递归所以是反向的;
        return countWays(x-1,y)+countWays(x,y-1);
    }
    public static void oj18(){
        System.out.println(countWays(2,2));
    }
    //---------------------------------------------------------------------------------------------------
    //给一个长度不大于1000的正整数,输出每个数字出现的次数;
    //发现使用int会溢出,因此直接使用String来表示数字;
    public static void numTimes(String n){
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n.length(); i++) {
            Character value = n.charAt(i);
            map.put(value,map.getOrDefault(value,0)+1);
        }
        //hashmap输出自动按key升序排列;
        for (char ch : map.keySet()){
            System.out.println(ch+":"+map.get(ch));
        }
    }
    public static void oj19(){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        numTimes(n);
    }
    //---------------------------------------------------------------------------------------------------
    //根据数组A构建数组B
    //这道题相对简单,排除其中一个乘数,不使用除法;
    public static int[] multiply(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0; i < b.length; i++) {
            int end = 1;
            for (int j = 0; j < A.length; j++) {
                if (i == j){
                    continue;
                }
                end = end * A[j];
            }
            b[i] = end;
        }
        return b;
    }
    public static void oj20(){
        int[] a ={1,2,3,4,5};
        System.out.println(Arrays.toString(multiply(a)));
    }
    //---------------------------------------------------------------------------------------------------
    //无中间变量实现数字交换;
    public static int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0]+AB[1];
        AB[1] = AB[0]-AB[1];
        AB[0] = AB[0]-AB[1];
        return AB;
    }
    public static void oj21(){
        int[] AB = {1,2};
        exchangeAB(AB);
    }
    //---------------------------------------------------------------------------------------------------
    //格雷码
    public static String[] getGray(int n) {
        List<String> list = new LinkedList<>();
        list = getGrayHelp(n,"",list,true);
        return list.toArray(new String[0]);
    }
    public static List<String> getGrayHelp(int n,String str,List<String> list,Boolean left){
        if (n == 0){
            list.add(str);
            return list;
        }else {
            if (left) {
                //保证对称,当为左子树字符串+ 0 1, 右子树 + 1 0;
                getGrayHelp(n - 1, str + "0", list,true);
                getGrayHelp(n - 1, str + "1", list,false);
            }else {
                getGrayHelp(n - 1, str + "1", list,true);
                getGrayHelp(n - 1, str + "0", list,false);
            }
        }
        return list;
    }
    public static void oj22(){
        System.out.println(Arrays.toString(getGray(3)));
    }
    //---------------------------------------------------------------------------------------------------
    //给定若干个数,组成最小的数;
    public static String minNum(int[] arr){
        Arrays.sort(arr);
        if (arr[0] == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[0] = arr[i];
                    arr[i] = 0;
                    break;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for (int value : arr) {
            str.append(value);
        }
        return str.toString();
    }
    public static void oj23(){
        Scanner sc = new Scanner(System.in);
        int[] numTimes = new int[10];
        int i = 0;
        int length = 0;
        while (sc.hasNextInt()){
            numTimes[i++] = sc.nextInt();
        }
        for (int num : numTimes){
            length += num;
        }
        int[] arr = new int[length];
        int index = 0;
        int nextIndex = 0;
        for (int j = 0; j < numTimes.length; j++) {
            nextIndex += numTimes[j];
            for (; index < nextIndex; index++){
                arr[index] = j;
            }
        }
        System.out.println(minNum(arr));
    }
    //---------------------------------------------------------------------------------------------------
    //任意一个数的三次方一定是n个奇数的和;
    public static String jiShuZuHe(int n){
        int first = (n*n) - n + 1;
        int[] zuHe = new int[n];
        for (int i = 0; i < n; i++) {
            zuHe[i] = first + 2 * i;
        }
        String str =""+first;
        for (int i = 1; i < n; i++) {
            str = str + "+" + zuHe[i];
        }
        return str;
    }
    public static void oj24(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(jiShuZuHe(n));
        }
    }
    //---------------------------------------------------------------------------------------------------
    //另类加法;
    public static int addAB(int A, int B) {
        // write code here
        if (B == 0){
            return A;
        }else {
            int a = A ^ B;
            int b = (A & B) << 1;
            return addAB(a,b);
        }
    }
    public static void oj25() {
        addAB(1,2);
    }
    //---------------------------------------------------------------------------------------------------
    //小易找贝壳;
    private static final long MAX_STEP = 100_000;
    private static final long BeiKeIndex = 1_000_000_007;
    public static int findBeiKe(long x,int step){
        //4 * x +3 相当于 2 * x+1 运算2次;
        //8 * x +7 相当于 2 * x+1 运算3次;
        //这里step按 2*x+1 来算的话最多就是 300000步;
        while (x != 0 && step <= 3*MAX_STEP){
            x = (2 * x + 1) % BeiKeIndex;
            step++;
        }
        step = (step + 2) / 3;
        if (step <= MAX_STEP){
            return step;
        }else {
            return -1;
        }
    }
    public static void oj26() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            long n = sc.nextInt();
            System.out.println(findBeiKe(n,0));
        }
    }
    //---------------------------------------------------------------------------------------------------
    //洗牌;
    public static void xiPai(int[] pai,int k){
        int[] newPai = new int[pai.length];
        while (k > 0){
            int left = pai.length/2 - 1;
            int right = pai.length - 1;
            int index = newPai.length - 1;
            while (index >= 0){
                newPai[index--] = pai[right--];
                newPai[index--] = pai[left--];
            }
            k--;
            //将洗完的牌顺序赋值给pai数组;
            System.arraycopy(newPai, 0, pai, 0, newPai.length);
        }
        System.out.print(newPai[0]);
        for (int i = 1; i < newPai.length; i++) {
            System.out.print(" "+newPai[i]);
        }
    }
    public static void oj27() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int zuShu = sc.nextInt();
            while (zuShu > 0){
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] pai = new int[n*2];
                for (int i = 0; i < n*2; i++) {
                    pai[i] = sc.nextInt();
                }
                xiPai(pai,k);
                if (zuShu != 1){
                    System.out.println();
                }
                zuShu--;
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
    //统计同成绩学生人数;
    public static void tongJiCJi(int[] grade,int need){
        int num = 0;
        for (int value : grade){
            if (value == need){
                num++;
            }
        }
        System.out.println(num);
    }
    public static void oj28(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int total = sc.nextInt();
            if (total == 0){
                break;
            }
            int[] grade = new int[total];
            for (int i = 0; i < total; i++) {
                grade[i] = sc.nextInt();
            }
            int need = sc.nextInt();
            tongJiCJi(grade,need);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //***********火车出站序列;******************************
    public static void chuZhan(int[] jinZhan,int n){
        Stack<Integer> ans = new Stack<>();
        Queue<Integer> jin = new LinkedList<>();
        Stack<Integer> chu = new Stack<>();
        for (int num : jinZhan){
            jin.add(num);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                chu.push(jin.poll());
            }
            System.out.println(jin);
            System.out.println(chu);
            System.out.println("-----------");
        }
    }
    public static void oj29(){
    }
    //---------------------------------------------------------------------------------------------------
    //镜像二叉树;
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left =root.right;
        root.right = tmp;
        if (root.left != null){
            Mirror(root.left);
        }
        if (root.right != null){
            Mirror(root.right);
        }
    }
    public static void oj30(){
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(11);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        Mirror(a);
    }
    //---------------------------------------------------------------------------------------------------
    //出现奇数次的数字;
    public static void jiShuNum(int n,int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] ans = new int[2];
        int i = 0;
        for (int key:map.keySet()){
            if (map.get(key) % 2 != 0){
                ans[i++] = key;
            }
        }
        Arrays.sort(ans);
        System.out.print(ans[0]+" "+ans[1]);
    }
    public static void oj31(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            jiShuNum(n,arr);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //找出比数组值小的数下标,左右最近的第一个,没有返回-1;
    public static void minIndex(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int leftMin = -1;
            int rightMin = -1;
            for (int left = i;left >= 0;left--) {
                if (arr[left] < arr[i]){
                    leftMin = left;
                    break;
                }
            }
            for (int right = i;right < arr.length;right++){
                if (arr[right] < arr[i]){
                    rightMin = right;
                    break;
                }
            }
            System.out.println(leftMin+" "+rightMin);
        }
    }
    public static void oj32(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n =sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            minIndex(arr);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //基因序列;
    public static void jiYinCG(StringBuffer arr,int n){
        String ans = arr.substring(0,n);
        float cg_Ratio = -1;
        for (int i = 0; i < arr.length() - n; i++) {
            String test = arr.substring(i,i+n);
            int cgNum = 0;
            for (char ch : test.toCharArray()) {
                if (ch == 'G' || ch == 'C') {
                    cgNum++;
                }
            }
            if ((float)cgNum / n > cg_Ratio){
                ans = test;
                cg_Ratio = (float) cgNum / n;
            }
        }
        System.out.println(ans);
    }
    public static void oj33(){
        Scanner sc = new Scanner(System.in);
        StringBuffer arr = new StringBuffer();
        while (sc.hasNext() ){
            arr.append(sc.next());
            int n = sc.nextInt();
            jiYinCG(arr,n);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //换钱计划;
    public static void huanQian(){
        System.out.print(10 * 30+" ");
        int cent = 1;
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            sum += cent;
            cent = cent * 2;
        }
        System.out.print(sum);
    }
    public static void oj34(){
        huanQian();
    }
    //---------------------------------------------------------------------------------------------------
    //子串判断;
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; i++) {
            //自带API判断是否存在子串;
            ans[i] = s.contains(p[i]);
        }
        return ans;
    }
    public static void oj35(){
        String[] p = {"ab","bc","c","d"};
        String s = "abc";
        System.out.println(Arrays.toString(chkSubStr(p, 4, s)));
    }
    //---------------------------------------------------------------------------------------------------
    //输入输出,排序成绩;
    public static void  paiXuScore(){
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>();
        int peopleNum = sc.nextInt();
        int sortNum = sc.nextInt();
        for (int i = 0; i < peopleNum; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            map.put(name,score);
            list.addAll(map.entrySet());
            map.clear();
        }
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if (list.get(j).getValue() < list.get(j+1).getValue()){
                    Map.Entry<String,Integer> tmp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,tmp);
                }
            }
        }
        if (sortNum == 0){
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getKey()+" "+list.get(i).getValue());
            }
        }else if (sortNum == 1){
            for (int i = list.size()-1; i >= 0; i--) {
                System.out.println(list.get(i).getKey()+" "+list.get(i).getValue());
            }
        }
    }
    public static void oj36(){
        paiXuScore();
    }
    //---------------------------------------------------------------------------------------------------
    //微信红包;
    public static int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = gifts[i];
            map.put(num,map.getOrDefault(num,0)+1);
            //当放入size大于gifts一半的时候开始判断是否存在合适的金额;
            if (i+1 > n/2){
                if (map.get(num) > n / 2){
                    return num;
                }
            }
        }
        return 0;
    }
    public static void oj37(){
        int[] n = {1,1,1,2,2};
        System.out.println(getValue(n,5));
    }
    //---------------------------------------------------------------------------------------------------
    //链表分割;
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode smlTail = null;
        ListNode bigTail = null;
        ListNode bigHead = null;
        ListNode smlHead = null;
        while (pHead != null){
            ListNode node = new ListNode(pHead.val);
            if (pHead.val < x){
               if (smlHead == null){
                   smlHead = smlTail = node;
               }else {
                   smlTail.next = node;
                   smlTail = smlTail.next;
               }
            } else {
                if (bigHead == null){
                    bigHead = bigTail = node;
                }else {
                    bigTail.next = node;
                    bigTail = bigTail.next;
                }
            }
            pHead = pHead.next;
        }
        if (smlHead != null){
            smlTail.next = bigHead;
            return smlHead;
        }else {
            return bigHead;
        }
    }
    public static void oj38(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        System.out.println(partition(a,5));
    }
    //---------------------------------------------------------------------------------------------------
    //兔子数量

    public static void tuZiNUM(int month){

    }
    //---------------------------------------------------------------------------------------------------
    //密码对应;
    public static void miMa(){
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            StringBuffer ans = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                int as = 0;
                if (str.charAt(i) < 'F'&&str.charAt(i)>='A') {
                     as = str.charAt(i) + 21;
                }else if (str.charAt(i) >='F'&&str.charAt(i) <='Z'){
                     as = str.charAt(i) - 5;
                }else if (str.charAt(i) == 32){
                    as = 32;
                }
                char ch = (char) as;
                ans.append(ch);
            }
            System.out.println(ans);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //到底买不买-选出子串;
    public static void maiZhuZi(String tanZhu,String maiJia){
        StringBuffer mai = new StringBuffer(maiJia);
        for (int i = 0; i < tanZhu.length(); i++) {
            for (int j = 0; j < mai.length(); j++) {
                if (tanZhu.charAt(i) == mai.charAt(j)){
                    mai.deleteCharAt(j);
                    break;
                }
            }
        }
        if (mai.length() == 0){
            int ans = tanZhu.length()-maiJia.length();
            System.out.println("Yes"+" "+ans);
        }else {
            int ans = mai.length();
            System.out.println("No"+" "+ans);
        }
    }
    public static void oj40(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            maiZhuZi(a,b);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //链式A+B;
    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        int jinWei = 0;
        ListNode head = null;
        ListNode tile = null;
        ListNode node = null;
        while (a != null || b != null) {
            if (a == null){
                //a==null时 b!= null 说明b的长度比a长,只对b进行运算;
                 node = new ListNode((b.val + jinWei)%10);
                if (b.val + jinWei > 9){
                    jinWei = 1;
                }else {
                    jinWei = 0;
                }
                b = b.next;
            }else if (b == null){
                //b==null时 a!= null 说明b的长度比a短,只对a进行运算;
                 node = new ListNode((a.val + jinWei)%10);
                if (a.val + jinWei > 9){
                    jinWei = 1;
                }else {
                    jinWei = 0;
                }
                a = a.next;
            }else {
                //a != null 且 b!=null ,对a和b进行加法运算;
                 node = new ListNode((a.val + b.val + jinWei) % 10);
                if (a.val + b.val + jinWei > 9){
                    jinWei = 1;
                }else {
                    jinWei = 0;
                }
                a = a.next;
                b = b.next;
            }
            //尾插法;
            if (head == null){
                head = tile = node;
            }else {
                tile.next = node;
                tile = tile.next;
            }
        }
        //当进位最后依然为1的时候,需要多加一个节点;
        if (jinWei == 1){
            node = new ListNode((jinWei)%10);
            tile.next = node;
        }
        return head;
    }
    public static void oj41(){
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(0);
        a.next = b;
        b.next = c;
        d.next = e;
        plusAB(a,d);
    }
    //---------------------------------------------------------------------------------------------------
    //判断是否为平衡二叉树;
    public static Boolean isBalance(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        if (Math.abs(treeDeep(root.left)-treeDeep(root.right)) > 1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
    public static int treeDeep(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = treeDeep(root.left);
        int right = treeDeep(root.right);
        return (Math.max(left, right))+1;
    }
    public static void oj42(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(1);
        TreeNode g = new TreeNode(1);
        TreeNode h = new TreeNode(1);
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;
        f.right = b;
        System.out.println(isBalance(a));
    }
    //---------------------------------------------------------------------------------------------------
    //数字分类;
    public static void numFenLei(int[] arr,int n){
        if (A1(arr) == Integer.MIN_VALUE){
            System.out.print("N"+" ");
        }else {
            System.out.print(A1(arr)+" ");
        }
        if (A2(arr) == 0){
            System.out.print("N"+" ");
        }else {
            System.out.print(A2(arr)+" ");
        }
        if (A3(arr) == 0){
            System.out.print("N"+" ");
        }else {
            System.out.print(A3(arr)+" ");
        }
        if (A4(arr) == Integer.MIN_VALUE){
            System.out.print("N"+" ");
        }else {
            System.out.printf("%.1f",A4(arr));
            System.out.print(" ");
        }
        if (A5(arr) == Integer.MIN_VALUE){
            System.out.print("N");
        }else {
            System.out.print(A5(arr));
        }
    }
    public static int A1(int[] arr){
        int sum = 0;
        int n = 0;
        for (int num : arr){
            if (num % 10 == 0){
                sum += num;
                n++;
            }
        }
        if (n > 0) {
            return sum;
        }else {
            return Integer.MIN_VALUE;
        }
    }
    public static int A2(int[] arr){
        int sum = 0;
        boolean change = true;
        for (int value : arr) {
            if (value % 5 == 1) {
                if (change) {
                    sum += value;
                    change = false;
                } else {
                    sum = sum - value;
                    change = true;
                }
            }
        }
        return sum;
    }
    public static int A3(int[] arr){
        int sum = 0;
        for (int num : arr){
            if (num % 5 == 2){
                sum++;
            }
        }
        return sum;
    }
    public static double A4(int[] arr){
        int n = 0;
        int sum = 0;
        double avg;
        for (int num:arr){
            if(num % 5 == 3){
                sum += num;
                n++;
            }
        }
        if(n > 0) {
            avg = (double) sum / (double) n;
            return avg;
        }else {
            return Integer.MIN_VALUE;
        }
    }
    public static int A5(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int num : arr){
            if (num % 5 == 4){
                max = Math.max(max,num);
            }
        }
        return max;
    }
    public static void oj43(){
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            numFenLei(arr,n);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //小易的升级之路;
    public static void stepByStep(int[] arr,int n){
        int power = n;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= power){
                power += arr[i];
            }else {
                int gongYue = power;
                while (arr[i] != gongYue){
                    if (arr[i] > gongYue){
                        arr[i] = arr[i] - gongYue;
                    }else {
                        gongYue = gongYue - arr[i];
                    }
                }
                power = power + gongYue;
            }
        }
        System.out.println(power);
    }
    public static void oj44(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int power = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            stepByStep(arr,power);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //最高分是多少;
    public static void studentSystem(int[] arr,String c,int a,int b){
        if (c.equals("Q")){
            int max = Integer.MIN_VALUE;
            int start ,end;
            //这里有一个坑,A和B之间的最大值,但没有说A一定大于B,也可能是B>A;
            if (a < b){
                start = a-1;
                end = b - 1;
            }else {
                end = a -1;
                start = b-1;
            }
            for (int i = start; i <= end; i++) {
                if (arr[i] > max){
                    max = arr[i];
                }
            }
            System.out.println(max);
        }
        if (c.equals("U")){
            arr[a-1] = b;
        }
    }
    public static void oj45(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr= new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                String c = sc.next();
                int a =sc.nextInt();
                int b =sc.nextInt();
                studentSystem(arr,c,a,b);
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
    //数字之和
    public static void numSum(int n){
        int sum1 = 0;
        int sum2 = 0;
        int n2 = n*n;
        while (n != 0){
            int x = n % 10;
            n = n / 10;
            sum1 += x;
        }
        while (n2 != 0){
            int x = n2 % 10;
            n2 = n2 /10;
            sum2 += x;
        }
        System.out.println(sum1+" "+sum2);
    }
    public static void oj46(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            numSum(n);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //计票统计
    public static class jiPiao {
        Map<String, Integer> map = new HashMap<>();
        //加候选人接口
        public int addCandidate(String name) {
            if (!map.containsKey(name)){
                map.put(name,0);
                return 1;
            }else {
               return 0;
            }
        }
        //投票接口
        public  void vote(String name) {
            if (map.containsKey(name)){
                map.put(name,map.get(name)+1);
            }else {
                map.put("Invalid",map.getOrDefault("Invalid",0)+1);
            }
        }

        //获取结果入口
        public  int getVoteResult(String name) {
            if (map.containsKey(name)){
                return map.get(name);
            }else {
                return map.get("Invalid");
            }
        }
        //清空数据;
        public  void clear() {
            map.clear();
        }
    }
    public static void oj47(){
        Scanner sc = new Scanner(System.in);
        jiPiao jiPiao = new jiPiao();
        while (sc.hasNext()){
            int houXuan = sc.nextInt();
            for (int i = 0; i < houXuan; i++) {
                jiPiao.addCandidate(sc.next());
            }
            int touPiao = sc.nextInt();
            for (int i = 0; i < touPiao; i++) {
                jiPiao.vote(sc.next());
            }
            for (Map.Entry<String, Integer> people : jiPiao.map.entrySet()){
                System.out.println(people.getKey()+" : "+people.getValue());
            }
            jiPiao.clear();
        }
    }
    //---------------------------------------------------------------------------------------------------
    //守形数;
    public static int shouXing(int n){
        int num = n*n;
        if (num > 1000){
            num = num % 1000;
            if (num == n){
                System.out.println("Yes!");
                return 1;
            }
        }else if (num > 100){
            num = num %100;
            if (num == n){
                System.out.println("Yes!");
                return 1;
            }
        }else if (num > 10) {
            num = num % 10;
            if (num == n) {
                System.out.println("Yes!");
                return 1;
            }
        }
        System.out.println("No!");
        return -1;
    }
    public static void oj48(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            shouXing(n);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //密码验证合格程序;
    public static void miMaYanZheng(String miMa){
        if (miMa.length() <= 8 ){
            System.out.println("NG");
            return;
        }
        int num = 0;
        int bigZiMu = 0;
        int smallZiMu = 0;
        int teShu = 0;
        for (int i = 0; i < miMa.length(); i++) {
            char ch = miMa.charAt(i);
            if (ch >= '0' && ch <= '9'){
                num = 1;
            }else
            if (ch >= 'a' && ch <= 'z' ){
                smallZiMu = 1;
            }else
            if (ch >= 'A' && ch <= 'Z' ){
                bigZiMu = 1;
            }else {
                teShu = 1;
            }
        }
        if (num + bigZiMu + smallZiMu + teShu < 3){
            System.out.println("NG");
            return;
        }
        for (int index = 0; index < miMa.length() - 3 ; index++) {
            String str1 = miMa.substring(index, index + 3);
            for (int i = index+3; i < miMa.length()-3; i++) {
                String str2 = miMa.substring(i,i+3);
                if (str1.equals(str2)) {
                    System.out.println("NG");
                    return;
                }
            }
        }
        System.out.println("OK");
    }
    public static void oj49(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String miMa = sc.next();
            miMaYanZheng(miMa);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //年会抽奖
    public static void zhongJiangLv(int n){
        int mu = fenMu(n);
        int zi = fenZi(n);
        double ans =(double) zi / mu * 100;
        System.out.printf("%.2f",ans);
        System.out.print("%");
    }

    public static int fenMu(int n){
        int result = 1;
        if (n == 1)
            return 1;
        else if (n > 1)
            result = n * fenMu(n - 1);
        return result;
    }
    public static int fenZi(int n){
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return (n - 1)*(fenZi(n - 1) + fenZi(n - 2));
    }
    public static void oj50(){
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            zhongJiangLv(n);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //说反话;
    public static void shuoFanHua(String str){
        String[] strings = str.split(" ");
        for (int i = strings.length-1; i >= 0; i--) {
            if (i > 0) {
                System.out.print(strings[i] + " ");
            }else {
                System.out.print(strings[i]);
            }
        }
    }
    public static void oj51(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            shuoFanHua(str);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //简单错误记录
    private static class cuoWuJiLu{
        String name;
        String name16;
        int hangShu;
        int num;
        int index;
    }
    public static void jiLu(String str,int hang,List<cuoWuJiLu> list,int index){
        String[] strings = str.split("\\\\");
        String name = strings[strings.length - 1];
        cuoWuJiLu cuoWuJiLu = new cuoWuJiLu();
        for (cuoWuJiLu node : list) {
            if (node.name.equals(name) && node.hangShu == hang) {
                node.num++;
                return;
            }
        }
        cuoWuJiLu.name = name;
        if (name.length() > 16) {
            cuoWuJiLu.name16 = name.substring(name.length() - 17, name.length() - 1);
        } else {
            cuoWuJiLu.name16 = name;
        }
        cuoWuJiLu.hangShu = hang;
        cuoWuJiLu.num = 1;
        cuoWuJiLu.index = index;
        list.add(cuoWuJiLu);
    }
    public static void oj52(){
        Scanner sc = new Scanner(System.in);
        List<cuoWuJiLu> list = new LinkedList<>();
        int index = 0;
        while (sc.hasNext()){
            String str = sc.next();
            int hang = sc.nextInt();
            index++;
            jiLu(str,hang,list,index);
            list.sort(new Comparator<cuoWuJiLu>() {
                @Override
                public int compare(cuoWuJiLu o1,cuoWuJiLu o2) {
                    if (o1.num == o2.num){
                        return o1.index - o2.index;
                    }else {
                        return o2.num - o1.num;
                    }
                }
            });
            if (list.size() <= 8){
                for (cuoWuJiLu node : list){
                    System.out.println(node.name16 + " " + node.hangShu + " " + node.num);
                }
            }else {
                for (int i = 0; i < 8; i++) {
                    cuoWuJiLu node = list.get(i);
                    System.out.println(node.name16 + " " + node.hangShu + " " + node.num);
                }
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
    //找零钱;
    public static void zhaoLingQian(String p,String a){
        String[] pStrings = p.split("\\.");
        String[] aStrings = a.split("\\.");
        int[] pint = new int[3];
        int[] aint = new int[3];
        long sump = 0;
        long suma = 0;
        for (int i = 0; i < pStrings.length; i++) {
            pint[i] = Integer.parseInt(pStrings[i]);
            if (i == 0) {
                sump += pint[i] * 17 * 19;
            }else if (i == 1){
                sump += pint[i] * 19;
            }else {
                sump += pint[i];
            }
        }
        for (int i = 0; i < aStrings.length; i++) {
            aint[i] = Integer.parseInt(aStrings[i]);
            if (i == 0) {
                suma += aint[i] * 17 * 19;
            }else if (i == 1){
                suma += aint[i] * 19;
            }else {
                suma += aint[i];
            }
        }
        long lingQian = Math.abs(suma - sump);
        long g = 0;
        long s = 0;
        long k = 0;
        g = lingQian / (17 * 19);
        lingQian = lingQian % (17 * 19);
        s = lingQian / 19;
        lingQian = lingQian % 19;
        k = lingQian;
        if (suma < sump){
            System.out.print("-");
        }
        System.out.print(g+"."+s+"."+k);
    }
    public static void oj53(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String p = sc.next();
            String a = sc.next();
            zhaoLingQian(p,a);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //2的个数;
    //超时了!这个方法!
    public static int countNumberOf2s(int n) {
        // write code here
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            String str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '2'){
                    sum++;
                }
            }
        }
        return sum;
    }
    //---------------------------------------------------------------------------------------------------
    //石头剪刀布;
    public static class jiLu{
        int aWin = 0;
        int bWin = 0;
        int ping = 0;
        int a_b= 0;
        int a_c= 0;
        int a_j= 0;
        int b_b= 0;
        int b_c= 0;
        int b_j= 0;
    }
    public static void shiTouJianDaoBu(String a,String b,jiLu node1){
        switch (a){
            case "B" :
                if (b.equals("B")) node1.ping++;
                if (b.equals("C")) {node1.aWin++; node1.a_b++;}
                if (b.equals("J")) {node1.bWin++; node1.b_j++;}
                break;
            case "C" :
                if (b.equals("B")) {node1.bWin++; node1.b_b++;}
                if (b.equals("C")) node1.ping++;
                if (b.equals("J")) {node1.aWin++; node1.a_c++;}
                break;
            case "J" :
                if (b.equals("J")) node1.ping++;
                if (b.equals("C")) {node1.bWin++; node1.b_c++;}
                if (b.equals("B")) {node1.aWin++; node1.a_j++;}
                break;
        }
    }
    public static void oj55(){
        Scanner sc = new Scanner(System.in);
        jiLu node = new jiLu();
        while (sc.hasNext()){
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String a = sc.next();
                String b = sc.next();
                shiTouJianDaoBu(a, b, node);
            }
            System.out.println(node.aWin+" "+ node.ping+" "+node.bWin);
            System.out.println(node.bWin+" "+ node.ping+" "+node.aWin);
            if (node.a_b >= Math.max(node.a_c,node.a_j)){
                System.out.print("B"+" ");
            }else if (node.a_c >= node.a_j){
                System.out.print("C"+" ");
            }else {
                System.out.print("J"+" ");
            }
            if (node.b_b >= Math.max(node.b_c,node.b_j)){
                System.out.print("B");
            }else if (node.b_c >= node.b_j){
                System.out.print("C");
            }else {
                System.out.print("J");
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
    //爬楼梯;
    public static int countWays(int n) {
        int[] dp = {1,1,2};
        if (n == 0) return 0;
        else if (n <= 4) return dp[n - 1];
        for (int i = 4; i < n; i++) {
            int tmp = ((dp[0] + dp[1]) %1000000007 + dp[2]) %1000000007;
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = tmp;
        }
        return dp[2];
    }
    //---------------------------------------------------------------------------------------------------
    //股票利益最大化;
//    public static int calculateMax(int[] prices) {
//
//    }
    //---------------------------------------------------------------------------------------------------
    //组成多边形;
    public static void duoBianXing(List<Integer> list){
        int sum = 0;//存储总长度
        int maxLength = 0;
        if (list.size() <= 2){
            System.out.println("No");
        }else {
            for (int num : list){
                 sum  += num;
                 maxLength = Math.max(num,maxLength);
            }
            if (sum > 2*maxLength) System.out.println("Yes");
            else System.out.println("No");
        }
    }
    public static void oj56(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            List<Integer> list = new LinkedList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int caoZuo = sc.nextInt();
                int length = sc.nextInt();
                if (caoZuo == 1){
                    list.add(length);
                }else {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) == length) {
                            list.remove(j);
                            break;
                        }
                    }
                }
                duoBianXing(list);
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
    //对角打印二维数组;
    public static int[] arrayPrint(int[][] arr, int n) {
        int[] ans = new int[n*n];
        int index = 0;
        for (int i = n-1; i >= 0; i--) {
            int x = i;
            int y = n-1;
            while (x < n && y >= 0) {
                ans[index++] = arr[y--][x++];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            int x = i;
            int y = 0;
            while (x >= 0 && y < n){
                ans[index++] = arr[x--][y++];
            }
        }
        return ans;
    }

    //---------------------------------------------------------------------------------------------------
    //二维数组中寻找数字;
    private static final int[][] erWeiShuZu = {
            {1,2,8,9},
            {2,4,9,12},
            {4,7,10,13},
            {6,8,11,15}
    };
    public static Boolean findNumInErWeiShuZu(int n,int[][] array){
        if (n < array[0][0] && n > array[3][3]){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (n == array[3][i]){
                return true;
            }
            if (n <= array[3][i]){
                for (int j = 0; j < 4; j++) {
                    if (n == array[j][i]){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
    //---------------------------------------------------------------------------------------------------
    //数组奇数排前;
    public static int[] jiShuPaiQian(int[] array){
        int begin = 0;
        int end = array.length-1;
        while (begin < end){
            while (array[begin] % 2 == 1){
                    begin++;
            }
            while (array[end] % 2 == 0){
                    end--;
            }
            if (begin < end) {
                int tmp = array[begin];
                array[begin] = array[end];
                array[end] = tmp;
            }
        }
        return array;
    }
    //---------------------------------------------------------------------------------------------------
    //十进制转二进制,判断有几个数字1
    public static int findNum1(int n){
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    //---------------------------------------------------------------------------------------------------
    //求一个有序数组中，两个值相加为key的数字，返回这两个数字的下标。时间复杂度是O(n)
    public static int[] findSumKey(int[] array,int key){
        int begin = 0;
        int end = array.length - 1;
        int[] ans = new int[2];
        while (begin < end){
            int sum = array[begin] + array[end];
            if (sum > key){
                end--;
            }else if (sum < key){
                begin++;
            }else {
                ans[0] = begin;
                ans[1] = end;
                return ans;
            }
        }
        return ans;
    }
    //---------------------------------------------------------------------------------------------------
    //TopK问题
    public static int[] topKNum(int[] array,int k){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length-1; j++) {
                if (array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1]  = tmp;
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = array[i];
        }
        return ans;
    }
    //---------------------------------------------------------------------------------------------------
    //超出数组中,两个只出现一次的数字;
    public static void findOneTimeNum(int[] array){
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!ans.contains(array[i])){
                ans.add(array[i]);
            }else {
                ans.remove(array[i]);
            }
        }
        System.out.println(ans);
    }
    //---------------------------------------------------------------------------------------------------
    //将数组前k个字符进行旋转;
    //例如"abcdef" k = 2 旋转后为 "cdefab"
    public static void xuanZhuanShuZu(char[] array,int k){
        char[] tmp = new char[k];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < k ){
                tmp[i] = array[i];
            }else {
                array[i - k] = array[i];
                if (i >= array.length - k){
                    array[i] = tmp[index++];
                }
            }
        }
        System.out.println(array);
    }
    //---------------------------------------------------------------------------------------------------
    //字符串逆置;
    public static void strNiZhi(String str){
        char[] tmp = str.toCharArray();
        char[] ans = new char[tmp.length];
        int index = 0;
        for (int i = tmp.length-1; i >=  0; i--) {
            ans[index++] = tmp[i];
        }
        System.out.println(ans);
    }
    //---------------------------------------------------------------------------------------------------
    //字符串压缩 例如"aabbcceef" 压缩为"a2b2c2e2f1"
    public static void yaSuoString(String str){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character,Integer> entry: map.entrySet()){
            ans.append(entry.getKey());
            ans.append(entry.getValue());
        }
        System.out.println(ans);
    }
    //---------------------------------------------------------------------------------------------------
    //字符串转数字,要求不使用库函数;
    public static void stringToNum(String str){
        Map<Character,Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        long ans = 0;
        Boolean fuShu = false;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (str.charAt(0) == '-') {
                    fuShu = true;
                    continue;
                }
            }
            if (!map.containsKey(str.charAt(i))){
                System.out.println(0);
                return;
            }else {
                int num = map.get(str.charAt(i));
                for (int j = 0; j < str.length() - i - 1; j++) {
                    num = num * 10;
                }
                ans += num;
            }
        }
        if (ans > Integer.MAX_VALUE){
            System.out.println(Integer.MAX_VALUE);
        }else if (ans < Integer.MIN_VALUE){
            System.out.println(Integer.MIN_VALUE);
        }
        if (fuShu){
            System.out.println(-ans);
        }else {
            System.out.println(ans);
        }
    }
    //---------------------------------------------------------------------------------------------------
    //判断字符串中数字的个数
    public static void strFindNum(String str){
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                ans++;
            }
        }
        System.out.println(ans);
    }
    //---------------------------------------------------------------------------------------------------
    //如何判断一个数是否是2的k次方？这里不需要确定k的值。
    public static Boolean is2DeCiFang(int n){
        while (n > 0) {
            if (n % 2 != 0) {
                return false;
            } else {
                n /= 2;
                if (n == 1){
                    return true;
                }
            }
        }
        return true;
    }
    //---------------------------------------------------------------------------------------------------
    //尼科彻斯定理
    public static void niKeCheSi(int m){
        int first = m * m - 2 * (m/2);
        if (m % 2 == 0){
            first++;
        }
        for (int i = 0; i < m; i++) {
            System.out.println(first);
            first += 2;
        }
    }
    //---------------------------------------------------------------------------------------------------
    //删除链表的第K个节点
    public static class Node{
        int key;
        Node next;
    }
    public static Node removeKthNode(Node head, int k) {
        Node cur = head;
        Node end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }
        while (end.next != null){
            cur = cur.next;
            end = end.next;
        }
        cur.next = cur.next.next;
        return head;
    }
    public static void testRemoveKthNode(){
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        a.key = 1;
        b.key = 2;
        c.key = 3;
        d.key = 4;
        e.key = 5;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        removeKthNode(a,2);
    }
    public static void main(String[] args) {

    }
}

