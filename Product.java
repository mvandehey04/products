/* 
* Purpose: products for a store
* Author: Madeline Vande Hey
* Date: 4/26/22
*/
public class Product {
    private String name;
    private int num;
    private double price;
    private int quantity;

    public Product(String name, int num, double price, int quantity){
        this.name = name;
        this.num = num;
        this.price = price;
        this.quantity = quantity;
    }

    // get and set
    // name
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }

    // number
    public int getNum(){
        return num;
    }
    public void setNum(int n){
        num = n;
    }

    // price
    public double getPrice(){
        return price;
    }
    public void setPrice(double p){
        price = p;
    }

    // quantity
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int q){
        quantity = q;
    }

    public String toString(){
        return String.format("%-22s %-12d %-14.2f %-15d", name, num, price, quantity);
    }
}
