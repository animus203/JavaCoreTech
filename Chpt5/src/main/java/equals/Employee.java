package equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }

    //一个相对标准的equals实现
    public boolean equals(Object otherObject){
        //检测this与otherObject是否相等
        if (this == otherObject) return true;

        //检测otherObject是否为null
        if (otherObject == null) return false;

        //比较this与otherObject的类
        if (getClass() != otherObject.getClass()) return false;

        //将otherObject强转为相应类类型的变量
        Employee other = (Employee) otherObject;

        //根据相等性要求来比较字段，用==来比较基本字段，用Objects.equals来比较对象字段
        return Objects.equals(name, other.name) && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode(){
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
