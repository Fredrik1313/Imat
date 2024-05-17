package imat;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import se.chalmers.cse.dat216.project.Product;

public class ProductItem extends AnchorPane {

    private Product product;
    private MainViewController parentController;
    @FXML private ImageView productImage;
    @FXML private Label productName;
    @FXML private Label productPrice;
    @FXML private Text productDescription;
    @FXML private Label productCategory;
    @FXML private Label productUnit;


    @FXML
    protected void onClick(Event event){
        parentController.openDetailedProductView(product);
    }
    public ProductItem(Product product, String productName,Image productImage, Double productPrice, String productDescription, String productCategory, String productUnit) {
        this.product = product;
        this.productImage.setImage(productImage);
        this.productPrice.setText(productPrice.toString());
        this.productName.setText(productName);
        this.productDescription.setText(productDescription);
        this.productCategory.setText(productCategory);
        this.productUnit.setText(productUnit);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProductItem.fxml"));
        }

}
