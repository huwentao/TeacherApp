package www.ht.com.app.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mokey on 2015/8/23.
 */
public class Register implements Parcelable {
    public static final Creator<Register> CREATOR = new Creator<Register>() {
        public Register createFromParcel(Parcel source) {
            return new Register(source);
        }

        public Register[] newArray(int size) {
            return new Register[size];
        }
    };
    private String mobile;
    private String password;
    private String userName;
    private String vcode;
    private String userType; //1:教师  2：家长

    public Register() {
    }

    public Register(String userType, String mobile, String password, String userName, String vcode) {
        this.mobile = mobile;
        this.password = password;
        this.userName = userName;
        this.vcode = vcode;
        this.userType = userType;
    }

    protected Register(Parcel in) {
        this.mobile = in.readString();
        this.password = in.readString();
        this.userName = in.readString();
        this.vcode = in.readString();
        this.userType = in.readString();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mobile);
        dest.writeString(this.password);
        dest.writeString(this.userName);
        dest.writeString(this.vcode);
        dest.writeString(this.userType);
    }
}