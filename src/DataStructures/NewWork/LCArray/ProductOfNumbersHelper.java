package DataStructures.NewWork.LCArray;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ProductOfNumbersHelper {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);

        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));
    }
}


class ProductOfNumbers {

    List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {

        if(num == 0){
            products = new ArrayList<>();
            products.add(1);
        }else{
            products.add(products.get(products.size()-1) * num);
        }
    }

    public int getProduct(int k) {
        int size = products.size();
        int idx = size - 1 - k;
        return k < size ? products.get(size - 1) / products.get(idx) : 0;
    }
}