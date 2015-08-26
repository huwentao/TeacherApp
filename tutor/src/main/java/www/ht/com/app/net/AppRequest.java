/*
 * Copyright (c) 2015 huwentao (vernon.huwt@gmail.com)
 */

package www.ht.com.app.net;

import com.squareup.okhttp.OkHttpClient;

/**
 * Created by monkey on 2015/8/25.
 * http://zhanshi258.imwork.net:50623/
 */
public abstract class AppRequest {
    protected OkHttpClient okHttpClient = new OkHttpClient();

    public abstract void excute();
}
