package www.ht.com.app.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.base.BaseActivity;

public class SettingActivity extends BaseActivity {
    @Bind(R.id.navigationView) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.about:
                                callMe(AboutActivity.class);
                                break;
                            case R.id.version:
                                break;
                            case R.id.advice:
                                callMe(AdviceActivity.class);
                                break;
                            default:
                                return false;
                        }
                        return true;
                    }
                });
    }

}
