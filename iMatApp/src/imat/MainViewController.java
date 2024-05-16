
package imat;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

public class MainViewController implements Initializable {

    @FXML
    Label pathLabel;

    IMatDataHandler iMatDataHandler = IMatDataHandler.getInstance();
    private iMatBackendController backendController =  new iMatBackendController();
    public void initialize(URL url, ResourceBundle rb) {

        String iMatDirectory = iMatDataHandler.imatDirectory();
        pathLabel.setText(iMatDirectory);
        backendController.


    }

        //Efter köp genomfört så kör man denna funktionen med kundvagnen som en lista av ShoppingItems för att uppdatera listan med frekvent köpta objekt.
    public void UpdateFrequentlyPurchasedList(List<ShoppingItem> shoppingItemsList) {
        backendController.addToMostPurchasedProducts(shoppingItemsList);


    }

}