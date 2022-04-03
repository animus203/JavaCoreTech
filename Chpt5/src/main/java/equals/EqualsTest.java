package equals;

public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12,15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12,15);
        Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

        //true, ==对比的是值，也就是两个alice的地址值
        System.out.println("alice1 == alice2: " + (alice1 == alice2));

        //false，虽然内容一样，但地址不一样，所以false
        System.out.println("alice1 == alice3: " + (alice1 == alice3));

        //true，因为是自实现的equals.
        //Object自带的equals与==相同，但这里的是Employee中重写的equals
        System.out.println("alice1.equals(alice3): " + (alice1.equals(alice3)));
        System.out.println("alice1.equals(bob): " + (alice1.equals(bob)));

        System.out.println("bob.toString(): "+bob.toString());

        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15) ;
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15) ;
        boss.setBonus(5000);
        System.out.println("boss.toString(): "+ boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        System.out.println("alice1.hashCode(): "+ alice1.hashCode());
        System.out.println("alice3.hashCode(): "+ alice3.hashCode());
        System.out.println("bob.hashCode(): "+ bob.hashCode());
        System.out.println("carl.hashCode(): "+ carl.hashCode());
    }
}
