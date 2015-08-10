package www.ht.com.app.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    public CharSequence getName() {
        return getTitle();
    }

    public void callMe(Class<? extends BaseActivity> aClass) {
        Intent intent = new Intent(this, aClass);
        startActivity(intent);
    }
}
