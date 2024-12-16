package pl.szporka.sccserver;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;

@Configuration
public class SccServerConfig {

  @PostConstruct
  public void init() throws NoSuchAlgorithmException {
    int maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");
    System.out.println("Max AES Key Length: " + maxKeyLen);
  }
}
