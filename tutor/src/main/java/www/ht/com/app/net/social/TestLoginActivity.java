/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.net.social;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;


import butterknife.OnClick;
import www.ht.com.app.R;
import www.ht.com.app.net.social.sina.Constants;
import www.ht.com.app.ui.core.BaseActivity;

public class TestLoginActivity extends BaseActivity {


    private AuthInfo mAuthInfo;
    private SsoHandler mSsoHandler;
    private Oauth2AccessToken mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);
        Logger.init();
        // 创建微博实例
        mAuthInfo = new AuthInfo(this, Constants.APP_KEY,
                Constants.REDIRECT_URL, Constants.SCOPE);
        mSsoHandler = new SsoHandler(TestLoginActivity.this, mAuthInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_login, menu);
        return true;
    }

    @OnClick({R.id.weibo, R.id.weixin, R.id.qqLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.weixin:
                break;
            case R.id.weibo:
                mSsoHandler.authorize(new AuthListener());
                break;
            case R.id.qqLogin:
                break;
        }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    private class AuthListener implements WeiboAuthListener {

        @Override
        public void onComplete(Bundle bundle) {
            mAccessToken = Oauth2AccessToken.parseAccessToken(bundle); // 从 Bundle 中解析 Token
            if (mAccessToken.isSessionValid()) {
                //保存Token
//                AccessTokenKeeper.writeAccessToken(TestLoginActivity.this, mAccessToken);
                Logger.d("-----------------------------------------------%n mAccessToken=" + mAccessToken.toString());
            } else {
                // 当您注册的应用程序签名不正确时，就会收到错误Code，请确保签名正确
                String code = bundle.getString("code", "");
                Logger.d("------------------------------------------------%n code=%s", code);
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {
            Logger.e(e.getMessage(), e);
        }

        @Override
        public void onCancel() {
            Logger.d("cancel Login weibo");
        }
    }
}
