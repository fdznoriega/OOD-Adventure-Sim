/*
 * Andrés Fernández
 */

public class BUFactory extends Factory
{

  public Book deliverPrint(String title) {
    return FactoryStore.makeFactory().deliverPrint(title);
  }

  public Book deliverDigital(String title) {
    return FactoryStore.makeFactory().deliverDigital(title);
  }
}
