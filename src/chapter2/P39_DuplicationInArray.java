package chapter2;
/**
 * Created by ryder on 2017/6/11.
 * 一个长度为n的数组，值得范围在0~n-1内，有一个或多个数字重复，求其中任意一个
 */
public class P39_DuplicationInArray {
    //方法一：暴力求解，不会修改原始数据，时间复杂度o(n^2)，空间复杂度o(1)
    public static int getDuplication(int[] data){
        if(data==null || data.length<2)
            return -1;
        for(int i=0;i<data.length-1;i++){
            for(int j=i+1;j<data.length;j++){
                if(data[i]==data[j])
                    return data[i];
            }
        }
        return -1;
    }
    //方法二：排序，会修改原始数据，时间复杂度o(nlogn)，空间复杂度o(1)
    public static int getDuplication2(int[] data){
        if(data==null || data.length<2)
            return -1;
        //Arrays.sort(data); //或者使用内置函数进行排序
        quickSort(data,0,data.length-1);
        if(data.length<2)
            return -1;
        int prev = data[0];
        for(int i=1;i<data.length;i++){
            if(data[i]==prev)
                return prev;
            else
                prev = data[i];
        }
        return -1;
    }
    public static void quickSort(int[] data,int start,int end){
        if(start>=end)
            return;
        int bound = partion(data,start,end);
        quickSort(data,start,bound-1);
        quickSort(data,bound+1,end);
    }
    public static int partion(int[] data,int start,int end){
        if(start>=end)
            return end;
        int pivot = data[start];
        int left = start, right = end;
        while(left<right){
            while(left<right && data[right]>=pivot)
                right--;
            if(left<right)
                data[left++] = data[right];
            while(left<right && data[left]<pivot)
                left++;
            if(left<right)
                data[right--] = data[left];
        }
        data[left] = pivot;
        return left;
    }

    //方法三：借助哈希表，不会修改原始数据，时间复杂度o(n),空间复杂度o(n)
    public static int getDuplication3(int[] data){
        if(data==null || data.length<2)
            return -1;
        int[] hashTable = new int[data.length];
        for(int item:data){
            if(hashTable[item]>=1)
                return item;
            else{
                hashTable[item] = 1;
            }
        }
        return -1;
    }

    //方法四：根据数字特点排序，会修改原始数据，时间复杂度o(n),空间复杂度o(1)
    public static int getDuplication4(int[] data){
        if(data==null || data.length<2)
            return -1;
        for(int i=0;i<data.length;i++){
            while(data[i]!=i){
                if(data[i]==data[data[i]])
                    return data[i];
                else{
                    int temp = data[i];
                    data[i] = data[data[i]];
                    data[data[i]] = temp;
                }
            }
        }
        return -1;
    }

    //方法五：类似于二路归并，这个思路应该说是二路计数，不修改原始数据，时间复杂度o(nlogn),空间复杂度o(1)
    public static int getDuplication5(int[] data){
        if(data==null || data.length<2)
            return -1;
        //数组值在[start,end]间
        int start = 0;
        int end = data.length-2;
        while(start<=end){
            int middle = (end-start)/2+start;
            int count = countRange(data,start,middle);
            if(start==end){
                if(count>1)
                    return start;
                else
                    return -1;
            }
            if(count>middle-start+1)
                end = middle;
            else
                start = middle+1;
        }
        return -1;
    }
    public static int countRange(int[] data,int start,int end){
        int count = 0;
        for(int i=0;i<data.length;i++){
            if(start<=data[i] && end>=data[i])
                count++;
        }
        return count;
    }
    public static void main(String[] args){
        int[] data = {2,3,1,0,2,5,3};
        System.out.println(getDuplication(data));
        System.out.println(getDuplication2(data));
        System.out.println(getDuplication3(data));
        System.out.println(getDuplication4(data));
        System.out.println(getDuplication5(data));

        int[] data1 = {2,3,1,0,4,5,5};
        System.out.println(getDuplication(data1));
        System.out.println(getDuplication2(data1));
        System.out.println(getDuplication3(data1));
        System.out.println(getDuplication4(data1));
        System.out.println(getDuplication5(data1));
    }
}
