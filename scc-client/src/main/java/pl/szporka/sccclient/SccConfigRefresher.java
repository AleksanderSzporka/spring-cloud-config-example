package pl.szporka.sccclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SccConfigRefresher {

  private final RestTemplate restTemplate = new RestTemplate();

  @Value("${server.port:8080}")
  private String serverPort;

  @Scheduled(fixedRate = 5000)
  public void refreshConfig() {
    String refreshUrl = "http://localhost:" + serverPort + "/actuator/refresh";
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");

    HttpEntity<String> request = new HttpEntity<>(null, headers);
    try {
      restTemplate.postForEntity(refreshUrl, request, String.class);
    } catch (Exception e) {
      System.out.println("Error while refreshing config: " + e.getMessage());
    }
  }
}
