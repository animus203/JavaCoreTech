package threads;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    /**
     * 构造器
     * @param n  账户数目
     * @param initialBalance  账户初始金额
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * 账户之间转账
     * @param from  从哪里转出
     * @param to  转到哪里
     * @param amount  数目
     */
    public void transfer(int from, int to, double amount){
        if (accounts[from] < amount) return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
    }

    /**
     * 得到所有账户存款之和
     * @return
     */
    public double getTotalBalance(){
        double sum = 0;
        for (double a: accounts){
            sum += a;
        }
        return sum;
    }

    /**
     * 得到账户数目
     * @return
     */
    public int size(){
        return accounts.length;
    }

}
