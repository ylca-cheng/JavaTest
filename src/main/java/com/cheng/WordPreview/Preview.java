package com.cheng.WordPreview;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import org.junit.Test;

import java.io.File;

/**
 * Created by niecheng on 2019/9/4.
 */
public class Preview {
    public  void wToPdfChange(String wordFile, String pdfFile) {//wordFile word 的路径  //pdfFile pdf 的路径

        ActiveXComponent app = null;
        System.out.println("开始转换...");
        // 开始时间
        // long start = System.currentTimeMillis();
        try {
            // 打开word
            app = new ActiveXComponent("Word.Application");
            // 获得word中所有打开的文档
            Dispatch documents = app.getProperty("Documents").toDispatch();
            System.out.println("打开文件: " + wordFile);
            File file = new File(wordFile);
            // 打开文档
            Dispatch document = Dispatch.call(documents, "Open", file, false, true).toDispatch();
            // 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
            File target = new File(pdfFile);
            if (target.exists()) {
                target.delete();
            }
            System.out.println("另存为: " + pdfFile);
            Dispatch.call(document, "SaveAs", pdfFile, 17);
            // 关闭文档
            Dispatch.call(document, "Close", false);
        } catch (Exception e) {
            System.out.println("转换失败" + e.getMessage());
        } finally {
            // 关闭office
            app.invoke("Quit", 0);
        }
    }


    public static void main(String[] args) {


        String word = "\\test.docx";
        String name = "\\zhukaixin".concat(".pdf");
        String pdf = "D:\\" + name;
//        wToPdfChange(word, name);
    }

    @Test
    public void test(){
        System.out.println(this.getClass().getResource("/tmp").getPath().substring(1));
        String bathPath = this.getClass().getResource("/tmp").getFile().substring(1);
        String word = bathPath+"/test.docx";
        String name = bathPath+"/zhukaixin".concat(".pdf");
        String pdf = "D:\\" + name;
        wToPdfChange(word, name);
    }

    @Test
    public void test1(){
        File file = new File("/tmp/test.docx");
//        File file = new File(String.valueOf(this.getClass().getResourceAsStream("/tmp/test.docx")));
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
/*        String word = "/tmp/test.docx";
        String name = "/zhukaixin".concat(".pdf");
        String pdf = "D:\\" + name;
        wToPdfChange(word, name);*/
    }
}
