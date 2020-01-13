package designPattern.Composite;

/**
 * Author:cafe3165
 * Date:2020-01-13
 */
public class FinanceDepartment extends Company {
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void Add(Company company) {

    }

    @Override
    public void Remove(Company company) {

    }

    @Override
    public void Display(int depth) {
        System.out.println(printHyphen(depth) + name);

    }

    @Override
    public void LineOfDuty() {
        System.out.println("财务" + name);

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
