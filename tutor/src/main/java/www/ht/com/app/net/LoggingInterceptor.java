package www.ht.com.app.net;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by mokey on 2015/8/23.
 */
public class LoggingInterceptor implements Interceptor {
    private Logger logger = Logger.getLogger("HTTP Interceptor");

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();

        logger.info(String.format("Sending request %s on %s%n%s%n%s",
                request.url(), chain.connection(), request.headers(),request.body().toString()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        logger.info(String.format("Received response for %s in %.1fms%n%s \n\n",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}