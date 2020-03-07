package J2SE;

import java.util.Comparator;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */


//在外部实现comparator接口，构建自己的排序实现类，指定排序依据
public class StudentSortWithName implements Comparator<Student2> { /* (non Javadoc)
 * @Title: compare
 * @Description: 实现Comparator的compare（）方法，定义name为排序依据
 * @param o1
 * @param o2
 * @return
 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
 */
    @Override
    public int compare(Student2 o1, Student2 o2) {
        System.out.println(o1.getName().compareTo(o2.getName()));
        return o1.getName().compareTo(o2.getName());
    }

}