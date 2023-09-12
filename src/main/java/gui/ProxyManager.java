package gui;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class ProxyManager {
    private static ProxyManager instance;
    private Proxy proxy;
    private boolean useProxy; // 添加一个标志用于控制是否使用代理

    private ProxyManager() {
        proxy = Proxy.NO_PROXY;
        useProxy = false; // 默认情况下不使用代理
    }

    public static ProxyManager getInstance() {
        if (instance == null) {
            instance = new ProxyManager();
        }
        return instance;
    }

    public void setProxy(String host, int port) {
        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port));
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void clearProxy() {
        proxy = Proxy.NO_PROXY;
    }

    public boolean isUseProxy() {
        return useProxy;
    }

    public void setUseProxy(boolean useProxy) {
        this.useProxy = useProxy;
    }
}
