package feishu;

import gui.ProxyManager;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class FeiShuPacketSender {
    public String feishuHttpGetRequest(String url,String accessToken) {
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
                String authorizationHeader = "Bearer " + accessToken;
                connection.setRequestProperty("Authorization", authorizationHeader);


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
                String authorizationHeader = "Bearer " + accessToken;
                connection.setRequestProperty("Authorization", authorizationHeader);

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

    public String feishuHttpDELETERequest(String url,String accessToken) {
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
                connection.setRequestMethod("DELETE");
                connection.setRequestProperty("Accept", "*/*");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.5249.119 Safari/537.36");
                connection.setRequestProperty("Sec-Fetch-Site", "cross-site");
                connection.setRequestProperty("Sec-Fetch-Mode", "cors");
                connection.setRequestProperty("Sec-Fetch-Dest", "empty");
                String authorizationHeader = "Bearer " + accessToken;
                connection.setRequestProperty("Authorization", authorizationHeader);


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
                    return "DELETE request failed with response code: " + responseCode;
                }
            } else {
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                connection.setRequestMethod("DELETE");
                connection.setRequestProperty("Accept", "*/*");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.5249.119 Safari/537.36");
                connection.setRequestProperty("Sec-Fetch-Site", "cross-site");
                connection.setRequestProperty("Sec-Fetch-Mode", "cors");
                connection.setRequestProperty("Sec-Fetch-Dest", "empty");
                String authorizationHeader = "Bearer " + accessToken;
                connection.setRequestProperty("Authorization", authorizationHeader);

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
                    return "DELETE request failed with response code: " + responseCode;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            return "DELETE request failed with exception: " + e.getMessage();
        }
    }

    public String feishuHttpPostRequest(String url, String requestBody,String accessToken) {
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
                String authorizationHeader = "Bearer " + accessToken;
                connection.setRequestProperty("Authorization", authorizationHeader);
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
                String authorizationHeader = "Bearer " + accessToken;
                connection.setRequestProperty("Authorization", authorizationHeader);
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

    public String fsTokenRequestBody(String app_id,String app_secret) {

        // 构建 JSON 请求体
        return "{\n" +
                "  \"app_id\": \"" + app_id +"\",\n" +
                "  \"app_secret\": \""+ app_secret +"\"\n" +
                "}";
    }

    public String fsgetUserlistRequestBody() {

        // 构建 JSON 请求体
        return "{" +
                "\t\"limit\": 1000\n" +
                "}";
    }

    public String fsgetAddUserRequestBody(String mobile, String name, String title,String userid,String department_ids) {
        String unicodeTitle = convertToUnicode(title);
        String unicodeName = convertToUnicode(name);
        // 构建 JSON 请求体
        return "{\n" +
                "  \"user_id\": \"" + userid +"\",\n" +
                "  \"name\": \"" + unicodeName +"\",\n" +
                "  \"mobile\": \"+86" + mobile + "\",\n" +
                "  \"mobile_visible\": false," +
                "\"job_title\": \"" + unicodeTitle + "\"," +
                "  \"department_ids\": [\n" +
                "    \"" + department_ids + "\"\n" +
                "  ],\n" +
                "  \"employee_type\": \"1\"\n" +
                "}";
    }
}
