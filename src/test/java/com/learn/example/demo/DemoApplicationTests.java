package com.learn.example.demo;


import com.learn.example.config.ServerConfig;
import com.learn.example.util.JDBCUtils;
import com.learn.example.util.ReadHtmlUtil;
import com.learn.example.util.TestThisUtils;
import org.apache.commons.io.IOUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
class DemoApplicationTests {

    @Test
    public void bigFileLibreOfficeConvert() throws IOException, InterruptedException {
        String fileName = "C:\\Users\\csl\\Desktop\\test1.docx";
        String command = "C:\\Program Files\\LibreOffice\\program\\soffice --headless --invisible --convert-to html " + fileName;
        String workDir = "C:\\Users\\csl\\Desktop\\tmp\\" +
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + File.separator +
                System.currentTimeMillis() + File.separator;
        File file = new File(workDir);
        file.mkdirs();
        Process exec = Runtime.getRuntime().exec(command, null, file);
        int i = exec.waitFor();
        System.out.println("执行完毕");
    }


    @Test
    void contextLoads() throws IOException {

        /**
         * D:\soft\LibreOffice_6.0.6\program\soffice:表示libreoffice安装路径
         * D:\Desktop\DocCloud\testDir\hadoopInstall.doc：表示要转化的word文件
         */
//        String fileName = "C:\\Users\\csl\\Desktop\\test.html";
//        String fileName = "C:\\Users\\csl\\Desktop\\70周年阅兵.docx";
//        String fileName = "C:\\Users\\csl\\Desktop\\test1.docx";
//        String fileName = "C:\\Users\\csl\\Desktop\\test.pptx";
//        String fileName = "C:\\Users\\csl\\Desktop\\test.xlsx";
        String fileName = "C:\\Users\\csl\\Desktop\\test.pdf";
//        String command = "C:\\Program Files\\LibreOffice\\program\\soffice --headless --invisible --convert-to pdf " + fileName;
//        String command = "C:\\Program Files\\LibreOffice\\program\\soffice --headless --invisible --convert-to docx " + fileName;
        String command = "C:\\Program Files\\LibreOffice\\program\\soffice --headless --invisible --convert-to docx:\"Office Open XML Text\" " + fileName;
//        String command = "C:\\Program Files\\LibreOffice\\program\\soffice --headless --invisible --convert-to html " + fileName;
//        String command = "C:\\Program Files\\LibreOffice\\program\\soffice --headless --convert-to html " +
        /**
         *workDir:表示转化之后的HTML文件保存的路径地址
         */
        String workDir = "C:\\Users\\csl\\Desktop\\tmp\\" +
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + File.separator +
                System.currentTimeMillis() + File.separator;
        File file = new File(workDir);
        //创建目录--因为是UUID所以不用判断目录一定不存在
        file.mkdirs();
        /**
         *
         *
         * command:命令
         * null：操作系统运行程序时通过envp 参数将系统环境变量传递给程序
         * file：命令在那个路径下执行
         */
        //返回过程对象--Process
        Process exec = Runtime.getRuntime().exec(command, null, file);
        //错误信息
        InputStream errorStream = exec.getErrorStream();
        //结果信息
        InputStream inputStream = exec.getInputStream();
        //IOUtils-直接将流转化成字符串
        String error = IOUtils.toString(errorStream);
        String result = IOUtils.toString(inputStream);
        //打印信息
        System.out.println("error是：   " + error);
        System.out.println("result是：   " + result);
        System.out.println("inputSteam是：   " + inputStream.toString());


//        FileInputStream fis = new FileInputStream(workDir + "test.html");
//        InputStreamReader isr = new InputStreamReader(fis, "gbk");
//        BufferedReader br = new BufferedReader(isr);
//        String s = null;
//        String content = "";
//        while ((s = br.readLine()) != null) {
//            content += s;
//        }
//        System.out.println(content);
//
//
//        List<String> srcList = new ArrayList<String>(); //用来存储获取到的图片地址
//        Pattern p = Pattern.compile("<(img|IMG)(.*?)(>|></img>|/>)");//匹配字符串中的img标签
//        Matcher matcher = p.matcher(content);
//        boolean hasPic = matcher.find();
//        if (hasPic == true)//判断是否含有图片
//        {
//            while (hasPic) //如果含有图片，那么持续进行查找，直到匹配不到
//            {
//                String group = matcher.group(2);//获取第二个分组的内容，也就是 (.*?)匹配到的
//                Pattern srcText = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");//匹配图片的地址
//                Matcher matcher2 = srcText.matcher(group);
//                if (matcher2.find()) {
//                    srcList.add(matcher2.group(3));//把获取到的图片地址添加到列表中
//                }
//                hasPic = matcher.find();//判断是否还有img标签
//            }
//
//        }
//        System.out.println("匹配到的内容：" + srcList);
    }


