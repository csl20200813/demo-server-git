package com.learn.example.controller;

import com.learn.example.service.IBBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class DemoController {
    @Autowired
    IBBService ibbService;


    @GetMapping("helloss")
    public void helloss() {
        ibbService.doInBB(222);
    }


    @CrossOrigin
    @PostMapping("testTwoFile")
    public void testTwoFile(@RequestParam("file1") MultipartFile file1,
                            @RequestParam("file2") MultipartFile file2) {
        System.out.println(file1.getOriginalFilename());
        System.out.println(file2.getOriginalFilename());
    }


    /**
     * <p>Description: 下载</p>
     *
     * @param path     路径
     * @param response
     */
    @GetMapping("/api/documents/download")
    public void download(String path, HttpServletResponse response) {
        try {
            // path： 欲下载的文件的路径
            File file = new File(path);
            // 获取文件名 - 设置字符集            String downloadFileName = new String(file.getName().getBytes(StandardCharsets.UTF_8), "iso-8859-1");
            // 以流的形式下载文件
            InputStream fis;
            fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
//            response.addHeader("Content-Disposition", "attachment;filename=" + downloadFileName);
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @CrossOrigin
    @GetMapping("hello")
    public String sayHello() {
        return "hahahhahahhelo";
    }

    /**
     * 1.文件上传
     * 2.转换
     * 3.获得html和图片保存路径
     * 4.HTML正则表达式替换img
     * 5.返回
     *
     * @param
     * @return
     */
    @CrossOrigin
    @PostMapping("bigFileConvertTest")
//    public String bigFileConvertTest(@RequestParam("file") MultipartFile file) throws IOException {
    public String bigFileConvertTest() throws IOException, InterruptedException {
//        System.out.println(file);

        String fileName = "C:\\Users\\csl\\Desktop\\test.docx";
        String command = "C:\\Program Files\\LibreOffice\\program\\soffice --headless --invisible --convert-to html " + fileName;
        String workDir = "C:\\Users\\csl\\Desktop\\tmp\\" + System.currentTimeMillis() + File.separator;
        File file = new File(workDir);
        file.mkdir();
        Process exec = Runtime.getRuntime().exec(command, null, file);

        //判断文件是否存在
        File htmlFile = new File("C:\\Users\\csl\\Desktop\\tmp\\test.html");
        if (!htmlFile.exists()) {
            System.out.println("文件不存在，等待");
        } else {
            System.out.println("文件加载成功！");
        }

        int i = exec.waitFor();

//        for (int i = 0; i < 1000; i++) {
//            if (!htmlFile.exists()) {
//                Thread.sleep(200);
//                System.out.println("文件不存在，等待" + i + "次");
//            }
//        }
    


        System.out.println("开始读取");
        //读取html文件
        FileInputStream fis = new FileInputStream(workDir + "test.html");
        InputStreamReader isr = new InputStreamReader(fis, "gbk");
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        String content = "";
        while ((s = br.readLine()) != null) {
            content += s;
        }
        System.out.println(content);
        br.close();
        isr.close();
        fis.close();

        //遍历html，获得图片列表
        List<String> srcList = new ArrayList<>(); //用来存储获取到的图片地址
        Pattern p = Pattern.compile("<(img|IMG)(.*?)(>|></img>|/>)");//匹配字符串中的img标签
        Matcher matcher = p.matcher(content);
        boolean hasPic = matcher.find();
        if (hasPic == true)//判断是否含有图片
        {
            while (hasPic) //如果含有图片，那么持续进行查找，直到匹配不到
            {
                String group = matcher.group(2);//获取第二个分组的内容，也就是 (.*?)匹配到的
                Pattern srcText = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");//匹配图片的地址
                Matcher matcher2 = srcText.matcher(group);
                if (matcher2.find()) {
                    srcList.add(matcher2.group(3));//把获取到的图片地址添加到列表中
                }
                hasPic = matcher.find();//判断是否还有img标签
            }

        }
        System.out.println("匹配到的内容：" + srcList);


        return content;
    }


    @CrossOrigin
    @GetMapping("testThread")
    public void testThread() {
        System.out.println("线程controller触发了");

        ExecutorService service = Executors.newFixedThreadPool(5);


    }


}
