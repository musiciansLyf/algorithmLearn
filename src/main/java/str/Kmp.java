package str;

import java.util.Scanner;

/**
 * @ClassName liyufeng
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/29 22:40
 * @Version 1.0
 **/
//KMP算法要解决的问题就是在字符串（也叫主串）中的模式（pattern）定位问题。说简单点就是我们平时常说的关键字搜索。
// 模式串就是关键字（接下来称它为P），如果它在一个主串（接下来称为T）中出现，就返回它的具体位置，否则返回-1（常用手段）
public class Kmp {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String tStr=in.next();
        String pStr=in.next();
        System.out.println("主串为："+tStr);
        System.out.println("模式串："+pStr);
        System.out.println("位置："+KMP(tStr,pStr));
    }

    public static int KMP(String tStr,String pStr){
        char[] t=tStr.toCharArray();
        char[] p=pStr.toCharArray();
        //主串中的位置
        int i=0;
        //模式串中的位置
        int j=0;
        //保存模式串每一个位置j对应的k的数组
        int next[]=getNext(pStr);
        //j==p.length为查找到位置，i==t.length时，为没有找到位置
        while (i<t.length&&j<p.length){
            //j==-1,为第一个元素判断不匹配，元素后移
            if(j==-1||t[i]==p[j]){
                i++;
                j++;
            }else {
                //遇到不匹配元素，j换为该元素对应的k值位置，i不回溯
                j=next[j];
            }
        }
        if(j==p.length){
            //i-j为模式串出现的位置
            return i-j;
        }else {
            return -1;
        }
    }

    public  static int[] getNext(String pStr){
        char[] p=pStr.toCharArray();
        int[] next=new int[p.length];
        //初始化第一个元素的k值，为-1
        next[0]=-1;
        int j=0;
        //设置初值为-1，判断需要使用它为前几个元素赋值
        int k=-1;
        //不需要下标值j==p.length-1,内部前置++实现，会为最后一个元素赋值
        while (j<p.length-1){
            //k==-1为前几个元素使用，p[j]=p[k]为后几个元素判断是否相等，相等则直接进入
            if(k==-1||p[j]==p[k]){
                //当（j后）后面一个元素与（k后）前面的一个元素相等时跳过,避免无效操作
                if(p[++j]==p[++k]){
                    //使用上一次j保存的k值
                    next[j]=next[k];
                }else {
                    //p[++j]==p[++k]不相等时，再次加一，即p[j]==p[k]时，有next[j+1]=next[j]+1
                    next[j]=k;
                }
            }else {
                //p[j]=p[k]不相等时，k跳转到，前前k个字符串最后一个next[]中最后的取值，即next[k]
                k=next[k];
            }
        }
        return next;
    }
}
