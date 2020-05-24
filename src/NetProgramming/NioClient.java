package NetProgramming;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Author:cafe3165
 * Date:2020-03-24
 */
public class NioClient {
    private static final String host = "127.0.0.1";
    private static final int port = 8080;
    private Selector selector;

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 300, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("Thread-Pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 3; i++) {
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    NioClient client = new NioClient();
                    client.connect(host, port);
                    client.listen();
                }
            };
            es.submit(runnable);

        }
    }

    public void connect(String host, int port) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(false);
            this.selector = Selector.open();
            sc.register(selector, SelectionKey.OP_CONNECT);
            sc.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        while (true) {
            try {
                int events = selector.select();
                if (events > 0) {
                    Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                    while (selectionKeys.hasNext()) {
                        SelectionKey selectionKey = selectionKeys.next();
                        selectionKeys.remove();
                        //连接事件
                        if (selectionKey.isConnectable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            if (socketChannel.isConnectionPending()) {
                                socketChannel.finishConnect();
                            }

                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            socketChannel.write(ByteBuffer.wrap(("Hello this is " + Thread.currentThread().getName()).getBytes()));
                        } else if (selectionKey.isReadable()) {
                            SocketChannel sc = (SocketChannel) selectionKey.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            sc.read(buffer);
                            buffer.flip();
                            System.out.println("收到服务端的数据：" + new String(buffer.array()));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}