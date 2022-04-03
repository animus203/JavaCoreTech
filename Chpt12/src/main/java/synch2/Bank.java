package synch2;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException{

            while(accounts[from] < amount){
                //使用同步后，通过wait方法来阻塞线程
                wait();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total balance: %10.2f%n", getTotalBalance());
            //提取后记得释放所有阻塞的线程
            notifyAll();
    }

    /**
     * 得到所有账户存款之和
     * @return
     */
    public synchronized double getTotalBalance(){
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
