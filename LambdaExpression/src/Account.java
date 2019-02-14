import java.util.*;

public class Account implements Comparable
{
    String AcctType;
    int AcctBal;

    public String getAcctType() {
        return AcctType;
    }

    public int getAcctBal() {
        return AcctBal;
    }

    public void setAcctBal(int acctBal) {
        AcctBal = acctBal;
    }

    Account(String type,int bal)
    {
        AcctType = type;
        AcctBal = bal;
    }

    void dispAcctDetails()
    {
        System.out.println(AcctType+"\t"+AcctBal);
    }

    public String toString()
    {
        return AcctType+"\t"+AcctBal;
    }

    @Override
    public int compareTo(Object arg0) {

        Account a = (Account)arg0;
        if(AcctBal > a.AcctBal)
            return 1;//no swap
        else
            return -1;//swap

    }

}
