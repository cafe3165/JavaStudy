package J2SE.proxy;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class Cinema implements Movie {
    RealMovie realMovie;

    public Cinema(RealMovie realMovie) {
        super();
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        advertise();
        realMovie.play();
        advertise();


    }

    private void advertise() {
        System.out.println("advertise");
    }
}

