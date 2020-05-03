package designPattern.Observerpattern.smarthome;

/**
 * Author:cafe3165
 * Date:2020-05-03
 */
public interface VDevice {
    void notifyAllUDevice();
    void attach(UDevice uDevice);
    void setAttribute(Double attribute);
    Double getAttribute();
    void IncreaseAttribute();
}
