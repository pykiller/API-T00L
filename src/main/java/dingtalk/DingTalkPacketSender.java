package dingtalk;

import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import gui.ProxyManager;

public class DingTalkPacketSender {
    public String executeHttpGetRequest(String url,String xForwardedFor) {
        try {
            // 禁用SSL证书验证
            TrustManager[] trustAllCertificates = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCertificates, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
            URL obj = new URL(url);
            // 使用全局代理设置
            if (ProxyManager.getInstance().isUseProxy()) {
                Proxy proxy = ProxyManager.getInstance().getProxy();
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection(proxy);
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "*/*");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.5249.119 Safari/537.36");
                connection.setRequestProperty("Sec-Fetch-Site", "cross-site");
                connection.setRequestProperty("Sec-Fetch-Mode", "cors");
                connection.setRequestProperty("Sec-Fetch-Dest", "empty");
                // 添加 X-Forwarded-For 头部
                if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
                    connection.setRequestProperty("X-Forwarded-For", xForwardedFor);
                    connection.setRequestProperty("X-Forwarded", xForwardedFor);
                    connection.setRequestProperty("Forwarded-For", xForwardedFor);
                    connection.setRequestProperty("Forwarded", xForwardedFor);
                    connection.setRequestProperty("X-Forwarded-Host", xForwardedFor);
                    connection.setRequestProperty("X-Remote-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Remote-Addr", xForwardedFor);
                    connection.setRequestProperty("True-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Ali-Cdn-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Cdn-Src-Ip", xForwardedFor);
                    connection.setRequestProperty("Cdn-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Cf-Connecting-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Cluster-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Wl-Proxy-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Proxy-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Fastly-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("True-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Originating-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Host", xForwardedFor);
                    connection.setRequestProperty("X-Custom-Ip-Authorization", xForwardedFor);
                }

                connection.setDoOutput(true);
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    return response.toString();
                } else {
                    return "GET request failed with response code: " + responseCode;
                }
            } else {
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "*/*");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.5249.119 Safari/537.36");
                connection.setRequestProperty("Sec-Fetch-Site", "cross-site");
                connection.setRequestProperty("Sec-Fetch-Mode", "cors");
                connection.setRequestProperty("Sec-Fetch-Dest", "empty");
                // 添加 X-Forwarded-For 头部
                if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
                    connection.setRequestProperty("X-Forwarded-For", xForwardedFor);
                    connection.setRequestProperty("X-Forwarded", xForwardedFor);
                    connection.setRequestProperty("Forwarded-For", xForwardedFor);
                    connection.setRequestProperty("Forwarded", xForwardedFor);
                    connection.setRequestProperty("X-Forwarded-Host", xForwardedFor);
                    connection.setRequestProperty("X-Remote-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Remote-Addr", xForwardedFor);
                    connection.setRequestProperty("True-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Ali-Cdn-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Cdn-Src-Ip", xForwardedFor);
                    connection.setRequestProperty("Cdn-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Cf-Connecting-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Cluster-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Wl-Proxy-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Proxy-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Fastly-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("True-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Originating-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Host", xForwardedFor);
                    connection.setRequestProperty("X-Custom-Ip-Authorization", xForwardedFor);
                }

