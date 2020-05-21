package suanfa.ioTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

//将输入的内容存到指定文件中
//源：从InputStream，Reader中选择; 因为是键盘录入的是纯文本，所以使用Reader。
//设备：键盘，所以用System.in; 发现System.in是字节流的操作，与Reader(字符流)矛盾，
//这时就要用到转换流 InputStreamReader 。为了提高操作效率，使用缓冲技术，选择BufferedReader。
//目的：从 OutputStream，Writer中选择。 因为是文本文件，所以选择Writer。
//设备：硬盘上，一个文件，选择FileWriter。 为了提高操作效率，使用缓冲技术，选择BufferedWriter。
public class IOtest1 {

    public static void test() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/jxliu/字节流测试.txt"));
        String line=null;
        while ((line = bufferedReader.readLine()) != null){
            if(line.equals("over")){
                break;
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
