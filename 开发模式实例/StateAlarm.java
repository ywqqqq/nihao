interface IAlarmState{
    public void personDetect();
}

class AlarmYes implements IAlarmState{
    public void personDetect(){
        System.out.println("Ring Ring");
    }
}

class AlarmNo implements IAlarmState{
    public void personDetect(){
        System.out.println("No Ring");
    }
}

class AlarmDevice{
    IAlarmState yes=new AlarmYes();
    IAlarmState no=new AlarmNo();
    IAlarmState state=null;

    public AlarmDevice(){
        state=no;
    }

    private void changeState(IAlarmState newstate){
        state=newstate;
    }

    public void Connect(){
        changeState(yes);
    }

    public void DisConnect(){
        changeState(no);
    }

    public void personDetect(){
        state.personDetect();
    }
}

public class StateAlarm{
    public static void main(String[] args){
        AlarmDevice a=new AlarmDevice();
        System.out.println("work");
        System.out.println("Alarm Device disable...");
        a.DisConnect();
        System.out.println("Detect person");
        a.personDetect();
        System.out.println("no work");
        System.out.println("Alarm Device sable...");
        a.Connect();
        System.out.println("Detect person");
        a.personDetect();
    }
}