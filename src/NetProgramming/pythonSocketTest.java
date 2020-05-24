package NetProgramming;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.net.Socket;
import java.net.UnknownHostException;


public class pythonSocketTest {

    public static void main(String args[]) throws Exception {

        try {
            Socket socket = new Socket("127.0.0.1", 50006);

            //获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
            pw.write("imjava server ");
            pw.flush();
            socket.shutdownOutput();//关闭输出流

            InputStream is = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = in.readLine()) != null) {
                System.out.println("i'm client，Python server say：" + info);
            }
            is.close();
            in.close();
            socket.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}