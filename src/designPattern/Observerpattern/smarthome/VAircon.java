package designPattern.Observerpattern.smarthome;



import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-05-03
 */
public class VAircon implements VDevice{
    private List<UDevice> uDevices = new ArrayList<>();
    //虚拟对象属性
    Double Attribute;

    //getter setter...
    @Override
    public void setAttribute(Double attribute) {
        this.Attribute = attribute;
    }
    @Override
    public Double getAttribute() {
        return Attribute;
    }

    //关键方法，升高虚拟设备某属性值并通相关设备
    @Override
    public void IncreaseAttribute() {
        Attribute += 1.0;
        notifyAllUDevice();
    }

    //添加相关设备
    @Override
    public void attach(UDevice uDevice) {
        uDevices.add(uDevice);
    }

    //通知
    @Override
    public void notifyAllUDevice() {
        for (UDevice uDevice : uDevices) {
            uDevice.update(Attribute);
        }
    }
}
