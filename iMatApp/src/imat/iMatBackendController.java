package imat;

import se.chalmers.cse.dat216.project.Order;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.util.*;

public class iMatBackendController {


    public List<Order> previousOrders = new ArrayList<>();
    public List<Order> savedOrders = new ArrayList<>();

    List<Product> mostPurchasedProducts = new ArrayList<>();
    List<SortedProduct> frequentlyPurchasedSortedProductList = new ArrayList<>();
    List<Product> sortedMostPurchasedListToReturn = new ArrayList<>();

    //Function for sorting hte most purchased products in the store.
    private void sortMostPurchasedProducts() {
        mostPurchasedProducts.sort(Comparator.comparing(Product::getProductId));
        for (Product product : mostPurchasedProducts) {
            if(frequentlyPurchasedSortedProductList.isEmpty())
            {
                frequentlyPurchasedSortedProductList.add(new SortedProduct(product,1));
                System.out.println(frequentlyPurchasedSortedProductList.getLast().product.getName() + "Purchased "+ frequentlyPurchasedSortedProductList.getLast().purchasedTimes + " times");
            }
            else
            {
                for (SortedProduct sortedProduct : frequentlyPurchasedSortedProductList) {

                    if(sortedProduct.product == product)
                    {
                        sortedProduct.purchasedTimes ++;
                        System.out.println(sortedProduct.product.getName()+ " now purchased "+ sortedProduct.purchasedTimes + " times");
                        break;
                    }
                }
                frequentlyPurchasedSortedProductList.add(new SortedProduct(product,1));

                System.out.println(frequentlyPurchasedSortedProductList.getLast().product.getName() + "Purchased "+ frequentlyPurchasedSortedProductList.getLast().purchasedTimes + " times");
            }
        }
        System.out.println("SortedSize:"+ frequentlyPurchasedSortedProductList.size());;

        for (SortedProduct sp : frequentlyPurchasedSortedProductList) {
            sortedMostPurchasedListToReturn.add(sp.product);
            //System.out.println(sp.product.getName());
        }
    }

    //Method for returning the list of the most frequently bought products in the store.
    public List<Product> getFrequentlyPurchasedSortedProductList() {
        return sortedMostPurchasedListToReturn;
    }

    //Method which is called to add products to the list of most purchased products list.
    public void addToMostPurchasedProducts(List<ShoppingItem> shoppingItemsList) {

        //System.out.println("new purchased items" +shoppingItemsList.toArray().length); **Avkommentera för att få antalet nya produkter köpta.**
        for (ShoppingItem shoppingItem : shoppingItemsList) {
            mostPurchasedProducts.add(shoppingItem.getProduct());
        }
        sortMostPurchasedProducts();
    }
}

