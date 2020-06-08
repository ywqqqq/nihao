interface Duck{
    abstract void quack();
    abstract void duckfly();
}

abstract class Turkey{
    abstract void gobble();
    abstract void fly();
}

class WildTurkey extends Turkey{
    public void gobble(){
        System.out.println("Wild Turkey gobble\n");
    }

    public void fly(){
        System.out.println("Wild Turkey fly a distance\n");
    }
}
    
class MallardDuck implements Duck{
    public void quack(){
        System.out.println("Mallard Duck quack\n");
    }

    public void duckfly(){
        System.out.println("Mallard Duck fly\n");
    }
}

class TurkeyAdapter implements Duck{
    private Turkey mturkey;

    TurkeyAdapter(Turkey mturkey){
        this.mturkey=mturkey;
    }

    public void quack(){
        System.out.println("Mallard Duck quack\n");
        this.mturkey.gobble();
    }

    public void duckfly(){
        System.out.println("Mallard Duck fly\n");
        for(int i=0;i<5;i++){
            this.mturkey.fly();
        }
    }
}

public class TurkeytoDuck{
    public static void main(String[] args){
        WildTurkey wildTurkey=new WildTurkey();
        wildTurkey.gobble();
        wildTurkey.fly();
        TurkeyAdapter adapter=new TurkeyAdapter(wildTurkey);
        adapter.quack();
        adapter.duckfly();
    }
}