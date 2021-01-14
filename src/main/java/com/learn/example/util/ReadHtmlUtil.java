package com.learn.example.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class ReadHtmlUtil {


//    public static void main(String[] args) {
//        FileReader fr = null;
//        try {
//            fr = new FileReader("C:\\Users\\csl\\Desktop\\test.html");
//            char[] buf = new char[1024];
//            //read(char [])返回读到的字符个数
//            int num = 0;
//            while ((num = fr.read(buf)) != -1) //读取文件并把它存入buf中，用num返回读到字符的个数，一直读到结尾
//            {
//                System.out.print((new String(buf, 0, num)));//字符数组里仍有空白没有读入的位置，所以不要了
//                //new String(字符串，开始位置，结尾位置)
//            }
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        } finally {
//            try {
//                if (fr != null) {
//                    fr.close();
//                }
//            } catch (IOException e) {
//                System.out.println(e.toString());
//            }
//        }
//    }


//    public static void main(String[] args) {
//        FileReader fr = null;
//        try {
//            fr = new FileReader("C:\\Users\\csl\\Desktop\\test.html");
//            int ch = 0;
//            while ((ch = fr.read()) != -1) //记住即可，read方法如果没有可读取的了，则返回-1，所以就是一直读取，并将
//            //读取的内容存入ch，一直到结尾
//            {
//                System.out.print((char) ch);//打印读取的结果，由于ch是int类型，将其强制转换为String类型
//            }
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        } finally {
//            try {
//                if (fr != null) {
//                    fr.close();
//                }
//            } catch (IOException e) {
//                System.out.println(e.toString());
//            }
//        }
//
//    }


//    public void main(String[] args) throws IOException {
////        String content = this.readHtml();
//
//        ReadHtmlUtil readHtmlUtil = new ReadHtmlUtil();
//        String content = readHtmlUtil.readHtml();
//        System.out.println("转换后的html是： ------------ ");
//        System.out.println(content);
//    }


    public String readHtml() throws IOException {
        // FileReader属于字符流，是读取字符文件的便捷类。FileReader继承自InputStreamReader,InputStreamReader是将字节流转换为字符流的桥梁，实际上FileReader类在内部也是采用InputStreamReader完成字节流到字符流的转换，只不过转化我是采用的字符集为系统平台默认的字符集（GBK）
        FileInputStream fis = new FileInputStream("C:\\Users\\csl\\Desktop\\test.html");
        //将字节流转化为字符流，编码指定为文件保存的编码
        InputStreamReader isr = new InputStreamReader(fis, "gbk");
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        //以行为单位读取文件中的信息
        String content = "";
        while ((s = br.readLine()) != null) {
//            System.out.println(s);
            content += s;
        }
//        System.out.println(content);
        br.close();
        isr.close();
        fis.close();
        return content;
    }

}
