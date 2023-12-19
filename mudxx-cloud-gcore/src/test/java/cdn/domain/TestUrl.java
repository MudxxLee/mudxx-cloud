package cdn.domain;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author laiw
 * @date 2023/12/5 13:53
 */
public class TestUrl {

    public static void main(String[] args) {
        try {
            // 创建URL对象
            URL url = new URL("https://www.example.com/path/file.html?param1=value1&param2=value2#fragment");

            // 获取URL的协议
            String protocol = url.getProtocol();
            System.out.println("Protocol: " + protocol);

            // 获取URL的主机名
            String host = url.getHost();
            System.out.println("Host: " + host);

            // 获取URL的端口号
            int port = url.getPort();
            System.out.println("Port: " + port);

            // 获取URL的路径
            String path = url.getPath();
            System.out.println("Path: " + path);

            // 获取URL的查询参数
            String query = url.getQuery();
            System.out.println("Query: " + query);

            // 获取URL的片段（即锚点）
            String fragment = url.getRef();
            System.out.println("Fragment: " + fragment);


            // 获取URL的片段（即锚点）
            String urlFile = url.getFile();
            System.out.println("urlFile: " + urlFile);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
