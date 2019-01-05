package com.example.wjc.ssecurity1215.util;


import com.alibaba.fastjson.util.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * by yanwenjie on 2017/11/14
 */
public class HttpClientUtils {

    public static String httpClientPost(String url ,Map<String ,Object> params ,String encoding) throws IOException{
        return httpClientPost(url ,params ,encoding ,"");
    }

    /**
     * http请求工具类，支持文件形式的参数
     *
     * @param url
     * @param params
     * @param encoding
     * @return
     */
    public static String httpClientPost(String url ,Map<String ,Object> params ,String encoding ,String contentType) throws IOException {
        StringBuilder sb = new StringBuilder();
        HttpClient httpclient = new DefaultHttpClient();
        try{
            HttpPost post = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            ContentType ct = null;
            if (StringUtils.isNoneBlank(contentType)) {
                ct = ContentType.create(contentType, encoding);
                builder.setContentType(ct);
            }

            for (String key : params.keySet()){
                Object obj = params.get(key);
                if (obj == null)
                    continue;
                if (obj instanceof File)
                    builder.addBinaryBody(key , (File) obj);
                else{
                    StringBody body = null;
                    if (ct != null){
                        body = new StringBody(obj.toString() , ct);
                    }else{
                        body = new StringBody(obj.toString() , Charset.forName(encoding));
                    }
                    builder.addPart(key ,body);
                }
            }

            post.setEntity(builder.build());

            HttpResponse response = httpclient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entitys = response.getEntity();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(entitys.getContent()));
                String line = reader.readLine();
                return line;
            }else {
                HttpEntity r_entity = response.getEntity();
                String responseString = EntityUtils.toString(r_entity);
                return responseString;
            }
        }catch(Exception e){
            throw e;
        }finally {
            httpclient.getConnectionManager().shutdown();
        }
    }

    public static void downLoadFile(String url ,Map<String,String> params, String localFileName) {
        HttpClient httpClient = new DefaultHttpClient();
        OutputStream out = null;
        InputStream in = null;

        try {
            HttpGet httpGet = new HttpGet(url);

            for (String key : params.keySet()){
                String obj = params.get(key);
                httpGet.addHeader(key , obj);
            }

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            in = entity.getContent();

            long length = entity.getContentLength();
            if (length <= 0) {
                throw new FileNotFoundException(String.format("请求下载文件不存在！[%s]",params));
            }

            File file = new File(localFileName);
            if(!file.exists()){
                file.createNewFile();
            }

            out = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int readLength = 0;
            while ((readLength=in.read(buffer)) > 0) {
                byte[] bytes = new byte[readLength];
                System.arraycopy(buffer, 0, bytes, 0, readLength);
                out.write(bytes);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            IOUtils.close(in);
            IOUtils.close(out);
        }
    }

}
