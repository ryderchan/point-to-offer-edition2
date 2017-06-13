package chapter2;
/**
 * Created by ryder on 2017/6/13.
 * 替换空格
 * 把传入字符数组中的' '换成'&20',且传入数组保证有足够空间容纳修改后的字符
 */
public class P51_ReplaceSpaces {
    //由于java的字符数组没有结束符，所以需要多传入个原始长度
    public static void replaceBlank(char[] data,int length){
        int newLength = length;
        for(int i=0;i<length;i++){
            if(data[i]==' ')
                newLength += 2;
        }
        for(int indexOfOld = length-1,indexOfNew=newLength-1;indexOfOld>=0 && indexOfOld!=indexOfNew;indexOfOld--,indexOfNew--){
            if(data[indexOfOld]==' '){
                data[indexOfNew--] = '0';
                data[indexOfNew--] = '2';
                data[indexOfNew] = '%';
            }
            else{
                data[indexOfNew] = data[indexOfOld];
            }
        }
    }
    public static void main(String[] args){
        char[] predata = "We are happy.".toCharArray();
        char[] data = new char[20];
        for(int i=0;i<predata.length;i++)
            data[i] = predata[i];
        System.out.println(data);
        replaceBlank(data,13);
        System.out.println(data);
    }
}
