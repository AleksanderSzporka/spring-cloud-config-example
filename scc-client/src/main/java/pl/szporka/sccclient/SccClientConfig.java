package pl.szporka.sccclient;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
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
    System.out.println("Application name: " + appName);
    System.out.println("Profiles: " + profiles);
    System.out.println("SCC message: " + sccMessage);
    System.out.println("SCC secret: " + sccSecret);
  }
}
