package MoPo_InterviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class practice {
    //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    //输入：n = 3
    //输出：[
    //       "((()))",
    //       "(()())",
    //       "(())()",
    //       "()(())",
    //       "()()()"
    //     ]
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans,0,0,n,new StringBuffer());
        return ans;
    }
    //回溯法;
    public static void backTrack(List<String> ans,int left,int right,int max,StringBuffer str){
        if (str.length() == 2*max){
            ans.add(str.toString());
            return;
        }
        if (left < max){
            //加(括号
            str.append('(');
            backTrack(ans,left+1,right,max,str);
            //这里又删去加的(,为了继续向下运行,加);
            str.deleteCharAt(str.length()-1);
        }
        if (right < left){
            str.append(')');
            backTrack(ans,left,right+1,max,str);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
