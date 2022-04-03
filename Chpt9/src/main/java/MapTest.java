import java.util.HashMap;

//Map：键值对存储
public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Harry Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5524", new Employee("Francesca Cruz"));

        System.out.println(staff);

        staff.remove("567-24-2546");

        staff.put("456-62-5524", new Employee("Francesca Miller"));

        System.out.println(staff.get("157-62-7935"));
    }
}
