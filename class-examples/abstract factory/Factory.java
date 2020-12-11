/*
 * Andrés Fernández
 */

public abstract class Factory
{

  protected FactoryStore factoryStore;

  public Factory() {}

  public abstract Book deliverPrint(String title);
  public abstract Book deliverDigital(String title);

}
