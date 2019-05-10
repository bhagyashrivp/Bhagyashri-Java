import java.util.Arrays;


//Hello There...I am Shri
//Trying sumthing
public class Test{
	
	public static void main(String[] args) {
		
		EmpService service=new EmpServiceImp();
		
		Employee e1=new Employee(1, "Shri", "Pune", 24, 78000);
		Employee e2=new Employee(2, "Anu", "Mumbai", 30, 67000);
		Employee e3=new Employee();
		System.out.println("---Add Employee-----");
		int id=service.addEmployee(e1);
		int id1=service.addEmployee(e2);
		System.out.println("Id1:"+id);
		System.out.println("Id2:"+id1);
		
		System.out.println("-----Get All Employee-----");
		Employee e[]=service.getAllEmployee();
		System.out.println(Arrays.toString(e));
		
		System.out.println("-----Get By Id-----");
		System.out.println(service.getEmployee(2));
		
		System.out.println("----Update Employee----");
		e2.setEmpName("Zoya");
		e2.setEmpAddress("Pune");
		Employee newEmp=service.updateEmployee(e2);
		System.out.println("Updated Employee:"+newEmp);
		
		System.out.println("-----Delete Employee------");
		boolean bool=service.deleteEmployee(2);
		System.out.println(bool);
		
		System.out.println("----Get All Employee-----");
		System.out.println(Arrays.toString(e));
	}
}

interface EmpService
{
	public int addEmployee(Employee e);
	public boolean deleteEmployee(int empId);
	public Employee updateEmployee(Employee e);
	public Employee getEmployee(int empId);
	public Employee[] getAllEmployee();
}

class EmpServiceImp implements EmpService{

	Employee[] listOfEmployees=new Employee[10];
	int index=0;
	@Override
	public int addEmployee(Employee e) {
		
		if(e==null || index>=10)
		{
			System.out.println("Can not add new employee");
			return 0;
		}
		listOfEmployees[index]=e;
		index++;
		return e.getEmpId();
	}

	@Override
	public boolean deleteEmployee(int empId) {

		Employee e=getEmployee(empId);
		if(e==null)
		{
			System.out.println("empId does not exist...cannot delete the employee");
			return false;
		}
		for(int i=0;i<index;i++)
		{
			if(empId==e.getEmpId())
			{
				e.setEmpId(-1);
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee updateEmployee(Employee e) {

		for(int i=0;i<index;i++)
		{
			Employee e2=listOfEmployees[i];
			if(e2.getEmpId()==e.getEmpId())
			{
				e2.setAge(e.getAge());
				e2.setEmpAddress(e.getEmpAddress());
				e2.setEmpName(e.getEmpName());
				e2.setEmpSalary(e.getEmpSalary());
				return e2;
			}
		}
		return null;
	}

	@Override
	public Employee getEmployee(int empId) {
		if(empId<=0)
		{
			System.out.println("Employee Id can not be negtive");
			return null;
		}
		for(int i=0;i<index;i++)
		{
			Employee e1=listOfEmployees[i];
			if(empId==e1.getEmpId())
			{
				return e1;
			}
		}
		return null;
	}

	@Override
	public Employee[] getAllEmployee() {

		return listOfEmployees;
	}
	
}
class Employee{
	private int empId;
	private String empName;
	private String empAddress;
	private int age;
	private double empSalary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public Employee(int empId, String empName, String empAddress, int age,
			double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.age = age;
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empAddress=" + empAddress + ", age=" + age
				+ ", empSalary=" + empSalary + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
