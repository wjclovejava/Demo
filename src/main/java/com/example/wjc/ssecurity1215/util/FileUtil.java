package com.example.wjc.ssecurity1215.util;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * create by shenjiankang on 2018/11/14 19:42
 */
public class FileUtil {


    /**
     * @description: inputStream 转base64
     * @param in
     * @Author shenjiankang
     * @Date 2018/11/14 19:44
     */
    public static String getBase64FromInputStream(InputStream in) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = in.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new String(Base64.encodeBase64(data));
    }


    /**
     * @description:    base64字符串转化成文件
     * @param base64Str
     * @param filePath
     * @Author shenjiankang
     * @Date 2018/11/14 19:44
     */
    public static boolean GenerateImage(String base64Str , String filePath) {
        //对字节数组字符串进行Base64解码并生成图片
        if (base64Str == null) //图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64Str);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String imgFilePath = filePath;//新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }



}
