package Net;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Author:cafe3165
 * Date:2020-03-28
 */
public class TCPTest2 {

    //客户端

    public void fileclient(){

        InetAddress inet = null;
        File file = new File("./src/IOTest/FileTest/hello.txt");
        try {
            inet = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try(Socket socket = new Socket(inet,8899);
            OutputStream os = socket.getOutputStream();
            FileInputStream fis = new FileInputStream(file);

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());

//            InputStreamReader isr = new InputStreamReader(fis,"utf-8")
        ){

            byte[] bytes = new byte[2048];
//            char[] chars = new char[64];
            int len;
            while((len = fis.read(bytes)) != -1){
                os.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void fileserver(){

        File file = new File("./src/WebTest/hello.txt");
        try(ServerSocket ss = new ServerSocket(8899);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream(file)){

            byte[] bytes = new byte[2048];
            int len;
            while ((len = is.read(bytes)) != -1){
                fos.write(bytes);
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
