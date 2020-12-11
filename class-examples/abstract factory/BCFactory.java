/*
 * Andrés Fernández
 */

import java.util.*;

public class BCFactory extends Factory
{
  private ArrayList<String> covers = new ArrayList<>(Arrays.asList(
    "Baldwin the Eagle",
    "BC Eagles",
    "Heights"
  ));

  public String getRandom() {
    int randNum = (int) (Math.random() * covers.size());
    return covers.get(randNum);
  }

  public Book deliverPrint(String title) {
    return FactoryStore.makeFactory().deliverPrint(title, getRandom());
  }

  public Book deliverDigital(String title) {
    return FactoryStore.makeFactory().deliverDigital(title, getRandom());
  }

}
