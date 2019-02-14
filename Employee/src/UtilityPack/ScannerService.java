package UtilityPack;

import java.util.Scanner;

public class ScannerService {
    private static Scanner scanner = null;

    private ScannerService() {}

    public static Scanner createScanner() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }

    public static void closeScanner() {
        if (scanner != null)
            scanner.close();
    }
}
