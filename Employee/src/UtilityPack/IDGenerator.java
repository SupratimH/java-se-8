package UtilityPack;

public class IDGenerator {
    private static int empUniqueID = 0;

    private IDGenerator() {}

    public static int generateID() {
        return ++empUniqueID;
    }
}
