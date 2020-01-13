package designPattern.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-01-13
 */
public class ConcreteCompany extends Company {
    private List<Company> children = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void Add(Company company) {
        children.add(company);

    }

    @Override
    public void Remove(Company company) {
        children.remove(company);
    }

    @Override
    public void Display(int depth) {
        System.out.println(printHyphen(depth) + name);
        for (Company component :
                children) {
            component.Display(depth + 2);
        }
    }

    @Override
    public void LineOfDuty() {
        for (Company component :
                children) {
            component.LineOfDuty();
        }
    }

    private String printHyphen(int depth) {
        StringBuffer sb = new StringBuffer("");
        while (depth > 0) {
            sb.append('-');
            depth--;
        }
        return sb.toString();
    }
}