                connection.setDoOutput(true);
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    return response.toString();
                } else {
                    return "GET request failed with response code: " + responseCode;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            return "GET request failed with exception: " + e.getMessage();
        }
    }

    public String executeHttpPostRequest(String url, String requestBody,String xForwardedFor) {
        try {
            // 禁用SSL证书验证
            TrustManager[] trustAllCertificates = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            URL obj = new URL(url);
            if (ProxyManager.getInstance().isUseProxy()) {
                Proxy proxy = ProxyManager.getInstance().getProxy();
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection(proxy);

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.5249.119 Safari/537.36");
                connection.setRequestProperty("Sec-Fetch-Site", "cross-site");
                connection.setRequestProperty("Sec-Fetch-Mode", "cors");
                connection.setRequestProperty("Sec-Fetch-Dest", "empty");
                connection.setDoOutput(true);
                // 添加 X-Forwarded-For 头部
                if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
                    connection.setRequestProperty("X-Forwarded-For", xForwardedFor);
                    connection.setRequestProperty("X-Forwarded", xForwardedFor);
                    connection.setRequestProperty("Forwarded-For", xForwardedFor);
                    connection.setRequestProperty("Forwarded", xForwardedFor);
                    connection.setRequestProperty("X-Forwarded-Host", xForwardedFor);
                    connection.setRequestProperty("X-Remote-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Remote-Addr", xForwardedFor);
                    connection.setRequestProperty("True-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Ali-Cdn-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Cdn-Src-Ip", xForwardedFor);
                    connection.setRequestProperty("Cdn-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Cf-Connecting-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Cluster-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Wl-Proxy-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Proxy-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Fastly-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("True-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Originating-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Host", xForwardedFor);
                    connection.setRequestProperty("X-Custom-Ip-Authorization", xForwardedFor);
                }

                connection.setDoOutput(true);

                // 发送请求体
                try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                    outputStream.writeBytes(requestBody);
                    outputStream.flush();
                }

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    return response.toString();
                } else {
                    return "POST request failed with response code: " + responseCode;
                }

            } else {

                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.5249.119 Safari/537.36");
                connection.setRequestProperty("Sec-Fetch-Site", "cross-site");
                connection.setRequestProperty("Sec-Fetch-Mode", "cors");
                connection.setRequestProperty("Sec-Fetch-Dest", "empty");
                connection.setDoOutput(true);
                // 添加 X-Forwarded-For 头部
                if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
                    connection.setRequestProperty("X-Forwarded-For", xForwardedFor);
                    connection.setRequestProperty("X-Forwarded", xForwardedFor);
                    connection.setRequestProperty("Forwarded-For", xForwardedFor);
                    connection.setRequestProperty("Forwarded", xForwardedFor);
                    connection.setRequestProperty("X-Forwarded-Host", xForwardedFor);
                    connection.setRequestProperty("X-Remote-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Remote-Addr", xForwardedFor);
                    connection.setRequestProperty("True-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Ali-Cdn-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Cdn-Src-Ip", xForwardedFor);
                    connection.setRequestProperty("Cdn-Real-Ip", xForwardedFor);
                    connection.setRequestProperty("Cf-Connecting-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Cluster-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Wl-Proxy-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Proxy-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("Fastly-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("True-Client-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Originating-Ip", xForwardedFor);
                    connection.setRequestProperty("X-Host", xForwardedFor);
                    connection.setRequestProperty("X-Custom-Ip-Authorization", xForwardedFor);
                }

                connection.setDoOutput(true);

                // 发送请求体
                try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                    outputStream.writeBytes(requestBody);
                    outputStream.flush();
                }

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    return response.toString();
                } else {
                    return "POST request failed with response code: " + responseCode;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "POST request failed with exception: " + e.getMessage();
        }
    }



    public String convertToUnicode(String input) {
        StringBuilder unicode = new StringBuilder();
        for (char character : input.toCharArray()) {
            unicode.append("\\u").append(String.format("%04x", (int) character));
        }
        return unicode.toString();
    }

    public String getCreateUserRequestBody(String mobile, String name, String title,String userid) {
        String unicodeTitle = convertToUnicode(title);
        String unicodeName = convertToUnicode(name);

        // 构建 JSON 请求体
        return "{" +
                "\"userid\":\"" + userid +"\"," +
                "\"name\":\"" + unicodeName + "\"," +
                "\"mobile\":\"" + mobile + "\"," +
                "\"title\":\"" + unicodeTitle + "\"," + // 将 Unicode 编码的 title 放入 JSON
                "\"hired_date\":\"1615219200000\"," +
                "\"work_place\":\"beijing\"," +
                "\"senior_mode\":\"true\"," +
                "\"dept_id_list\":\"1\"" +
                "}";
    }

    public String getblackboardRequestBody(String deptid_list, String operation_userid, String title, String content) {
        String unicodeTitle = convertToUnicode(title);
        String unicodecontent = convertToUnicode(content);

        // 构建 JSON 请求体
        return "{" +
                "\"create_request\":{" +
                "\"blackboard_receiver\":{" +
                "\"deptid_list\":[" +
                deptid_list +
                "]" +
                "}," +
                "\"operation_userid\":\"" + operation_userid + "\"," +
                "\"title\":\""+ unicodeTitle +"\"," +
                "\"content\":\"" + unicodecontent + "\"" +
                "}" +
                "}";
    }

}


