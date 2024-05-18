package imat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import se.chalmers.cse.dat216.project.ShoppingItem;

public class BigShoppingItemObject {

    private ShoppingItem shoppingItem;
    private MainViewController parentController;
    private Integer itemAmountInt;

    @FXML private ImageView itemImage;

    @FXML private Label itemName;
    @FXML private Label itemTotalCost;
    @FXML private TextField itemAmount;

    public BigShoppingItemObject(ShoppingItem shoppingItem,Integer itemAmountInt, Image itemImage, MainViewController parentController,String itemName, String itemTotalCost, String itemAmount){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BigShoppingItem.fxml"));
            this.itemImage.setImage(itemImage);
            this.itemAmountInt = itemAmountInt;
            this.parentController = parentController;
            this.shoppingItem = shoppingItem;
            this.itemName.setText(itemName);
            this.itemTotalCost.setText(itemTotalCost);
            this.itemAmount.setText(itemAmount);

    }
}
