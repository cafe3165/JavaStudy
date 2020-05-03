package designPattern.Observerpattern.smarthome;

/**
 * Author:cafe3165
 * Date:2020-05-03
 */
public class DeviceDemo {
    public static void main(String[] args) {
        VDevice vAircon = new VAircon();
        vAircon.setAttribute(20.0);
        UDevice gree = new Gree(vAircon, 10.0);
        UDevice panasonic = new Panasonic(vAircon, 25.0);
        vAircon.IncreaseAttribute();

    }
}
