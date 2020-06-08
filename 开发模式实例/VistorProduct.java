import java.util.ArrayList;
import java.util.List;

abstract class Visitor{
    private String id;
    private String name;

    public Visitor(String id,String name){
        this.id=id;
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public abstract void visit (Fruit f);
    public abstract void visit (Book b);
    public abstract void visit (Cloth c);
}

class Customer extends Visitor{
    public Customer(String id,String name){
        super(id,name);
        System.out.println("customer  "+name+"  look the list");
        System.out.println("   Name   Price");
        System.out.println("---------------");
    }

    public void visit(Fruit f){
        System.out.println("   "+f.getName()+"   "+f.getPrice());
    }

    public void visit(Book b){
        System.out.println("   "+b.getName()+"   "+b.getPrice());
    }

    public void visit(Cloth c){
        System.out.println("   "+c.getName()+"   "+c.getPrice());
    }
}

class SalesMan extends Visitor{
     public SalesMan(String id,String name){
        super(id,name);
        System.out.println("salesman "+name+"  look the list");
        System.out.println("   Id   Name   Price");
        System.out.println("--------------------");
    }

    public void visit(Fruit f){
        System.out.println("   "+f.getId()+"   "+f.getName()+"   "+f.getPrice());
    }

    public void visit(Book b){
        System.out.println("   "+b.getId()+"   "+b.getName()+"   "+b.getPrice());
    }

    public void visit(Cloth c){
        System.out.println("   "+c.getId()+"   "+c.getName()+"   "+c.getPrice());
    }
}

abstract class Product{

    protected int id;
    protected String name;
    private static int numbers = 0;
    protected double price;

    public Product(String name,double price){
        this.id=numbers++;
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public double getPrice(){
        return price;
    }
    
    public abstract void accept(Visitor v);
}

class Fruit extends Product{

    public Fruit(String name,double price){
        super(name,price);
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

class Book extends Product{

    public Book(String name,double price){
        super(name,price);
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

class Cloth extends Product{

    public Cloth(String name,double price){
        super(name,price);
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

class Shop{

    private List<Product> productList;

    public Shop(){
        productList=new ArrayList<Product>();
        init();
    }

    public void init(){
        ArrayList<Product> cart1=new ArrayList<Product>();
        Fruit f1=new Fruit("banana",10.0);
        Fruit f2=new Fruit("apple",8.88);
        Cloth c1=new Cloth("T shit",89);
        Cloth c2=new Cloth("Sweter",199);
        Book b1=new Book("book1",55);
        cart1.add(f1);
        cart1.add(f2);
        cart1.add(b1);
        cart1.add(c1);
        this.productList.addAll(cart1);
    }

    public List<Product> getProductList()
   {
      return productList;
   }
}

public class VistorProduct{
    public static void main(String[] args){
        Shop shop=new Shop();
        List<Product> productList=shop.getProductList();
        Customer customer=new Customer("A1","xuxuxu");
        for(Product product:productList){
            product.accept(customer);
        }
        SalesMan salesman=new SalesMan("B1","ywqqq");
        for(Product product:productList){
            product.accept(salesman);
        }
    }
}