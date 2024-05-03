package imat;

import se.chalmers.cse.dat216.project.Order;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.util.*;

public class iMatBackendController {
    private Map<String, Product> productMap = new HashMap<>();
    public List<Order> previousOrders = new ArrayList<>();
    public List<Order> savedOrders = new ArrayList<>();
    List<SortedProduct> FrequentlyPurchasedList = new ArrayList<>();
    List<Product> mostPurchasedProducts = new ArrayList<>();

    List<Product> sortedListToReturn = new ArrayList<>();
    //Function for sorting hte most purchased products in the store.
    private void sortMostPurchasedProducts() {
        mostPurchasedProducts.sort(Comparator.comparing(Product::getProductId));
        for (Product product : mostPurchasedProducts) {
            if(FrequentlyPurchasedList.isEmpty())
            {
                FrequentlyPurchasedList.add(new SortedProduct(product,1));
                System.out.println(FrequentlyPurchasedList.getLast().product.getName() + "Purchased "+ FrequentlyPurchasedList.getLast().purchasedTimes + " times");
            }
            else
            {
                for (SortedProduct sortedProduct : FrequentlyPurchasedList) {

                    if(sortedProduct.product == product)
                    {
                        sortedProduct.purchasedTimes ++;
                        System.out.println(sortedProduct.product.getName()+ " now purchased "+ sortedProduct.purchasedTimes + " times");
                        break;
                    }
                }
                FrequentlyPurchasedList.add(new SortedProduct(product,1));

                System.out.println(FrequentlyPurchasedList.getLast().product.getName() + "Purchased "+ FrequentlyPurchasedList.getLast().purchasedTimes + " times");
            }
        }
        System.out.println("SortedSize:"+ FrequentlyPurchasedList.size());;

        for (SortedProduct sp : FrequentlyPurchasedList) {
            sortedListToReturn.add(sp.product);
            //System.out.println(sp.product.getName());
        }
    }

    //Method for returning the list of the most frequently bought products in the store.
    public List<Product> getFrequentlyPurchasedList() {
        return sortedListToReturn;
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

