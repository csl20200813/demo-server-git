package com.learn.example.demo;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {

    /**
     * 查找某个字符串内是否包含某个字符串
     */
    @Test
    public void matcherTest() {
        String content = "I am noob " + "from runoob.com.";
        String pattern = ".*ru11noob.*";
        boolean matches = Pattern.matches(pattern, content);
        System.out.println(matches);
    }


    /**
     * 匹配两个特殊字符中间的字符串
     */
    @Test
    public void matcherTest1() {
        String str = "佛对焊#法兰手法类似%的飞机拉接发就发啦大家#发就发啦京东方垃圾收到了%福建安利#的房间安%静地发";
        String regex = "#(.*?)%";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }


    @Test
    public void matchTest4() {
        String s = "12342jasfkgnas234";
        //把字符串里面的数字替换成*
        String regex = "\\d";
        String ss = "*";
        String result = s.replaceAll(regex, ss);
        System.out.println(result);
    }


    /**
     * 从一个给定的字符串中找到数字串
     */
    @Test
    public void test2() {
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        //创建pattern对象
        Pattern p = Pattern.compile(pattern);
        //创建matcher对象
        Matcher m = p.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }


    @Test
    public void matcherTest2() {
        String input = "#测试1#，随便写点什么，#测试2#";
        String regex = "#([^#]*)#";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String[] str = {};
        while (matcher.find()) {
            String[] tmp = new String[str.length + 1];
            System.arraycopy(str, 0, tmp, 0, str.length);
            tmp[tmp.length - 1] = matcher.group(1);
            str = tmp;
        }
        System.out.println(Arrays.toString(str));
    }

    @Test
    public void matcherTest3() {
        String returnXml = "<resultdescription>单据  16613dd7d9a00000000000000000000vouchergl0  开始处理...单据  16613dd7d9a00000000000000000000vouchergl0  处理完毕!"
                + "</resultdescription>"
                + "<content>2018.09-记账凭证-5</content>"
                + "<billpk></billpk><bdocid>16613dd7d9a00000000000000000000vouchergl0</bdocid>"
                + "<filename>vouchergld861102.xml</filename><resultcode>1</resultcode>"
                + "<resultdescription>单据  16613dd7d9a00000000000000000000vouchergl0  开始处理...单据  16613dd7d9a00000000000000000000vouchergl0  处理完毕!"
                + "</resultdescription>"
                + "<content>2018.09-记账凭证-6</content></sendresult>";
        String regex = "<content>(.*?)</content>";
        List<String> list = new ArrayList<String>();
        List<String> extvounoLists = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(returnXml);
        while (m.find()) {
            int i = 1;

            list.add(m.group(i));
            i++;
        }
        for (String str : list) {
            System.out.println(str);
            String[] strs = str.split("-");
            String strss = strs[strs.length - 1];
            extvounoLists.add(strs[strs.length - 1]);
        }

        for (String string : extvounoLists) {
            System.out.println(string);
        }
    }


    @Test
    public void test44() {
        String regex = "([1-9]\\d*)([+\\-*/])([1-9]\\d*=?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("a11+2dasfdsa11+22esdfxca");

        System.out.println(matcher.find());
        matcher.find();

        System.out.println(matcher.groupCount());

        for (int i = 0; i <= matcher.groupCount(); i++) {
            System.out.println("起始： " + matcher.start(i));
            System.out.println("结束： " + matcher.end(i));
            System.out.println("group是： " + matcher.group(i));
        }
    }


    @Test
    public void testRegexInput() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\csl\\Desktop\\test.html");
        InputStreamReader isr = new InputStreamReader(fis, "gbk");
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        String content = "";
        while ((s = br.readLine()) != null) {
            content += s;
        }
        System.out.println(content);

        String regex = "&lt;TF_title_1&gt;(.*?)&lt;/TF_title_1&gt;";
//        String regex = "<font size=\"3\" style=\"font-size: 12pt\">(.*?)&lt;/TF_title_1&gt;";
//        String regex = "\">{1}\\S+</font>";
//        String regex = "###(.*?)$$$";;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("group是：" + matcher.group());


            String newStr = matcher.group(1);
            System.out.println("newStr是：  " + newStr);

            String s1 = newStr.replaceAll("\\<.*?>", "");
            System.out.println("去除标签后是：" + s1);
//            String regex1 = "\">{1}(.*?)</font>";
//            Pattern p1 = Pattern.compile(regex1);
//            Matcher matcher1 = p1.matcher(str);
//            while (matcher1.find()) {
////                System.out.println("内层group是" + matcher1.group());
//            }
//
//
//            int i = 1;
//            System.out.println(matcher.group(i++));

        }
    }

    @Test
    public void test232() {
        String x = "abaabaaaba".replaceAll("a{2}", "x");
        System.out.println(x);
    }

    @Test
    public void test231() {
        String test = "a<tr>aava</tr>abb ";
        String reg = "<.+>";
        System.out.println(test.replaceAll(reg, "###"));
    }


    @Test
    public  void test32423(){
        String str = "  hello,  world   ";
        str = str.replaceAll(" ","");
        System.out.println(str);
    }





}
