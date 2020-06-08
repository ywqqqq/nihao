import java.util.ArrayList;

interface IObserver{
    public String getName();
    public void setName(String name);
    public void beAttacked(Ally a);
}

class Player implements IObserver{
    private String name;

    Player(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public void beAttacked(Ally a){
        System.out.println(this.getName()+" be attacked "+a.getHurt()+" hurt");
    }
}

interface IAlly{
    public void join(Player b);
    public void quit(Player b);
    public void notify(int n);    
}

class Ally implements IAlly{
    private ArrayList<Player> players=new ArrayList<Player>();

    private int hurt;

    public int getHurt(){
        return this.hurt;
    }

    public void join(Player b){
        players.add(b);    
    }

    public void quit(Player b){
        players.remove(b);
    }

    public void notify(int n){
        this.hurt=n;
        for(IObserver i:players){
            i.beAttacked(this);
        }
    }

    public int getState(){
        return hurt;
    }
}

public class ObserverGame{
    public static void main(String[] args){
        Player p1=new Player("John");
        Player p2=new Player("Mike");
        Ally a=new Ally();
        a.join(p1);
        a.join(p2);
        a.notify(2);
        a.join(p1);
        a.notify(4);
    }
}


