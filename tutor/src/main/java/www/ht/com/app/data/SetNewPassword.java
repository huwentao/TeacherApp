package www.ht.com.app.data;

/**
 * Created by mokey on 2015/8/23.
 */
public class SetNewPassword {
    private String mobile;
    private String new_password;
    private String vcode;

    public SetNewPassword(String mobile, String new_password, String vcode) {
        this.mobile = mobile;
        this.new_password = new_password;
        this.vcode = vcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
}
