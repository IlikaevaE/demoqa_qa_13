package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/selenoid.properties")
public interface CredentialsConfig extends Config {
    String baseURL();
    String login();
    String password();
    String remoteWD();
}
