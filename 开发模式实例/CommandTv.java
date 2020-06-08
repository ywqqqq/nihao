interface Command{
    public void execute();
}

class Tv{
    public void opentv(){
        System.out.println("Tv open");
    }

    public void closetv(){
        System.out.println("Tv close");
    }

    public void turnchannel(){
        System.out.println("Tv turn channel");
    }
}

class Open implements Command{
    private Tv tv;

    public Open(Tv tv){
        this.tv=tv;
    }

    public void execute(){
        tv.opentv();
    }
}

class Close implements Command{
    private Tv tv;

    public Close(Tv tv){
        this.tv=tv;
    }

    public void execute(){
        tv.closetv();
    }
}

class TurnChannel implements Command{
    private Tv tv;

    public TurnChannel(Tv tv){
        this.tv=tv;
    }

    public void execute(){
        tv.turnchannel();
    }
}

class RemoteControl{
    private Command command;

    public void setCommand(Command command){
        this.command=command;
    }

    public void change(){
        command.execute();
    }
}

public class CommandTv{
    public static void main(String[] args){
        RemoteControl rc=new RemoteControl();
        Tv tv=new Tv();
        Command open=new Open(tv);
        Command close=new Close(tv);
        Command turnchannel=new TurnChannel(tv);
        rc.setCommand(open);
        rc.change();
        rc.setCommand(close);
        rc.change();
        rc.setCommand(turnchannel);
        rc.change();
    }
}