    @Test
    public void run() throws FileNotFoundException, UnsupportedEncodingException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\csl\\Desktop\\test.html"), "GBK"));

        //根据标签名和.class获取节点的内容
        Document doc = Jsoup.parse(bufferedReader.toString());
        System.out.println(doc.text());


        Document doc1 = Jsoup.parseBodyFragment(bufferedReader.toString());
        Element body = doc1.body();
        System.out.println(body.toString());


//        //获取标签节点
//        Elements element = doc.select("body");
//        System.out.println("大小是：" + element.size());
//        //获取标签中的内容
//        for (int i = 0; i < element.size(); i++) {
//            System.out.println(element.get(i).ownText());
//            System.out.println(element.get(i).data());
//            System.out.println(element.get(i).html());
//            System.out.println(element.get(i).text());
//            System.out.println(element.get(i).val());
//            System.out.println(element.get(i).ownerDocument());
//            System.out.println(element.get(i).toString());
//        }
    }

    @Test
    void readHtmlFnc() throws IOException {
        ReadHtmlUtil readHtmlUtil = new ReadHtmlUtil();
        String ret = readHtmlUtil.readHtml();
        System.out.println("转换后的html是： ------------ ");
        System.out.println(ret);
    }

    @Test
    void testUploadFile() throws IOException {
//        File file = new File("C:\\Users\\csl\\Desktop\1.jpg");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\csl\\Desktop\\1.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\main\\resources\\files\\222-1.jpg"));
        int len = 0;
        byte[] bytes = new byte[2048];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();
    }

    @Test
    void test1() {
        ServerConfig serverConfig = new ServerConfig();
        System.out.println(serverConfig.getUrl());
    }

    @Test
    void test2() {
        System.out.println("得到的是：------：   " + JDBCUtils.getDemoStr());
    }

    @Test
    void test3() {
        String abc = "aabbc";
        System.out.println(abc.length());
    }

    @Test
    void testTime() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {

        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test123() {
        String htmlStr = "<body lang=\"zh-CN\" link=\"#000080\" vlink=\"#800000\" dir=\"ltr\"><p style=\"margin-bottom: 0cm; line-height: 100%\">\n" +
                "<font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\"><font size=\"3\" style=\"font-size: 12pt\">&lt;TF_title_1&gt;</font></font></span></font><font face=\"宋体\"><font size=\"3\" style=\"font-size: 12pt\">超短波技术</font></font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\"><font size=\"3\" style=\"font-size: 12pt\">&lt;/\n" +
                "TF_title_1&gt;</font></font></span></font></p>\n" +
                "<h1>超短波技术</h1>\n" +
                "<p align=\"left\" style=\"text-indent: 0.85cm; margin-bottom: 0cm; line-height: 0.64cm; orphans: 2; widows: 2; background: #ffffff\">\n" +
                "<font color=\"#333333\"><font face=\"宋体\">超短波（</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"Arial, serif\">ultra-short\n" +
                "wave</font></span></font><font face=\"宋体\">）亦称甚高频（</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"Arial, serif\">VHF</font></span></font><font face=\"宋体\">）波、米波（<a href=\"https://baike.baidu.com/item/%E6%B3%A2%E9%95%BF%E8%8C%83%E5%9B%B4/5463020\" target=\"_blank\">波长范围</a>为</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"Arial, serif\">1</font></span></font><font face=\"宋体\">米至</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"Arial, serif\">10</font></span></font><font face=\"宋体\">米），频率从</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"Arial, serif\">30</font></span></font><font face=\"宋体\">兆赫至</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"Arial, serif\">300M</font></span></font><font face=\"宋体\">赫的<a href=\"https://baike.baidu.com/item/%E6%97%A0%E7%BA%BF%E7%94%B5%E6%B3%A2/942435\" target=\"_blank\">无线电波</a>，传插频带宽，短距离传播依靠电磁的辐射特性，用于电视广播和无线话筒传送音频信号，采用锐方向性的天线可补偿传输过程的衰减。</font></font></p>\n" +
                "<p align=\"left\" style=\"text-indent: 0.85cm; margin-bottom: 0cm; line-height: 0.64cm; orphans: 2; widows: 2; background: #ffffff\">\n" +
                "<br/>\n" +
                "\n" +
                "</p>\n" +
                "<p style=\"margin-bottom: 0cm; line-height: 100%\"><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\"><font size=\"3\" style=\"font-size: 12pt\">&lt;TF_title_1&gt;70</font></font></span></font><font face=\"宋体\"><font size=\"3\" style=\"font-size: 12pt\">周年大阅兵</font></font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\"><font size=\"3\" style=\"font-size: 12pt\">&lt;/\n" +
                "TF_title_1&gt;</font></font></span></font></p>\n" +
                "<h1><font face=\"等线, serif\"><span lang=\"en-US\">70</span></font>周年大阅兵</h1>\n" +
                "<p style=\"text-indent: 0.74cm; margin-bottom: 0cm; line-height: 100%\">\n" +
                "<font color=\"#333333\"><font face=\"宋体\">这一刻，在美感和动感中感知中国力量！</font></font></p>\n" +
                "<p style=\"text-indent: 0.74cm; margin-bottom: 0cm; line-height: 100%\">\n" +
                "<font color=\"#333333\"><font face=\"宋体\">庆祝中华人民共和国成立</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">70</font></span></font><font face=\"宋体\">周年阅兵式（简称</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">2019</font></span></font><font face=\"宋体\">年阅兵，或</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">2019</font></span></font><font face=\"宋体\">年国庆阅兵）是</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">2019</font></span></font><font face=\"宋体\">年</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">10</font></span></font><font face=\"宋体\">月</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">1</font></span></font><font face=\"宋体\">日<a href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD/106554\" target=\"_blank\">中华人民共和国</a>政府为庆祝中华人民共和国成立</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">70</font></span></font><font face=\"宋体\">周年而开展的众多庆祝活动中的一项重要活动。</font></font></p>\n" +
                "</body>";
    }


    @Test
    public void test121232() {
        String str = "[JS] Lesson_01.mp4 hello world goodjob";
        String regex = "\\b";
        String s = str.replaceAll(regex, "#");
        System.out.println();
        System.out.println(s);
    }


    @Test
    public void test242343() throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\csl\\Desktop\\test.html");
        InputStreamReader isr = new InputStreamReader(fis, "gbk");
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        String content = "";
        while ((s = br.readLine()) != null) {
            content += s;
        }
        System.out.println(content);

        List<Integer> indexList = new ArrayList<>();
        int endIndex = 0;


        System.out.println(content.indexOf("</p>"));

        while (content.indexOf("</p>") != -1) {
            endIndex = content.indexOf("</p>");
            System.out.println(endIndex);
            indexList.add(endIndex);
            content = content.substring(endIndex + 4);
            System.out.println(endIndex);
        }

    }


    @Test
    public void test34332432() {
//        String abc = "hello";
//        abc = abc + "aaaaaaaaaaaa";
//        System.out.println(abc);


        StringBuffer str = new StringBuffer("world");
        System.out.println(str);


    }


    @Test
    public void test323() {
        TestThisUtils testThisUtils = new TestThisUtils();
        testThisUtils.A().A().B();
    }

}
