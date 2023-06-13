package org.example;

public class EmagProduct {
    private String url;
    private String image;
    private String name;
    private String price;

    //Getters

    public String getUrl(){
        return url;
    }

    public String getImage(){
        return image;
    }

    public  String getName(){
        return name;
    }

    public  String getPrice(){
        return  price;
    }

    //Setters

    public void setUrl(String newUrl){
        this.url = newUrl;
    }

    public void setImage(String newImage){
        this.image = newImage;
    }

    public  void setName(String newName){
        this.name = newName;
    }

    public  void setPrice(String newPrice){
        this.price = newPrice;
    }

    @Override
    public  String toString(){
        return "{ \n \"productUrl\":\"" + url + "\" , \n"
                + "\"productImageUrl\": \"" + image + "\" , \n"
                + "\"productName \":\"" + name + "\",\n"
                + "\"productPrice \":\"" + price + "\" \n}\n";
    }
}
