package card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName liyufeng
        * @Description TODO
        * @Author Administrator
        * @Date 2019/5/28 16:30
        * @Version 1.0
        **/
public class Card {
    /*
     *题目: 一副从1到n的牌，每次从牌堆顶取一张放桌子上，再取一张放牌堆底，直到手中没牌，
     *最后桌子上的牌是从1到n有序，设计程序，输入n，输出牌堆的顺序数组
     *
     *解题思路:
     *取一个1～n的数组，这里为了说明取n=5。按照题目中的规则变换，得到数组：[1 3 5 4 2]，
     *将该数组下标与值互换得到[1 5 2 4 3]，即为答案。解释：[1 3 5 4 2]的意义是，经过变换，
     *原数组中3号位置的数字现在2号槽，原数组中5号位置的数字现在3号槽... 现在已知变换后的
     *槽存放的是1～n，故只要将下标与值互换就可得到待求数组。
     */

    /*
     * 先默认初始牌堆为1-n,按规则法则。
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        findSerial(n);
    }


    private static void printRes(int[] res) {
        for(int result : res){
            System.out.print(result+" ");
        }
    }

    public static void findSerial(int n){
        HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
        int[] array=getOneChang(n);
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        //该数组的每个数的下标加一对应另一个数组的该值为下标的值
        for (int i = 0; i <array.length ; i++) {
            //Key为数组的值，值为下标加一
            hashMap.put(array[i],i+1);
        }
        //使用for循环，从1开始，即改变一次的数组第一个元素，递增获取该元素的下标加一的值，并顺序赋给数组
        for (int i = 0; i <array.length ; i++) {
            array[i]=hashMap.get(i+1);
        }
        printRes(array);
    }



    public static int[] getOneChang(int n){//给定个数，每次取第一个，第二个放置最底
        ArrayList<Integer> list=new ArrayList<Integer>();
        int[] array=new int[n];
        int index=0;
        //添加递增序列
        for (int i = 0; i <n ; i++) {
            list.add(i+1);
        }
        while (list.size()>0){
            //每次取list第一个数
            array[index]=list.get(0);
            //递增索引
            index++;
            //从list中移出第一个数
            list.remove(0);
            //每次移出进行判断是否是最后一个
            if(list.size()==0){
                break;
            }
            //将list第一个，即原第二个添加至最后一个
            list.add(list.get(0));
            //再次将第一个，即原第二个移出
            list.remove(0);
        }
        return array;
    }
}

