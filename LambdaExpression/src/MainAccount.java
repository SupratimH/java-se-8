import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class MainAccount {

    public static void main(String [] agrs) {

        ArrayList<Account> accountList = new ArrayList<>();

        accountList.add(new Account("Savings", 10000));
        accountList.add(new Account("Current", 12000));
        accountList.add(new Account("Current", 8000));
        accountList.add(new Account("Savings", 33000));

        Test test = new Test();
        //test.display(accountList);
        //test.statistics(accountList);
        //test.filter(accountList);
        test.sort(accountList);

    }
}

class Test {

    void display(ArrayList<Account> accountList) {
        System.out.println("==== Traditional display ====");
        for (Account a : accountList) {
            a.dispAcctDetails();
        }
        System.out.println("==== Using lambda ForEach ====");
        accountList.forEach(a -> a.dispAcctDetails());
        System.out.println("==== Using lambda ForEach - toString ====");
        accountList.forEach(a -> System.out.println(a));
    }

    void statistics(ArrayList<Account> accountList) {
        accountList.stream().map(a->a.getAcctBal()+100)
                .forEach(bal -> System.out.println("New Balance = " + bal));

        System.out.println("Total number of records = " + accountList.stream().count());

        IntSummaryStatistics s = accountList.stream().mapToInt(a->a.getAcctBal()).summaryStatistics();
        System.out.println("Count:"+s.getCount());
        System.out.println("Average:"+s.getAverage());
        System.out.println("Max:"+s.getMax());
        System.out.println("Min:"+s.getMin());
        System.out.println("Sum:"+s.getSum());
    }

    void filter(ArrayList<Account> accountList) {
        accountList.stream().filter(a -> a.getAcctBal() > 9000).forEach(a -> a.dispAcctDetails());

        accountList.stream().filter(a -> a.getAcctType().startsWith("S")).forEach(a -> a.dispAcctDetails());
    }

    void sort(ArrayList<Account> accountList) {
        accountList.sort((a1, a2) -> a1.compareTo(a2));
        accountList.forEach(a -> System.out.println(a));

        //accountList.stream().sorted().map(a1->a1.getAcctBal()).collect(Collectors.toList());
        //accountList.forEach(a -> System.out.println(a));
    }
}




