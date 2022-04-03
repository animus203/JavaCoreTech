package arrayList;

import equals.Employee;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList staff = new ArrayList<Employee>();
        //ArrayList不是数组，不能用[]来添加/删除，需要add/set/get方法来添加删除
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12,15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10,1));
        staff.add(new Employee("Tony Tester", 4000, 1990, 3,15));

    }
}
