package www.ht.com.app.net;

/**
 * Created by mokey on 2015/8/18.
 */
public enum ECode {

    success("0", "成功"),
    failed("-1", "加载失败了，再来一次"),
    timeout("-2", "网络不给力呀"),
    noData("-3", "暂无数据");

    private String code;
    private String message;

    ECode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
