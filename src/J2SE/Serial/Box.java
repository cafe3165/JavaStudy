package J2SE.Serial;

import lombok.Data;

import java.io.*;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
@Data
public class Box implements Serializable {
    private static final long serialVersionUID = -2020468202497272523L;
    private int width;
    private int height;

    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.setWidth(50);
        myBox.setHeight(30);
        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myBox);
            os.close();
            FileInputStream fi = new FileInputStream("foo.ser");
            ObjectInputStream oi = new ObjectInputStream(fi);
            Box box = (Box) oi.readObject();
            oi.close();
            System.out.println(box.height + "," + box.width);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
