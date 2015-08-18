package www.ht.com.app.config;

/**
 * Created by mokey on 2015/8/5.
 */
public class Config {
    public static final String LOGIN_LOGININFO = "login_Info";
    public static final String LOGIN_LOGINID = "login_loginID";
    public static final String LOGIN_TOKEN = "login_token";
    public static final String LOGIN_REFRESHTIME = "login_refreshTime";
    public static final String LOGIN_AGENT = "login_agent";
    public static final String LOGIN_USERNAME = "login_userName";
    public static final String LOGIN_TYPE = "login_type";
    public static final String LOGIN_LOGINEDTIME = "login_loginedTime";

    private AppType mAppType;
    private ServerConfig mServerConfig = null;

    private static Config config = null;

    private Config(AppType appType) {
        mAppType = appType;
    }

    /**
     * 加载生产环境
     *
     * @param appType
     * @return
     */
    public static Config getIntance(AppType appType) {
        if (config == null) {
            config = new Config(appType);
        }
        config.mServerConfig = ServerConfig.getConfig();
        return config;
    }

    /**
     * 加载测试环境
     *
     * @param appType
     * @return
     */
    public static Config getDebugIntance(AppType appType) {
        if (config == null) {
            config = new Config(appType);
        }
        config.mServerConfig = ServerConfig.getTestConfig();
        return config;
    }

    static class ServerConfig {
        private static String SERVERADDRESS = "";
        private static int SERVERPORT = 80;

        public static ServerConfig getTestConfig() {
            ServerConfig serverConfig = new ServerConfig();
            SERVERADDRESS = "";
            SERVERPORT = 8080;
            return serverConfig;
        }

        public static ServerConfig getConfig() {
            ServerConfig serverConfig = new ServerConfig();
            SERVERADDRESS = "";
            SERVERPORT = 8080;
            return serverConfig;
        }
    }

    public AppType getAppType() {
        return mAppType;
    }

    public static AppType getAppType(int type) {
        switch (type) {
            case 1:
                return AppType.Teacher;
            case 2:
                return AppType.Parent;
        }
        return AppType.Parent;
    }
}
