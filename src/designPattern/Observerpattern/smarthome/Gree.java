package designPattern.Observerpattern.smarthome;

/**
 * Author:cafe3165
 * Date:2020-05-03
 */
public class Gree extends UDevice {
    Double temperature;

    public Gree(VDevice vAircon, Double temperature) {
        this.temperature = temperature;
        this.vAircon = vAircon;
        this.vAircon.attach(this);
    }

    @Override
    public void update(Double attribute) {
        warm(attribute);
    }

    private void warm(Double attribute) {
        this.temperature = attribute;
        System.out.println(this.temperature);
    }

}
