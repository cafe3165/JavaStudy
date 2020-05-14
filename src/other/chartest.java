package other;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Author:cafe3165
 * Date:2020-05-03
 */
public class chartest {
    public static void main(String[] args)  throws UnsupportedEncodingException {
        char c = 'a';
        char c1 = '中';
        String str = "a";
        String str1 = "中";
        String str2 = "A";

        System.out.println("编码为UTF8：");
        System.out.println("char值为英文字符所占字节长度：" + getBytesUTF8(c).length);
        System.out.println("char值为中文字符所占字节长度：" + getBytesUTF8(c1).length);

        System.out.println("编码为GBK：");
        System.out.println("char值为英文字符所占字节长度：" + getBytesGBK(c).length);
        System.out.println("char值为中文字符所占字节长度：" + getBytesGBK(c1).length);

        System.out.println("编码为UTF8：");
        System.out.println("String值为英文字符所占字节长度：" + str.getBytes("utf-8").length);
        System.out.println("String值为中文字符所占字节长度：" + str1.getBytes("utf-8").length);

        System.out.println("编码为GBK：");
        System.out.println("String值为英文字符所占字节长度：" + str.getBytes("GBK").length);
        System.out.println("String值为中文字符所占字节长度：" + str1.getBytes("GBK").length);

        //这块str2好像不是全角的，全角占两个字节
        System.out.println("String值为英文字母(全角)所占字节长度：" + str2.getBytes("GBK").length);
    }

    public static byte[] getBytesUTF8(char c) {
        Charset charset = Charset.forName("utf-8");
        CharBuffer allocate = CharBuffer.allocate(1);
        allocate.put(c);
        allocate.flip();
        ByteBuffer encode = charset.encode(allocate);
        return encode.array();
    }

    public static byte[] getBytesGBK(char c) {
        Charset charset = Charset.forName("GBK");
        CharBuffer allocate = CharBuffer.allocate(1);
        allocate.put(c);
        allocate.flip();
        ByteBuffer encode = charset.encode(allocate);
        return encode.array();
    }

}

