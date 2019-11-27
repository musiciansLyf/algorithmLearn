package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName liyufeng
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/31 9:29
 * @Version 1.0
 **/
public class Frequency {
    public static void main(String[] args) {
        String str = "真真真真真slkg在jfsjsht中j中ghr中国lsh你izx你lf在hfnaj产产产科";
        System.out.println(getFrequency(str));
    }

    public  static Map<Character,Integer> getFrequency(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char[] chars=str.toCharArray();
        //建立键值对map，存储每个字符及其次数
        HashMap<Character,Integer> relHash=new HashMap<Character, Integer>();
        for(int i=0;i<chars.length;i++){
            //下面使用基本类型int 会报空指针异常
            Integer count=relHash.get(chars[i]);
            //判断map里是有该字符，没有就加入map，有取该次数的值加一，再次保存
            if (relHash.get(chars[i])==null){
                relHash.put(chars[i],1);
            }else {
                count++;
                relHash.put(chars[i],count);
            }
        }
        return relHash;
    }
}
