package other;

import lombok.Data;

import java.util.Objects;

/**
 * Author:cafe3165
 * Date:2020-06-15
 */
@Data
public class Person {
    public Person(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    private int id;
    private String name;
    private String sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
