interface IDate{
    public void dateOutput(int day,int month,int year);
}

class Date{
    private IDate format=null;
    private int day,month,year=0;
    Date(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public void setFormat(IDate format){
        this.format=format;
    }

    public void output(){
        this.format.dateOutput(day,month,year);
    }
}

class EuroFormat implements IDate{
    public void dateOutput(int day,int month,int year){
        System.out.println("Euro Format:"+(day>9?day:"0"+day)+"."+(month>9?month:"0"+month)+"."+year);
    }
}

class AmericaFormat implements IDate{
    public void dateOutput(int day,int month,int year){
        System.out.println("America Format:"+(month>9?month:"0"+month)+"."+(day>9?day:"0"+day)+"."+year);
    }
}

public class StrategyDate{
    public static void main(String[] args){
        Date date=new Date(21,9,1985);
        date.setFormat(new EuroFormat());
        date.output();
        date.setFormat(new AmericaFormat());
        date.output();
    }
}
