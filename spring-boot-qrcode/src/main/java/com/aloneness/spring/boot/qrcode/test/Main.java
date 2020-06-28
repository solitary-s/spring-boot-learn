package com.aloneness.spring.boot.qrcode.test;

import com.aloneness.spring.boot.qrcode.util.QrCodeUtil;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author aloneness
 * @date 2020/6/28
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FileOutputStream os = new FileOutputStream(new File("D:/oa/123.png"));
//        QrCodeUtil.encode("http://www.baidu.com", "/static/images/1.png", os, true);
        QrCodeUtil.encode("http://www.baidu.com", null, os, true);
    }
}
