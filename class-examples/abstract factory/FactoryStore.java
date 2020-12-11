/*
 * Andrés Fernández
 */

public class FactoryStore
{

  private FactoryStore() {}

  public static FactoryStore makeFactory() {
    return new FactoryStore();
  }

  // two args
  public Book deliverPrint(String title, String cover) {
    return new Print(title, cover);
  }

  public Book deliverDigital(String title, String cover) {
    return new Digital(title, cover);
  }

  // single arg
  public Book deliverPrint(String title) {
    return new Print(title);
  }

  public Book deliverDigital(String title) {
    return new Digital(title);
  }

}
