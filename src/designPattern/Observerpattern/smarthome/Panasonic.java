package designPattern.Observerpattern.smarthome;

/**
 * Author:cafe3165
 * Date:2020-05-03
 */
public class Panasonic extends UDevice {
    Double temperature;

    public Panasonic(VDevice vAircon, Double temperature) {
        this.temperature = temperature;
        this.vAircon = vAircon;
        this.vAircon.attach(this);
    }

    @Override
    public void update(Double attribute) {
        up(attribute);
    }

    private void up(Double attribute) {
        this.temperature = attribute;
        System.out.println(this.temperature);
    }


}
