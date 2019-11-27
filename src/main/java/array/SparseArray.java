package array;

/**
 * @ClassName liyufeng
 * @Description 稀疏数组实现保存五子棋盘，简化内存
 * @Author Administrator
 * @Date 2019/6/1 21:41        if(false){
 * //            System.out.println("1");
 * //        }else if(true){
 * //            System.out.println("2");
 * //        }else if(true){
 * //            System.out.println("3");
 * //        }else{
 * //            System.out.println("4");
 * //        }
 * @Version 1.0
 **/
public class SparseArray {
    public static void main(String[] args) {

//

        SparseArray sa=new SparseArray();
        //创建一个11乘11的五子棋盘，黑子为1，白子为2，默认为0
        int[][] chessArr=new int[11][11];
        //下两个字
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("原数组：");
        sa.print(chessArr);
        //稀疏数组
        int[][] sparseArray = sa.getSparse(chessArr);
        System.out.println("稀疏数组：");
        sa.print(sparseArray);
        System.out.println("从稀疏数组获得的原数组：");
        sa.print(sa.getOldArray(sparseArray));
    }

    //获得稀疏数组
    public int[][] getSparse(int[][] array){
        //记录值的个数
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                //当数组值不等于默认值时
                if (array[i][j] != 0){
                    sum++;
                }
            }
        }
        //行为值的个数加一，列固定为三行
        int[][] sparseArray = new int[sum+1][3];
        //为稀疏数组第一行赋值，为行数，列数，值的个数
        sparseArray[0][0] = array.length;
        //保存的二维数组为方形结构
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;
        //在次for循环遍历，获取值及其位置
        //一个值需要一行进行保存，需要一个递增的行计数器
        int rowCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0){
                    rowCount++;
                    sparseArray[rowCount][0] = i;
                    sparseArray[rowCount][1] = j;
                    sparseArray[rowCount][2] = array[i][j];
                }
            }
        }
        return sparseArray;
    }

    //使用稀疏数组获得原数组
    public int[][] getOldArray(int[][] sparseArray){
        //稀疏数组第一行保存有原数组行数和列数，初始化原数组
        int[][] oldArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        //遍历后面几行，为原数组赋值
        for (int i = 1; i < sparseArray.length; i++) {
            //稀疏数组后面几行，保存的内容固定为行，列，值
            oldArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return oldArray;
    }

    public void print(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
