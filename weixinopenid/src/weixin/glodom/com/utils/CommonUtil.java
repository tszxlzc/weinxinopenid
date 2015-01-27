package weixin.glodom.com.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;
import weixin.glodom.com.ssl.MyX509TrustManager;

public class CommonUtil {
	/**
     * ����https����
     * 
     * @param requestUrl �����ַ
     * @param requestMethod ����ʽ��GET��POST��
     * @param outputStr �ύ������
     * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
     */
public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
            JSONObject jsonObject = null;
            try {
                    // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
					TrustManager[] tm = { new MyX509TrustManager() };
                    SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
                    sslContext.init(null, tm, new java.security.SecureRandom());
                    // ������SSLContext�����еõ�SSLSocketFactory����
                    SSLSocketFactory ssf = sslContext.getSocketFactory();
                    URL url = new URL(requestUrl);
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setSSLSocketFactory(ssf);
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    conn.setUseCaches(false);
                    // ��������ʽ��GET/POST��
                    conn.setRequestMethod(requestMethod);
                    //conn.setRequestProperty("content-type", "application/x-www-form-urlencoded"); 
                    // ��outputStr��Ϊnullʱ�������д����
                    if (null != outputStr) {
                            OutputStream outputStream = conn.getOutputStream();
                            // ע������ʽ
                            outputStream.write(outputStr.getBytes("UTF-8"));
                            outputStream.close();
                    }
                    // ����������ȡ��������
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String str = null;
                    StringBuffer buffer = new StringBuffer();
                    while ((str = bufferedReader.readLine()) != null) {
                            buffer.append(str);
                    }
                    // �ͷ���Դ
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStream.close();
                    inputStream = null;
                    conn.disconnect();
                    jsonObject = JSONObject.fromObject(buffer.toString());
            } catch (ConnectException ce) {
//                    Log.error("���ӳ�ʱ��{}", ce);
            	ce.printStackTrace();
            } catch (Exception e) {
            	e.printStackTrace();
//                    Log.error("https�����쳣��{}", e);
            }
            return jsonObject;
    }
}
