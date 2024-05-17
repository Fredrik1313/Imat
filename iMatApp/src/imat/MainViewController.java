
package imat;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductCategory;
import se.chalmers.cse.dat216.project.ShoppingItem;
import se.chalmers.cse.dat216.project.ShoppingCart;

public class MainViewController implements Initializable {

    @FXML
    Label pathLabel;

    IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();
    iMatBackendController backendController =  new iMatBackendController();
    public void initialize(URL url, ResourceBundle rb) {
        String iMatDirectory = iMatDataHandler.imatDirectory();
        pathLabel.setText(iMatDirectory);

    }

    //Efter genomfört köp så kör man denna funktionen med kundvagnen som en lista av ShoppingItems för att uppdatera listan med frekvent köpta objekt.
    void UpdateFrequentlyPurchasedList(List<ShoppingItem> shoppingItemsList) {
        backendController.addToMostPurchasedProducts(shoppingItemsList);
    }

    void UpdateCurrentProducts(List<Product> productsList)
    {

    }

    void AddToCart(Product product,Double amountToAdd)
    {
        iMatDataHandler.getShoppingCart().addProduct(product,amountToAdd);
    }
    void AddToCart(Product product)
    {
        iMatDataHandler.getShoppingCart().addProduct(product);
    }


    public void openDetailedProductView(Product product) {

    }
}