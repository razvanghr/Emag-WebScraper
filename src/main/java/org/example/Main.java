package org.example;

import org.jsoup.Jsoup;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Enter a page url: ");
        Scanner scanner = new Scanner(System.in);
        String pageUrl = scanner.nextLine();
        Document doc = null;


        try{
            //Fetching the target page
            doc = Jsoup.connect(pageUrl).get();
        }catch (IOException e) {
            System.out.println("The url is incorrect");
        }catch (IllegalArgumentException e){
            System.out.println("The supplied URL '" + pageUrl + "' is malformed. Make sure it is an absolute URL, and starts with 'http://' or 'https://'.");

        }

        if(doc !=null){
            Elements products = doc.select("div.card-item.card-standard.js-product-data");

            ArrayList<EmagProduct> EmagProducts = new ArrayList<>();


            for(Element product : products){
                EmagProduct emagProduct = new EmagProduct();

                emagProduct.setUrl(product.selectFirst("a.card-v2-title").attr("href"));
                emagProduct.setImage(product.selectFirst("img.w-100").attr("src"));
                emagProduct.setName(product.selectFirst("a.card-v2-title").text());
                emagProduct.setPrice(product.selectFirst("p.product-new-price").text());

                EmagProducts.add(emagProduct);
            }

            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter("output.json"));
                writer.write(EmagProducts.toString());
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }

            System.out.println("Process Finished....");
            System.out.println("Check the output.json file");
        }
    }
}