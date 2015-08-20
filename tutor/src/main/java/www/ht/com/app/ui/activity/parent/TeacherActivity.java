package www.ht.com.app.ui.activity.parent;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import www.ht.com.app.R;
import www.ht.com.app.ui.BaseActivity;
import www.ht.com.app.ui.activity.adapter.TeacherRecyclerAdapter;

public class TeacherActivity extends BaseActivity {

//    @Bind(R.id.floatActionButton) FloatingActionButton floatingActionButton;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    @Bind(R.id.collapsingToolbar) CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        setToolBar(toolbar);

//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SnackBarUtils.makeSnackBar(v, "提示一下", "点我", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Logger.d("snackbar click......");
//                    }
//                }).show();
//            }
//        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        TeacherRecyclerAdapter teacherRecyclerAdapter = new TeacherRecyclerAdapter();
        recyclerView.setAdapter(teacherRecyclerAdapter);

    }

    /**
     * 初始化Toolbar的初始配置
     */
    public void initToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            collapsingToolbar.setTitle("李老师");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_teacher, menu);
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
