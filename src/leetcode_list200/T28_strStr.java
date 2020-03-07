package leetcode_list200;

public class T28_strStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int k = i;

            for (int j = 0; j < needle.length(); j++) {
                if (k > haystack.length() - 1 || haystack.charAt(k) != needle.charAt(j)) {
                    break;
                }
                k++;
                if (j == needle.length() - 1) {
                    return i;
                }

            }

        }


        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        for (int i = 0; i < l1 - l2 + 1; i++) {
            int j = 0;
            for (; j < l2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == l2) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        T28_strStr t = new T28_strStr();
        String haystack = "mississippi", needle = "issipi";
//     双指针
        t.strStr(haystack, needle);

    }
}
