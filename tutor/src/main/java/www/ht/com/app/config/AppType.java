package www.ht.com.app.config;

/**
 * Created by mokey on 2015/8/18.
 */
public enum AppType {
    Teacher(1), Parent(2);

    private int mType;

    AppType(int type) {
        mType = type;
    }

    public int getType() {
        return mType;
    }
}
