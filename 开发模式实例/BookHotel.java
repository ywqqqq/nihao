interface IHotelState{
    public void checkout();
    public void livein();
    public void book();
    public void cancel();
}

class Free implements IHotelState{

    public void checkout(){
        System.out.println("No Permission,the room is vacant");
    }

    public void cancel(){
        System.out.println("No Permission,the room is vacant");
    }

    public void livein(){
        System.out.println("Person live in the room");
    }

    public void book(){
        System.out.println("Person book the room");
    }
}

class CheckIn implements IHotelState{

    public void livein(){
        System.out.println("No Permission,the Room is occupied");
    }

    public void book(){
        System.out.println("No Permission,the Room is occupied");
    }

    public void cancel(){
        System.out.println("No Permission,the Room is occupied");
    }

    public void checkout(){
        System.out.println("Person check out the room");
    }
}

class Ordered implements IHotelState{

    public void checkout(){
        System.out.println("No Permission,the Room is booked");
    }

    public void book(){
        System.out.println("No Permission,the Room is booked");
    }

    public void livein(){
        System.out.println("Person live in the room");
    }

    public void cancel(){
        System.out.println("Person cancel the room's reservation");
    }
}

class Room{
    IHotelState free=new Free();
    IHotelState checkin=new CheckIn();
    IHotelState ordered=new Ordered();
    IHotelState state=null;

    public Room(){
        state=free;
    }

    private void changeState(IHotelState newstate){
        state=newstate;
    }

    public void checkout(){
        state.checkout();
        if(state==checkin){
            changeState(free);
        }
    }

    public void livein(){
        state.livein();
        if(state==free||state==ordered){  
            changeState(checkin);
        }
    }

    public void book(){
        state.book();
        if(state==free){
            changeState(ordered);
        }
    }

    public void cancel(){
        state.cancel();
        if(state==ordered){
            changeState(free);
        }
    }
}

public class BookHotel{
    public static void main(String[] args){
        Room room=new Room();
        room.livein();
        room.checkout();
        room.book();
        room.livein();
        room.book();
    }
}