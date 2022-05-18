package es.ulpgc.eite.restaurantmenu.sections;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.restaurantmenu.data.MenuItem;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsViewModel {

  // put the view state here
  public MenuItem itemStarters;
  public MenuItem itemMainCourses;
  public MenuItem itemDesserts;

  public Integer priceMenu = 0;

  public void updatePrice() {
    List<MenuItem> list = new ArrayList<>();
    list.add(itemDesserts);
    list.add(itemMainCourses);
    list.add(itemStarters);
    priceMenu=0;
    for(MenuItem x : list){
      if (x!=null)
        priceMenu+= x.itemPrice;
    }
  }
}
