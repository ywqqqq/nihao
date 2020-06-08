abstract class Factory{
	abstract Vehicle MakeVehicle();
	abstract Electronics MakeElectronics();
}
class FactoryA extends Factory{

	public Vehicle MakeVehicle(){
		return new Car();
	}
	public Electronics MakeElectronics(){
		return new Computer();
	}
}
class FactoryB extends Factory{
	public Vehicle MakeVehicle(){
		return new Suv();
	}
	public Electronics MakeElectronics(){
		return new Phone();
	}
}
class FactoryC extends Factory{
	public Vehicle MakeVehicle(){
		return new Trunk();
	}
	public Electronics MakeElectronics(){
		return new Tv();
	}
}
abstract class Vehicle{
	abstract String getBrand();
	abstract void start();
	abstract void stop();
}
class Trunk extends Vehicle{
	private String brand;
	Trunk(String brand){
		this.brand = brand;
	}
	Trunk(){}
	public String getBrand(){
		return this.brand;
	}
	public void start(){
		System.out.println("start making Trunk");
	}
	public void stop(){
		System.out.println("Trunk finshed");
	}
}
class Suv extends Vehicle{
	private String brand;
	Suv(String brand){
		this.brand = brand;
	}
	Suv(){}
	public String getBrand(){
		return this.brand;
	}
	public void start(){
		System.out.println("start making Suv");
	}
	public void stop(){
		System.out.println("Suv finshed");
	}
}
class Car extends Vehicle{
	private String brand;
	Car(String brand){
		this.brand = brand;
	}
	Car(){}
	public String getBrand(){
		return this.brand;
	}
	public void start(){
		System.out.println("start making Car");
	}
	public void stop(){
		System.out.println("Car finshed");
	}
}
abstract class Electronics{
	abstract String getBrand();
	abstract double getPrice();
}
class Tv extends Electronics{
	String brand;
	double price;
	Tv(){}
	Tv(String b,double p){
		this.brand = b;
		this.price = p;
	}
	public String getBrand(){
		return this.brand;
	}
	public double getPrice(){
		return this.price;
	}
}
class Phone extends Electronics{
	String brand;
	double price;
	Phone(){}
	Phone(String b,double p){
		this.brand = b;
		this.price = p;
	}
	public String getBrand(){
		return this.brand;
	}
	public double getPrice(){
		return this.price;
	}
}
class Computer extends Electronics{
	String brand;
	double price;
	Computer(){}
	Computer(String b,double p){
		this.brand = b;
		this.price = p;
	}
	public String getBrand(){
		return this.brand;
	}
	public double getPrice(){
		return this.price;
	}
}
class Machine{
	private Factory fab = null;
	private Electronics ele = null;
	private Vehicle veh = null;
	public void setFab(Factory fab){
		this.fab = fab;
	}
	public void proElectronics(){
		ele = fab.MakeElectronics();
		ele.getBrand();
	}
	public void proVehicle(){
		veh = fab.MakeVehicle();
		veh.start();
		veh.stop();
	}
}
class AbstractFactory{
	static Machine machine = new Machine();
	static Machine machine2 = new Machine();
	public static void main(String[] args) {
		machine.setFab(new FactoryA());
		machine.proElectronics();
		System.out.println();
		machine.proVehicle();
		machine2.setFab(new FactoryB());
		machine2.proElectronics();
	}
}