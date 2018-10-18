package pl.mig.qa.api.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {

    private static final Config CONFIG = ConfigFactory.load("config.conf");
    private static final String ENVIRONMENT = CONFIG.getString("environment");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    public static final String URL = ENV.getString("baseURL");
    public static final String URL_AZURE = ENV.getString("baseURLAzure");

    public static final String DB_CLASS = ENV.getString("databaseClass");

    public static final String DB_URL = ENV.getString("databaseURL");
    public static final String DB_USER = ENV.getString("databaseUser");
    public static final String DB_PASS = ENV.getString("databasePass");

}
