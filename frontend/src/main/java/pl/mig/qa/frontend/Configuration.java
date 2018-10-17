package pl.mig.qa.frontend;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {

    private static final Config CONFIG = ConfigFactory.load("config.conf");
    private static final String ENVIRONMENT = CONFIG.getString("environment");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);




    public static final String WORDPRESS_URL = ENV.getString("baseURL");
    public static final String LOGIN = ENV.getString("login");
    public static final String PASSWORD = ENV.getString("password");


}
