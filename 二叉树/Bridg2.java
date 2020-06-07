interface Tv{
    public void on();
    public void close();
    public void tuneChannel();
}

abstract class RemoteControl{
    protected Tv tv;
    RemoteControl(Tv t){
        this.tv=t;
    }

    public abstract void open();
    public abstract void off();
    public abstract void setChannel();
    public abstract void setTv(Tv t);
} 

class RCAtv implements Tv{
    public void on(){
        System.out.println("RCAtv on");
    }

    public void close(){
        System.out.println("RCAtv close");
    }

    public void tuneChannel(){
        System.out.println("RCAtv tune channel is changed");
    }
}

class Sonytv implements Tv{
    public void on(){
        System.out.println("RCAtv on");
    }

    public void close(){
        System.out.println("RCAtv close");
    }

    public void tuneChannel(){
        System.out.println("Sonytv tune channel is changed");
    }
}

class ChangHongtv implements Tv{
    public void on(){
        System.out.println("ChangHongtv on");
    }

    public void close(){
        System.out.println("ChangHongtv close");
    }

    public void tuneChannel(){
        System.out.println("ChangHongtv tune channel is changed");
    }
}

class ControlA extends RemoteControl{
    ControlA(Tv t){
        super(t);
        this.tv=t;
    }

    public void open(){
        System.out.println("ControlA open a Tv");
        this.tv.on();
    }

    public void off(){
        System.out.println("ControlA close a Tv");
        this.tv.close();
    }
    
    public void setChannel(){
        System.out.println("ControlA change a Tv's Channel");
        this.tv.tuneChannel();
    }

    public void setTv(Tv t){
        System.out.println("ControlA remote control a new TV");
        this.tv=t;
    }
}

class ControlB extends RemoteControl{
    ControlB(Tv t){
        super(t);
        this.tv=t;
    }

    public void open(){
        System.out.println("ControlB open a Tv");
        this.tv.on();
    }

    public void off(){
        System.out.println("ControlB close a Tv");
        this.tv.close();
    }
    
    public void setChannel(){
        System.out.println("ControlB change a Tv's Channel");
        this.tv.tuneChannel();
    }

    public void setTv(Tv t){
        System.out.println("ControlB remote control a new TV");
        this.tv=t;
    }
}


public class Bridge{
    public static void main(String[] args){
        RCAtv t1=new RCAtv();
        Sonytv t2=new Sonytv();
        ChangHongtv t3=new ChangHongtv();
        RemoteControl c1=new ControlA(t1);
        RemoteControl c2=new ControlB(t2);
        c1.open();
        c1.setChannel();
        c1.off();
        c2.open();
        c2.setChannel();
        c2.setTv(t3);
        c2.setChannel();
        c2.off();
    }
}