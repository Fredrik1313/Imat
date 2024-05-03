package imat;

import se.chalmers.cse.dat216.project.Product;

public class SortedProduct {
    public  Product product;
    public int purchasedTimes;

    public SortedProduct(Product productToAdd, int purchasedTimesNumber){
        product = productToAdd;
        purchasedTimes = purchasedTimesNumber;

    }
}
