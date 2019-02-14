package ConsumerPack;
import OrgPack.*;
import UtilityPack.ScannerService;

import java.util.Scanner;

public class Consumer {

    public static void main(String [] args) {
        Organization org = Organization.createOrganization();

/*        System.out.println("OPTIONS:");
        System.out.println("1. Add an Employee");
        System.out.println("2. Display Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Delete an Employee");
        System.out.println("5. Exit");

        Scanner scanner = ScannerService.createScanner();
        int input = scanner.nextInt();
        while (input != 5) {

            switch (input) {
                case 1:
                    org.addEmployeeRecord(scanner.next(), scanner.nextFloat(), scanner.next());
                    break;
                case 2:
                    org.displayEmployeeRecord();
                    break;
                case 3:
                    org.searchEmployeeRecord(scanner.next());
                    break;
                case 4:
                    org.deleteEmployeeRecord(scanner.nextInt());
                    break;
                case 5:
                    break;
            }

        }

        ScannerService.closeScanner();*/

        org.addEmployeeRecord("Supratim Haldar", 100, "SPC");
        org.addEmployeeRecord("Supratim Haldar", 1000, "CTM");
        org.displayEmployeeRecord();
        org.searchEmployeeRecord("SPC");
        org.deleteEmployeeRecord(1);
        org.displayEmployeeRecord();

    }
}
