Here's a `README.md` file for your Disk Usage Calculator Java code:

```markdown
# Disk Usage Calculator

This repository contains a Java program that calculates the total size of a directory and its subdirectories. The program uses recursion to navigate through all subdirectories and sum the sizes of all files.

## Features

- Calculate the total size of a specified directory.
- Recursively include the sizes of all subdirectories and their files.

## Usage

1. **Compile the program:**
   ```sh
   javac DiskUsageCalculator.java
   ```

2. **Run the program:**
   ```sh
   java DiskUsageCalculator
   ```

3. **Specify the directory:**
   - By default, the program is set to calculate the size of the `M:/Ali Aziz` directory. You can change this path in the `main` method.

## Code Overview

### Main Class

The main class `DiskUsageCalculator` contains the following methods:

- `public static long calculateDirectorySize(File directory)`: Recursively calculates the total size of the specified directory, including all subdirectories and their files.

- `public static void main(String[] args)`: The entry point of the program. It specifies the directory to be calculated and prints the total size.

### Example Usage

```java
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
```

## Explanation

Recursion is suitable for this task because it allows for handling directories of any depth without requiring complex nested loops. The method treats every subdirectory the same way as the main directory, simplifying the code and ensuring all files and subdirectories are included in the size calculation.
