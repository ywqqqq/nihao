class Employee{
    private String name;
    Employee(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
}

class Research{
    private Employee em;
    private String project;

    Research(String project){
        this.project=project;
    }

    public String getDepartment(){
        return "Research";
    }

    public void printProject(){
        System.out.println("项目研究者是"+this.em.getName()+"  项目名称是"+this.project);
    }

    public Employee getEmployee(){
        return this.em;
    }

    public void setEmployee(Employee e){
        this.em=e;
    }
}

class Sale{
    private Employee em;
    private int sales;
    Sale(int sales){
        this.sales=sales;
    }
    public String getDepartment(){
        return "saler";
    }

    public void printSale(){
        System.out.println("销售是"+em.getName()+"  销售额"+this.sales);
    }

    public Employee getEmployee(){
        return this.em;
    }

    public void setEmployee(Employee e){
        this.em=e;
    }
}

class Manager{
    private Employee em;
    private String duty;
    Manager(String duty){
        this.duty=duty;
    }
    public String getDepartment(){
        return "Manager";
    }

    public void printManage(){
        System.out.println("项目管理者是"+em.getName()+"  项目经理是"+this.duty);
    }

    public Employee getEmployee(){
        return this.em;
    }

    public void setEmployee(Employee e){
        this.em=e;
    }
}

public class RoleTest{
    public static void main(String[] args){
        Employee p1=new Employee("徐献博");
        Employee p2=new Employee("翁辰欣");
        Research r1=new Research("Product 1.0");
        Research r2=new Research("Product 2.0");
        r1.setEmployee(p1);
        r2.setEmployee(p2);
        System.out.println("\n公司现在承接的项目");
        r1.printProject();
        r1.printProject();
        System.out.println("\n接受额外的销售任务");
        Sale s1=new Sale(15000);
        s1.setEmployee(p2);
        System.out.println("\n李飞在销售部");
        s1.printSale();
        Manager m1=new Manager("袁文强");
        m1.setEmployee(p1);
        m1.printManage();

    }
}