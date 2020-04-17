package J2SE.proxy;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class RealMovie implements Movie{


    @Override
    public void play() {
        System.out.println("您正在观赏电影");
    }
}
