package J2SE.proxy.proxytest;

/**
 * Author:cafe3165
 * Date:2020-04-03
 */
public class cgProxyMain {
    public static void main(String[] args) {
        CglibProxy cglibProxy=new CglibProxy();
        PlayGame playGame= (PlayGame) cglibProxy.newInstall(new PlayGame());
        playGame.play();
    }
}
