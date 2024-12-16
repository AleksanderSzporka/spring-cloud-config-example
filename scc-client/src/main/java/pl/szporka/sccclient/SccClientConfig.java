package pl.szporka.sccclient;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class SccClientConfig {

  @Value("${spring.application.name}")
  private String appName;

  @Value("${spring.profiles.active:}")
  private String profiles;

  @Value("${scc.message}")
  private String sccMessage;

  @Value("${scc.secret}")
  private String sccSecret;

  @PostConstruct
  public void init() {
    getAppProperties().print();
  }

  public AppProperties getAppProperties() {
    return new AppProperties(appName, profiles, sccMessage, sccSecret);
  }
}
