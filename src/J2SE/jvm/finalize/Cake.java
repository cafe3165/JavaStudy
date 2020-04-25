package J2SE.jvm.finalize;

import lombok.Data;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
@Data
public class Cake {
    private int id;


    public Cake(int id) {
        System.out.println(id + " created");
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
//        String p = "555";
        System.out.println(id + " disposed");

    }


}
