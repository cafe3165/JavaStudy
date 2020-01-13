package designPattern.Composite;

/**
 * Author:cafe3165
 * Date:2020-01-13
 */

public abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void Add(Company company);

    public abstract void Remove(Company company);

    public abstract void Display(int depth);

    public abstract void LineOfDuty();



}
