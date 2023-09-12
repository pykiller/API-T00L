package weixin;

import java.io.*;
import java.net.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import gui.ProxyManager;

public class WeiXinPacketSender {
    public String weixinHttpGetRequest(String url) {
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

    public String weixinHttpPostRequest(String url, String requestBody) {
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

    public String wxgetUserlistRequestBody() {

        // 构建 JSON 请求体
        return "{" +
                "\t\"limit\": 1000\n" +
                "}";
    }

    public String wxgetAddUserRequestBody(String mobile, String name, String title,String userid,String user) {
        String unicodeTitle = convertToUnicode(title);
        String unicodeName = convertToUnicode(name);
        // 构建 JSON 请求体
        return "{\n" +
                "  \"userid\": \"" + userid + "\",\n" +
                "  \"name\": \""+ unicodeName + "\",\n" +
                "  \"alias\": \"" + user + "\",\n" +
                "  \"mobile\": \"" + mobile + "\",\n" +
                "  \"department\": [1],\n" +
                "  \"order\": [10],\n" +
                "  \"position\": \"" + unicodeTitle + "\",\n" +
                "  \"gender\": \"1\",\n" +
                "  \"email\": \""+ user +"@gzdev.com\",\n" +
                "  \"is_leader_in_dept\": [1],\n" +
                "  \"enable\": 1,\n" +
                "  \"avatar_mediaid\": \"\",\n" +
                "  \"telephone\": \"020-123456\",\n" +
                "  \"address\": \"Beijing\",\n" +
                "  \"extattr\": {\n" +
                "    \"attrs\": [{\n" +
                "        \"type\": 0,\n" +
                "        \"name\": \"admin\",\n" +
                "        \"text\": {\n" +
                "          \"value\": \"admin\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": 1,\n" +
                "        \"name\": \"网页名称\",\n" +
                "        \"web\": {\n" +
                "          \"url\": \"http://www.test.com\",\n" +
                "          \"title\": \"标题\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"to_invite\": true,\n" +
                "  \"external_position\": \"\",\n" +
                "  \"external_profile\": {\n" +
                "    \"external_corp_name\": \"\",\n" +
                "    \"external_attr\": [{\n" +
                "        \"type\": 0,\n" +
                "        \"name\": \"文本名称\",\n" +
                "        \"text\": {\n" +
                "          \"value\": \"文本\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": 1,\n" +
                "        \"name\": \"网页名称\",\n" +
                "        \"web\": {\n" +
                "          \"url\": \"http://www.test.com\",\n" +
                "          \"title\": \"标题\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"type\": 2,\n" +
                "        \"name\": \"\",\n" +
                "        \"miniprogram\": {\n" +
                "          \"appid\": \"1\",\n" +
                "          \"pagepath\": \"/index\",\n" +
                "          \"title\": \"1\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
    }

}

