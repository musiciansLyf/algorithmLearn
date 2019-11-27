package array;

import java.util.Scanner;

/**
 * @ClassName liyufeng
 * @Description TODO
 * @Author Administrator
 * @Date 2019/5/27 15:31
 * @Version 1.0
 **/
public class RotateArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入数组长度
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N;i++) {
            //输入一个递增排序的数组（元素不重复）的一个旋转（次数不详），空格分隔，回车结束
            arr[i] = in.nextInt();
        }
        //查找的target
        int k = in.nextInt();
        System.out.println(findOne(arr,k));
    }

    public static int findOne(int[] array,int target){
        int start=0;
        int end=array.length-1;
        //取得最小值索引
        int min=getMin(array);
        //target在左侧有序数组
        if (target>=array[start]){
            //检索结束值为，最小值索引减一
            int endIndex=min-1;
            return binarySearch(array,target,start,endIndex);
        }else {
            //target在右侧有序数组
            int startIndex=min;
            return binarySearch(array,target,startIndex,end);
        }
    }

    //查找最小值
    public static int getMin(int[] array){
        int start=0;
        int end=array.length-1;
        //数组没有旋转的特殊情况
        if(array[start]<array[end]){
            return array[start];
        }
        //因为旋转过，当剩两个数时，最小值肯定是后一个，所以不必比较start+1
        while (start+1<end){
            //通过二分法查找最小值
            int mid=(start+end)/2;
            //当中间值大于开始值时，左侧有序，最小值在右侧
            if(array[mid]>array[start]){
                start=mid;
            }
            //当中间值需要结束值时，右侧有序，最小值在左侧
            if (array[mid]<array[end]){
                end=mid;
            }
        }
        //最小值肯定在end处
        return end;

    }

    //二分查找法
    public static int binarySearch(int[] array,int target,int start,int end){
        //查找数组的起始索引
        int low=start;
        //查找数组的结束索引
        int high=end;
        //当target在low边界处时为=号
        while (low<=high){
            int mid=(low+high)/2;
            //找到target
            if(array[mid]==target){
                return array[mid];
            }
            //target大于中间值，在右侧，low为中间值加一
            if(array[mid]<target){
                low=mid+1;
            }else {
                //target小于中间值，在左侧，high为中间值减一
                high=mid-1;
            }
        }
        return -1;
    }

}
