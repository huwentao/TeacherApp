/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.ui.activity.teacher;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.core.BaseActivity;
import www.ht.com.app.ui.fragment.parent.MapFragment;

public class NearParentActivity extends BaseActivity {

    @Bind(R.id.toolbar) Toolbar toolbar;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_parent);
        setToolBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        MapFragment mapFragment = MapFragment.newInstance(
                getResources().getString(R.string.findMapNearParent)
        );
        transaction.add(R.id.container, mapFragment, mapFragment.getName());
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parent_ask, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
