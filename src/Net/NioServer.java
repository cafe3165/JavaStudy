package Net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.*;

import com.google.common.util.concurrent.ThreadFactoryBuilder;


/**
 * Author:cafe3165
 * Date:2020-03-24
 */
public class NioServer {
    private int port;
    private Selector selector;

    //    private ExecutorService service = Executors.newFixedThreadPool(5);
//    private ExecutorService service = new ThreadPoolExecutor(1, 4, 300, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());
    private ExecutorService service = new ThreadPoolExecutor(1, 4, 300, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());

    public NioServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new NioServer(8080).start();
    }

    public void init() {
        ServerSocketChannel ssc = null;
        try {
//            打开socket通道
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
//            绑定端口
            ssc.bind(new InetSocketAddress(port));
            selector = Selector.open();
//            将通道注册到选择器
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("NioServer started ......");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void accept(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_READ);
            System.out.println("accept a client : " + sc.socket().getInetAddress().getHostName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {
        this.init();
        while (true) {
            try {
                int events = selector.select();
                System.out.println(events);
                if (events > 0) {
                    Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                    while (selectionKeys.hasNext()) {
                        SelectionKey key = selectionKeys.next();
                        selectionKeys.remove();
                        if (key.isAcceptable()) {
                            /** 从SelectionKey获取对应通道ServerSocketChannel**/
                            accept(key);
                        } else {
                            System.out.println("submit");
                            service.submit(new NioServerHandler(key));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class NioServerHandler implements Runnable {
        private SelectionKey selectionKey;

        public NioServerHandler(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }


        @Override
        public void run() {
            try {
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    buffer.flip();
//                  也就是说调用flip之后，读写指针指到缓存头部，
//                  并且设置了最多只能读出之前写入的数据长度(而不是整个缓存的容量大小)。
                    System.out.println("收到客户端" + socketChannel.socket().getInetAddress().getHostName() + "的数据：" + new String(buffer.array()));
                    //将数据添加到key中
                    ByteBuffer outBuffer = ByteBuffer.wrap(buffer.array());
                    socketChannel.write(outBuffer);// 将消息回送给客户端
                    selectionKey.cancel();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
