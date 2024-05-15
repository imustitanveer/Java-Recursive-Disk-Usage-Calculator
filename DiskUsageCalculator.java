import java.io.File;

public class DiskUsageCalculator {

    public static long calculateDirectorySize(File directory) {
        long totalSize = 0;

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        totalSize += calculateDirectorySize(file); // Recursively call calculateDirectorySize for subdirectories
                    } else {
                        totalSize += file.length(); // Add size of individual files
                    }
                }
            }
        }

        return totalSize;
    }

    public static void main(String[] args) {
        File directory = new File("M:/Ali Aziz");
        long totalSize = calculateDirectorySize(directory);
        System.out.println("Total size of directory: " + totalSize + " bytes");
    }
}

/* Recursion is suitable for this task because any directory depth can be used
 * and it simplifies the code, and treats every subdirectory the same way as
 * the main directory. This helps in avoiding nested loops.*/
