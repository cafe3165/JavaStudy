package J2SE;

import java.util.Comparator;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */


//在外部实现comparator接口，构建自己的排序实现类，指定排序依据
public class StudentSortWithAge implements Comparator<Student2> { /* (non Javadoc)
 * @Title: compare
 * @Description: 实现Comparator的compare（）方法，定义age为排序依据,
 * @param o1
 * @param o2
 * @return * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
 */
    @Override
    public int compare(Student2 o1, Student2 o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }

}