package www.ht.com.app.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.BaseActivity;

public class SettingActivity extends BaseActivity {
    @Bind(R.id.navigationView) NavigationView navigationView;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setToolBar(toolbar);
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
