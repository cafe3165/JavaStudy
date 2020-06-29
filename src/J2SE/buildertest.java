package J2SE;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class buildertest {
    private int num;
    private int id;
    private String name;

    public static void main(String[] args) {
        buildertest b=buildertest.builder().id(1).name("cafe").build();
        System.out.println(b.getNum());

    }
}
