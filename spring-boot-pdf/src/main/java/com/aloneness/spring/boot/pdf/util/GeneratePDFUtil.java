package com.aloneness.spring.boot.pdf.util;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class GeneratePDFUtil {

    // 利用模板生成pdf
    public static void interviewReportPDF(Map<String, String> map) {
        // 模板路径
        String templatePath = "D:/ProhibitDelete/test1.pdf";
        // 生成的新文件路径
        String newPDFPath = "D:/ProhibitDelete/test1-data.pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            // 输出流
            out = new FileOutputStream(newPDFPath);
            // 读取pdf模板
            reader = new PdfReader(templatePath);
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            // 给表单添加中文字体 这里采用系统字体。不设置的话，中文可能无法显示
            BaseFont bf = BaseFont.createFont("C:/Windows/Fonts/simfang.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            form.addSubstitutionFont(bf);

            //遍历map装入数据
            for (Entry<String, String> entry : map.entrySet()) {
                form.setField(entry.getKey(), entry.getValue());
                System.out.println("插入PDF数据---->  key= " + entry.getKey() + " and value= " + entry.getValue());
            }

            // 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.setFormFlattening(true);
            stamper.close();

            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            // 这里是PDF的页数 如果有两页及以上，还需要构造PdfImportedPage
            PdfImportedPage importPage1 = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage1);
            doc.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    // 测试
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("name", "冯杰");
        m.put("age", "23");
        m.put("sex", "男");
        m.put("deptName", "能力建设中心");
        interviewReportPDF(m);
    }
}

