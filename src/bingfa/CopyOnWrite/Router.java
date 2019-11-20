package bingfa.CopyOnWrite;

// 路由信息
/**
 * CopyOnWrite 模式例子
 */
public final class Router{
    private final String  ip;
    private final Integer port;
    private final String  iface;
    // 构造函数
    public Router(String ip, Integer port, String iface){
        this.ip = ip;
        this.port = port;
        this.iface = iface;
    }
    // 重写 equals 方法
    public boolean equals(Object obj){
        if (obj instanceof Router) {
            Router r = (Router)obj;
            return iface.equals(r.iface) &&
                    ip.equals(r.ip) &&
                    port.equals(r.port);
        }
        return false;
    }
    public int hashCode() {
        // 省略 hashCode 相关代码
        return 0;
    }

    public String getIface() {
        return iface;
    }
}
