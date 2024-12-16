package pl.szporka.sccclient;

public record AppProperties(
    String appName,
    String profiles,
    String sccMessage,
    String sccSecret
) {
  public void print() {
    System.out.println("Application name: " + appName);
    System.out.println("Profiles: " + profiles);
    System.out.println("SCC message: " + sccMessage);
    System.out.println("SCC secret: " + sccSecret);
  }
}
