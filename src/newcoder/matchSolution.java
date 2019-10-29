package newcoder;


public class matchSolution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0, patIndex = 0;
        if(str == null && pattern == null){
            return true;
        }

        return matchCore(str, pattern, strIndex, patIndex);

    }

    private boolean matchCore(char[] str, char[] pattern, int strIndex, int patIndex) {

        if (strIndex == str.length && patIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patIndex == pattern.length) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位

        if (strIndex + 1 < str.length && pattern[patIndex + 1] == '*') {
            if (strIndex != str.length && str[strIndex] == pattern[patIndex] || strIndex != str.length && pattern[patIndex] == '.') {
                return matchCore(str, pattern, strIndex, patIndex + 2) ||
                        matchCore(str, pattern, strIndex + 1, patIndex + 2) ||
                        matchCore(str, pattern, strIndex + 1, patIndex);
            } else {
                return matchCore(str, pattern, strIndex, patIndex + 2);
            }
           /* 1、模式后移2字符，相当于x * 被忽略；
            2、字符串后移1字符，模式后移2字符；
            3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为 * 可以匹配多位；*/
        }
        if ((strIndex != str.length && pattern[patIndex] == str[strIndex]) || (pattern[patIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, pattern, strIndex + 1, patIndex + 1);
        }
        return false;

    }


    public static void main(String[] args) {
        char c = '\0';
        char[] str = {c};
        char[] pattern = {'.', '*'};

        matchSolution m = new matchSolution();
        System.out.println(m.match(str, pattern));

    }

}
