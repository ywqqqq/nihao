import java.util.HashMap;

class User{
    private int id;
    private String name;

    public void setid(int id){
        this.id=id;
    }

    public int getid(){
        return this.id;
    }

    public void setname(String name){
        this.name=name;
    }

    public String getname(){
        return this.name;
    }

    public User(int id,String name){
        this.id=id;
        this.name=name;
    }
}

class Shopping_cart{
    private int id;

    public void setid(int id){
        this.id=id;
    }

    public int getid(){
        return this.id;
    }

    public Shopping_cart(int id){
        this.id=id;
    }
}

public class HashMapTest{

    public static void main(String[] args){
        User u1=new User(1,"123");
        User u2=new User(2,"124");
        Shopping_cart s1=new Shopping_cart(1);
        Shopping_cart s2=new Shopping_cart(2);
        HashMap<User,Shopping_cart> hsp=new HashMap<User,Shopping_cart>();
        hsp.put(u1,s1);
        hsp.put(u2,s2);
        System.out.println("User1's shopping_cart has"+hsp.get(u1).getid());
        System.out.println("User2's shopping_cart has"+hsp.get(u2).getid());
    }
}

