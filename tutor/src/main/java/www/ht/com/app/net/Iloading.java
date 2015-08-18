package www.ht.com.app.net;

/**
 * Created by mokey on 2015/8/18.
 */
public interface Iloading {

    void loading(int prgress);

    void loaded();

    void noData();

    void canceled();

    void loadFailed(ECode eCode, onLoadFailedListener onLoadFailedListener);

    public interface onLoadFailedListener {
        void onLoadFailed(ECode eCode);
    }
}
