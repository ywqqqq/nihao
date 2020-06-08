class User{
    private String id;
    private String name;
    private int age;

	public User(String id,String name,int age){
		this.id=id;
		this.name=name;
		this.id=id;
	}

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}

class Guest{
	private User user;
	private String type;
	
	public Guest(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void printInfo(){
		System.out.println("Guest is  "+user.getName()+"gusest type is  "+this.type);
	}
}

class Dba{
	private User user;
	private String database;
	private boolean database_operation;
	
	public Dba(String database, boolean database_operation) {
		this.database = database;
		this.database_operation = database_operation;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public void printInfo(){
		System.out.println("Database administrator is  "+user.getName()+"  database is  "+this.database);
		if(database_operation)
			System.out.println("An operation is completed by  "+user.getName());
	}
}

class Administrator{
	private User user;
	private String system;
	private boolean system_operation;
	
	public Administrator(String system, boolean system_operation) {
		this.system = system;
		this.system_operation = system_operation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}
	
	public void printInfo(){
		System.out.println("Administrator is  "+user.getName()+"  system is  "+this.system);
		if(system_operation)
			System.out.println("An operation is completed by  "+user.getName());
	}
}


public class RoleUser{
	public static void main(String[] args) {
		User u1=new User("A101","ywqqq",18);
		User u2=new User("A102","xxb",18);
		User u3=new User("A103","admin",18);
		Guest guest=new Guest("normal");
		Administrator administrator=new Administrator("win10",true);
		Dba dba=new Dba("mysql",true);
		guest.setUser(u1);
		guest.printInfo();
		administrator.setUser(u2);
		administrator.printInfo();
		dba.setUser(u3);
		dba.printInfo();
	}
}
