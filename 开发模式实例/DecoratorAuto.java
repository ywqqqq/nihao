interface Auto{
    public void getdetail();
    public int cost();
}

class Convertible implements Auto{
    public void getdetail(){
        System.out.println("Convertible car");
    }

    public int cost(){
        return 100000;
    }
}

class Luxury implements Auto{
    public void getdetail(){
        System.out.println("Luxury car");
    }

    public int cost(){
        return 200000;
    }
}

abstract class Ausstattung implements Auto{
    protected Auto auto;
    public Ausstattung(Auto auto){
        this.auto=auto;
    }
}

class AirCondition extends Ausstattung{
    public AirCondition(Auto auto){
        super(auto);
    }

    public void getdetail(){
        auto.getdetail();
        System.out.println("add aircondition");
    }

    public int cost(){
        return this.auto.cost()+5000;
    }
}

class SafeBag extends Ausstattung{
    public SafeBag(Auto auto){
        super(auto);
    }

    public void getdetail(){
        auto.getdetail();
        System.out.println("add safe bag");
    }

    public int cost(){
        return this.auto.cost()+3000;
    }
}

class Navigation extends Ausstattung{
    public Navigation(Auto auto){
        super(auto);
    }

    public void getdetail(){
        auto.getdetail();
        System.out.println("add navigation");
    }

    public int cost(){
        return this.auto.cost()+7000;
    }
}

public class DecoratorAuto{
    public static void main(String[] args){
        Auto auto=new AirCondition(new Luxury());
        auto.getdetail();
        System.out.println("It cost "+auto.cost()+" RMB"); 

        auto=new Navigation(new SafeBag(auto));
        auto.getdetail();
        System.out.println("It cost "+auto.cost()+" RMB"); 

        auto=new Navigation(new SafeBag(new Convertible()));
        auto.getdetail();
        System.out.println("It cost "+auto.cost()+" RMB"); 
    }
}
