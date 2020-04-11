package httpclientUtils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

public class HttpclientUtils {

    public static void main(String[] args) throws IOException {
        String s = "上海";
        get("http://api.qingyunke.com/api.php?key=free&appid=0&msg=" + s);
    }

    public static void get(String url) throws IOException {
        //创建一个默认连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //获取状态码
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode == 200){
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("result=" + result);
        }
    }

    public static void post(String url) throws IOException {
        //创建一个默认连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("userName", "123"));
        nameValuePairs.add(new BasicNameValuePair("pwd", "654"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs,"UTF-8");
        httpPost.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode == 200){
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("result=" + result);
        }
    }
}
