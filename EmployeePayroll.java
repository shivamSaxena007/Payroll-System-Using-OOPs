package Project;

import java.util.ArrayList;

abstract class Employee{
     private String name;
     private int id;

    
     public Employee(String name,int id){   //constructor
        this.name=name;
        this.id=id;
     }

     public String getName(){ // method encapsulation ka use
        return name;
     }
     public int getid(){  //method encapsulation ka use 
        return id;
     }
    

   public abstract double calculatesalary();// abstract method -iske andar body ko implement nhi karte  jo {} ke andar kiya jata hai   
   @Override
   public String toString(){
    return "Employee [name="+name+",id="+id+",salary="+calculatesalary()+"]";
   }  
}


class FulltimeEmployee extends Employee{

     private double monthlysalary;  // 

     public FulltimeEmployee(String name,int id,double monthlysalary){ // fulltimeEmployee ka constructor
           super(name, id); // employee jo iski parent class hai uska constructor call karne ke liye super key word ka use
           this.monthlysalary=monthlysalary;
     }
     @Override

     public double calculatesalary(){
      return monthlysalary;
     }
   
}


class partimeEmployee extends Employee{
    private int hours_work;
    private double hourly_rate;

    public partimeEmployee(String name,int id,int hours_work,double hourly_rate){
      super(name,id);
      this.hours_work=hours_work;
      this.hourly_rate=hourly_rate;
    }
    @Override
    public double calculatesalary(){  // polymorphism
      return hours_work*hourly_rate;
    }
}


 class payrollsystem{
   private ArrayList<Employee>employeeList;
      
   public payrollsystem(){  // constructor of payrollsystem
      employeeList=new ArrayList<>();
   }

   public void addemployee(Employee employee){ // method to add employee
   employeeList.add(employee);
   }

   public void removeemployee(int id){  // method to remove employee
       Employee employetoremove=null;
       for(Employee employee:employeeList){
         if(employee.getid()==id){
            employetoremove=employee;
            break;
         }
       }
       if (employetoremove!=null){
         employeeList.remove(employetoremove);
       }
   }

     public void display(){  // method to remove employee
      for(Employee employee:employeeList){
        System.out.println(employee);
      }
     }
 }

public class EmployeePayroll {
    public static void main(String[] args) {
       payrollsystem payrollsystem=new payrollsystem();
       FulltimeEmployee emp1=new FulltimeEmployee("Vikas", 101, 70000);
       FulltimeEmployee emp2=new FulltimeEmployee("Shivam", 102, 80000);
       FulltimeEmployee emp3=new FulltimeEmployee("Divyanshu", 103, 45000);
       FulltimeEmployee emp4=new FulltimeEmployee("Ajay", 104, 55000);
       partimeEmployee emp5=new partimeEmployee("vishal", 105, 40, 1000); 

       payrollsystem.addemployee(emp1);
       payrollsystem.addemployee(emp2);
       payrollsystem.addemployee(emp3);
       payrollsystem.addemployee(emp4);
       payrollsystem.addemployee(emp5);
       System.out.println("INTITAL EMPLOYEE DETAILS: ");
       payrollsystem.display();
       System.out.println("REMOVING EMPLOYEES: ");
       payrollsystem.removeemployee(105);
       System.out.println("REMAINING  EMPLOYEE DETAILS: ");
       payrollsystem.display();
    }
   }
