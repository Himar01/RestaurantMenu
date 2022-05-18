package es.ulpgc.eite.restaurantmenu.sections;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.restaurantmenu.app.AppMediator;
import es.ulpgc.eite.restaurantmenu.app.ItemsToSectionsState;
import es.ulpgc.eite.restaurantmenu.app.SectionsToItemsState;
import es.ulpgc.eite.restaurantmenu.data.MenuItem;
import es.ulpgc.eite.restaurantmenu.data.MenuSection;

/**
 * Created by Luis on marzo, 2022
 */
public class SectionsPresenter implements SectionsContract.Presenter {

  public static String TAG = "RestaurantMenu.SectionsPresenter";

  private WeakReference<SectionsContract.View> view;
  private SectionsState state;
  private SectionsContract.Model model;
  private AppMediator mediator;

  public SectionsPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getSectionsState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // TODO: include some code if is necessary

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // TODO: include some code if is necessary
  }


  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");
    Log.e(TAG, "onResume()");
    ItemsToSectionsState savedState = mediator.getItemsToSectionsState();
    if(savedState!=null){
      switch (state.menuSection){
        case Desserts:
          state.itemDesserts = savedState.item;
          break;
        case Starters:
          state.itemStarters = savedState.item;
          break;
        case MainCourses:
          state.itemMainCourses = savedState.item;
          break;
      }
      state.priceMenu =
    }
    view.get().onDataUpdated(state);
  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");

    // TODO: include some code if is necessary
  }

  @Override
  public void onStartersBtnClicked() {
    Log.e(TAG, "onStartersBtnClicked()");
    passDataToItemsScreen(state.menuItems.itemsStarters);
    state.menuSection = MenuSection.Starters;
    view.get().navigateToNextScreen();
  }

  @Override
  public void onMainCoursesBtnClicked() {
    Log.e(TAG, "onMainCoursesBtnClicked()");
    passDataToItemsScreen(state.menuItems.itemsMainCourses);
    state.menuSection = MenuSection.MainCourses;
    view.get().navigateToNextScreen();
  }

  @Override
  public void onDessertsBtnClicked() {
    Log.e(TAG, "onDessertsBtnClicked()");
    passDataToItemsScreen(state.menuItems.itemsDesserts);
    state.menuSection = MenuSection.Desserts;
    view.get().navigateToNextScreen();
  }

  private void passDataToItemsScreen(List<MenuItem> sectionItem){
    List<MenuItem> items = sectionItem;
    SectionsToItemsState data = new SectionsToItemsState();
    data.itemsSection = items;
    mediator.setSectionsToItemsState(data);
  }
  @Override
  public void injectView(WeakReference<SectionsContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SectionsContract.Model model) {
    this.model = model;
  }

  @Override
  public void fetchProductListData() {
    Log.e(TAG, "fetchProductListData()");
    // call the model
    state.menuItems = model.getStoredData();

  }
}
