package newcoder;

public class AddSolution {
    public int Add(int num1, int num2) {
        int sum = 0;
//        相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111=010
//        计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
//        重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
//        继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
        int carry = (num1 & num2 )<< 1;
        sum = num1 ^ num2;
//        System.out.println(carry+" "+sum);
        while (carry != 0) {
            int tmp=sum;
            sum ^= carry;
            carry=(tmp&carry)<<1;
//            System.out.println(carry+" "+sum);

        }
//        System.out.println(sum);

        return sum;
    }

    public static void main(String[] args) {
        int num1 = 5, num2 = 7;
        AddSolution a = new AddSolution();
        a.Add(num1, num2);
    }
}
