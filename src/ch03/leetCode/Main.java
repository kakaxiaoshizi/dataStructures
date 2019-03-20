package ch03.leetCode;

public class Main {

    public static void main(String[] args) {

        String[] str = {"()", "([)]", "({[]})"};
        for(String s : str){
            boolean match = Solution.isValid(s);
            System.out.println(match);
        }
    }
}
