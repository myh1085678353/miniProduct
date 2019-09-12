package hmz;

import org.junit.Test;




public class 常见的排序算法 {
//冒泡排序法
//    a、冒泡排序，是通过每一次遍历获取最大/最小值
//　　b、将最大值/最小值放在尾部/头部
//　　c、然后除开最大值/最小值，剩下的数据在进行遍历获取最大/最小值
//　　d、代码实现
    @Test
    public void maopao(){
        int []arr = {1,5,6,2,8,7};
        int t;
        int j;
        for(int i=0;i<arr.length-1;i++){
            for(j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    t = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }
            }
        }
        for (int i:arr){
            System.out.print(i+",");
        }
    }

//    选择排序法
//    a、将第一个值看成最小值
//　　b、然后和后续的比较找出最小值和下标
//　　c、交换本次遍历的起始值和最小值
//　　d、说明：每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，然后每次遍历无序列表找出最小值。
//    e、代码实现
    @Test
    public void xuanze(){
        int []arr = {1,5,6,2,8,7};
        int i,j,index,min;
        for(i=0;i<arr.length;i++){
            min = arr[i];
            index = i;
            for (j=i+1;j<arr.length;j++){
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[index];
            arr[index] = t;

        }
        for (int q:arr){
            System.out.print(q+",");
        }
    }
/*  插入排序法
    a、默认从第二个数据开始比较。
　　b、如果第二个数据比第一个小，则交换。然后在用第三个数据比较，如果比前面小，则插入（狡猾）。否则，退出循环
　　c、说明：默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出。
　　d、代码实现
 */
    @Test
    public void charu(){
        int []arr = {1,5,6,2,8,7};
        for(int i=1;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if(arr[j] < arr[j-1]){
                    int t = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = t;
                }
            }
        }
        for (int q:arr){
            System.out.print(q+",");
        }
    }
//希尔排序法
//    a、基本上和插入排序一样的道理
//　　b、不一样的地方在于，每次循环的步长，通过减半的方式来实现
//　　c、说明：基本原理和插入排序类似，不一样的地方在于。通过间隔多个数据来进行插入排序。
//    d、代码实现
    @Test
    public void xier(){
        int []arr = {1,5,6,2,8,7};
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k > 0  && k - i >= 0; k -= i) {
                    if (arr[k] < arr[k - i]) {
                        int temp = arr[k - i];
                        arr[k - i] = arr[k];
                        arr[k] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int q:arr){
            System.out.print(q+",");
        }
    }
//快速排序法
// a、确认列表第一个数据为中间值，第一个值看成空缺（低指针空缺）。
// b、然后在剩下的队列中，看成有左右两个指针（高低）。
// c、开始高指针向左移动，如果遇到小于中间值的数据，则将这个数据赋值到低指针空缺，并且将高指针的数据看成空缺值（高指针空缺）。然后先向右移动一下低指针，并且切换低指针移动。
// d、当低指针移动到大于中间值的时候，赋值到高指针空缺的地方。然后先高指针向左移动，并且切换高指针移动。重复c、d操作。
// e、直到高指针和低指针相等时退出，并且将中间值赋值给对应指针位置。
// f、然后将中间值的左右两边看成行的列表，进行快速排序操作。
// g、代码实现
    @Test
    public void kuaisu(){
        int []arr = {1,5,6,2,8,7};
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        for (int q:arr){
            System.out.print(q+",");
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        //如果指针在同一位置(只有一个数据时)，退出
        if (high - low < 1) {
            return;
        }
        //标记，从高指针开始，还是低指针（默认高指针）
        boolean flag = true;
        //记录指针的其实位置
        int start = low;
        int end = high;
        //默认中间值为低指针的第一个值
        int midValue = arr[low];
        while (true) {
            //高指针移动
            if (flag) {
                //如果列表右方的数据大于中间值，则向左移动
                if (arr[high] > midValue) {
                    high--;
                } else if (arr[high] < midValue) {
                    //如果小于，则覆盖最开始的低指针值，并且移动低指针，标志位改成从低指针开始移动
                    arr[low] = arr[high];
                    low++;
                    flag = false;
                }
            } else {
                //如果低指针数据小于中间值，则低指针向右移动
                if (arr[low] < midValue) {
                    low++;
                } else if (arr[low] > midValue) {
                    //如果低指针的值大于中间值，则覆盖高指针停留时的数据，并向左移动高指针。切换为高指针移动
                    arr[high] = arr[low];
                    high--;
                    flag = true;
                }
            }
            //当两个指针的位置相同时，则找到了中间值的位置，并退出循环
            if (low == high) {
                arr[low] = midValue;
                break;
            }
        }
        //然后出现有，中间值左边的小于中间值。右边的大于中间值。
        //然后在对左右两边的列表在进行快速排序
        quickSort(arr, start, low -1);
        quickSort(arr, low + 1, end);
    }



//    归并排序法
//    a、将列表按照对等的方式进行拆分
//　　b、拆分小最小快的时候，在将最小块按照原来的拆分，进行合并
//　　c、合并的时候，通过左右两块的左边开始比较大小。小的数据放入新的块中
//　　d、说明：简单一点就是先对半拆成最小单位，然后将两半数据合并成一个有序的列表。
//    e、代码实现
    @Test
    public void guibing(){
        int []arr = {1,25,6,2,8,7};
        int start = 0;
        int end = arr.length - 1;
        mergeSort(arr, start, end);
        for (int q:arr){
            System.out.print(q+",");
        }
    }
    public static void mergeSort(int[] arr, int start, int end) {
        //判断拆分的不为最小单位
        if (end - start > 0) {
            //再一次拆分，知道拆成一个一个的数据
            mergeSort(arr, start, (start + end) / 2);
            mergeSort(arr, (start + end) / 2 + 1, end);
            //记录开始/结束位置
            int left = start;
            int right = (start + end) / 2 + 1;
            //记录每个小单位的排序结果
            int index = 0;
            int[] result = new int[end - start + 1];
            //如果查分后的两块数据，都还存在
            while (left <= (start + end) / 2 && right <= end) {
                //比较两块数据的大小，然后赋值，并且移动下标
                if (arr[left] <= arr[right]) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                //移动单位记录的下标
                index++;
            }
            //当某一块数据不存在了时
            while (left <= (start + end) / 2 || right <= end) {
                //直接赋值到记录下标
                if (left <= (start + end) / 2) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                index++;
            }
            //最后将新的数据赋值给原来的列表，并且是对应分块后的下标。
            for (int i = start; i <= end; i++) {
                arr[i] = result[i - start];
            }
        }
    }


}
