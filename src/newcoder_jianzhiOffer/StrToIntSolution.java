package newcoder_jianzhiOffer;

public class StrToIntSolution {
    public int StrToInt(String str) {
        long num = 0, carry = 10;
        char[] chars = str.toCharArray();
        if (str.length() == 0) return 0;
        char[] nums = new char[str.length()];
        int index = 0;
        for (char c : chars) {
            if (c - '0' > 48 || (c - '0' < 0 && (c != '+' && c != '-')))
                return 0;
            else {
                nums[index++] = c;
            }
        }

        if (nums[0] == '-') {
            for (int i = 1; i < index; i++) {
                num -= nums[i]-'0';
                if(i==index-1)
                    continue;
                num *= carry;
            }
//            num *= -1;
        } else {
            int i;
            if(nums[0] == '+')
                i = 1;
            else
                i=0;
            for (; i < index; i++) {


                num += nums[i]-'0';
                if(i==index-1)
                    continue;
                num *= carry;
            }
        }

        System.out.println(num);
        if(num==-2147483649L||num==2147483648L)
            return 0;
        return (int)num;

    }

    public static void main(String[] args) {
        String str1 = "2147483648", str2 = "1a33";

        StrToIntSolution s = new StrToIntSolution();
        s.StrToInt(str1);
    }
}
