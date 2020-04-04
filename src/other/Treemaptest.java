package other;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */
//可以扩展到从文件中或者从控制台输入单词，来统计，只需要加入流就行了
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Treemaptest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String text="Hello,Good morning.Have a good day!"+"oh,Thank you.Have a good visit!";
        TreeMap<String,Integer> treemap=new TreeMap<String,Integer>();
        String[] str=text.split("[,.! ]");
        for(int i=0;i<str.length;i++){
            String key=str[i].toLowerCase();
            if(key.length()>0){
                if(!treemap.containsKey(key)){
                    treemap.put(key, 1);//如果map里面没有，就放入
                }
                else{


                    treemap.put(key, treemap.get(key).intValue()+1); // 如果有此单词，值加1
                }
            }
        }
        Set<Map.Entry<String, Integer>> set=treemap.entrySet();//返回treemap里的条目规则集
        for(Map.Entry<String, Integer> e:set){
            System.out.println(e.getKey()+"\t"+e.getValue());
        }
        List<Map.Entry<String, Integer>> list= new ArrayList<Map.Entry<String, Integer>>(treemap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> e: list) {
            System.out.println(e.getKey()+" "+e.getValue());
        }


    }
}