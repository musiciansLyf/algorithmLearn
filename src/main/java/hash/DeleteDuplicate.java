package hash;

import java.util.*;

/**
 * @ClassName liyufeng
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/31 8:33
 * @Version 1.0
 **/
public class DeleteDuplicate {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "123");
        map.put("2", "djw");
        map.put("3", "djw");
        map.put("4", "123");
        map.put("5", "djw");
        System.out.println(byHashMap(map));
        System.out.println(bySet(map));
    }

    //使用hashMap过滤
    public static Map<String,String> byHashMap(Map<String,String> map){
        if(map==null||map.size()==0){
            return new HashMap<String, String>();
        }
        Map<String ,String> relMap=new HashMap<String, String>();
        //遍历Map内的每个键值对，并使用一个新的Map根据值是否重复进行保存
        for(Iterator<Map.Entry<String ,String>> iterator=map.entrySet().iterator();iterator.hasNext();){
            Map.Entry<String ,String> entry=iterator.next();
            if(relMap.containsValue(entry.getValue())){
                continue;
            }else {
                relMap.put(entry.getKey(),entry.getValue());
            }
        }
        return relMap;
    }

    //使用Set过滤
    public static Set<String> bySet(Map<String,String> map){
        if(map==null||map.size()==0){
            return new HashSet<String>();
        }
        Set<String> relSet=new HashSet<String>();
        //遍历Map内的每个键值对，并使用一个Set根据值是否重复进行保存
        for(Iterator<Map.Entry<String ,String>> iterator=map.entrySet().iterator();iterator.hasNext();){
            Map.Entry<String,String> entry=iterator.next();
            if (relSet.contains(entry.getValue())){
                continue;
            }else {
                relSet.add(entry.getValue());
            }
        }
        return relSet;
    }

}
