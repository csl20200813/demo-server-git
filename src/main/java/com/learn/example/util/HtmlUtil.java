package com.learn.example.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtil {
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

    /**
     * @param htmlStr
     *
     * @return 删除Html标签
     */
    public static String delHTMLTag(String htmlStr) {
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        return htmlStr.trim(); // 返回文本字符串
    }

    public static String getTextFromHtml(String htmlStr) {
        htmlStr = delHTMLTag(htmlStr);
        htmlStr = htmlStr.replaceAll("&nbsp;", "");
        htmlStr = htmlStr.substring(0, htmlStr.indexOf("。") + 1);
        return htmlStr;
    }

    public static void main1(String[] args) {
        String str = "<font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\"><font size=\"3\" style=\"font-size: 12pt\">&lt;TF_title_1&gt;</font></font></span></font><font face=\"宋体\"><font size=\"3\" style=\"font-size: 12pt\">超短波技术</font></font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\"><font size=\"3\" style=\"font-size: 12pt\">&lt;/\n" +
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
                "<font color=\"#333333\"><font face=\"宋体\">庆祝中华人民共和国成立</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">70</font></span></font><font face=\"宋体\">周年阅兵式（简称</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">2019</font></span></font><font face=\"宋体\">年阅兵，或</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">2019</font></span></font><font face=\"宋体\">年国庆阅兵）是</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">2019</font></span></font><font face=\"宋体\">年</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">10</font></span></font><font face=\"宋体\">月</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">1</font></span></font><font face=\"宋体\">日<a href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%8D%8E%E4%BA%BA%E6%B0%91%E5%85%B1%E5%92%8C%E5%9B%BD/106554\" target=\"_blank\">中华人民共和国</a>政府为庆祝中华人民共和国成立</font><font face=\"等线, serif\"><span lang=\"en-US\"><font face=\"宋体, serif\">70</font></span></font><font face=\"宋体\">周年而开展的众多庆祝活动中的一项重要活动。</font></font></p>";
        System.out.println(getTextFromHtml(str));
    }


    public static void main(String[] args) {
        String str = "&lt;TF_title_1&gt;超短波技术&lt;/TF_title_1&gt;超短波技术";

        String s = str.replaceAll("&lt;TF(.*?)&gt;", "");


        System.out.println(str);
        System.out.println(s);
    }

}
