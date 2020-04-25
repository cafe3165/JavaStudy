package J2SE.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-04-18
 */
public class SoftReferenceTest {
    static class HeapObject {
        byte[] bs = new byte[4096 * 4096];

        public static void main(String[] args) {
            SoftReference<HeapObject> softReference = new SoftReference<>(new HeapObject());
            ReferenceQueue<HeapObject> queue = new ReferenceQueue<>();

            List<HeapObject> list = new ArrayList<>();

            while (true) {
                if (softReference.get() != null) {
                    list.add(new HeapObject());
                    System.out.println("list.add");
                } else {
                    System.out.println("---------软引用已被回收---------");
                    break;
                }
                System.gc();
            }
            Reference<? extends HeapObject> pollRef = queue.poll();
            System.out.println("6666");
            while (pollRef != null) {
                System.out.println(pollRef);
                System.out.println(pollRef.get());
                pollRef = queue.poll();
            }

        }

    }
}
