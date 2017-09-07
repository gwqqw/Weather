import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) {
        json();
    }

    private static void json(){
        try{
            String city = URLEncoder.encode("北京", "utf-8");

            String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s", city);

            URL url = new URL(apiUrl);
            URLConnection open = url.openConnection();
            InputStream input = open.getInputStream();

            String result = inputString2String(input);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void xml()
    {
        try{
            String city = URLEncoder.encode("北京", "utf-8");
            String apiUrl = String.format("http://www.sojson.com/open/api/weather/xml.shtml?city=%s", city);

            URL url = new URL(apiUrl);
            URLConnection open  = url.openConnection();

            InputStream input = open.getInputStream();

            String result = inputString2String(input);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static String inputString2String(InputStream is)
    {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        try{
            int n = 0;
            while( (n = is.read(b))!=-1){
                out.append(new String(b, 0, n));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return  out.toString();
    }
}
