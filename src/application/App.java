package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List <Product> list = new ArrayList<>();
        Product product = new Product();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Product #" + (i+1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if(ch == 'c'){
                product = new Product(name, price);
            }
            if(ch == 'i'){
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                product = new ImportedProduct(name, price, customsFee);
            }
            else if(ch == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                product = new UsedProduct(name, price, sdf.parse(sc.next()));
            }
            list.add(product);
        }
        sc.close();

        System.out.println();
        System.out.println("PRICE TAGS:");
        for(Product p: list){
            System.out.println(p.priceTag());
        }
    }
}
