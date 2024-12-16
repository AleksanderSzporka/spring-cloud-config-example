package pl.szporka.sccclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SccClientController {

  private final SccClientConfig config;

  public SccClientController(SccClientConfig config) {
    this.config = config;
  }

  @GetMapping()
  public AppProperties getAppProperties() {
    return config.getAppProperties();
  }
}
