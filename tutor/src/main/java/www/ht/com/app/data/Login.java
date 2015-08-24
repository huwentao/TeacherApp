package www.ht.com.app.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mokey on 2015/8/23.
 */
public class Login implements Parcelable {
    public static final Parcelable.Creator<Login> CREATOR = new Parcelable.Creator<Login>() {
        public Login createFromParcel(Parcel source) {
            return new Login(source);
        }

        public Login[] newArray(int size) {
            return new Login[size];
        }
    };
    private String mobile;//
    private String password;//
    private String deviceId;//

    public Login(String mobile, String password, String deviceId) {
        this.mobile = mobile;
        this.password = password;
        this.deviceId = deviceId;
    }

    public Login() {
    }

    protected Login(Parcel in) {
        this.mobile = in.readString();
        this.password = in.readString();
        this.deviceId = in.readString();
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mobile);
        dest.writeString(this.password);
        dest.writeString(this.deviceId);
    }
}
