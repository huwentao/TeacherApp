package www.ht.com.ap.config;

/**
 * Created by mokey on 2015/8/5.
 */
public class Config {

    private static Config config = null;

    private Config() {
    }

    public static Config getIntance(){
        if(config==null){
            config = new Config();
        }
        return config;
    }


}
