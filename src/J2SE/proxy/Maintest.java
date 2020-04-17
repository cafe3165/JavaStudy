package J2SE.proxy;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class Maintest {
    public static void main(String[] args) {
        Movie movie=new Cinema(new RealMovie());
        movie.play();
    }
}
