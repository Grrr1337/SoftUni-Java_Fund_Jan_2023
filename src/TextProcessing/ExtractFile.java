package TextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();
        String fileName = getFileName(filePath);
        String fileExtension = getFileExtension(filePath);
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }

    public static String getFileName(String filePath) {
        int lastSlashIndex = filePath.lastIndexOf("\\");
        if (lastSlashIndex == -1) {
            lastSlashIndex = filePath.lastIndexOf("/");
        }
        int lastDotIndex = filePath.lastIndexOf(".");
        if (lastDotIndex == -1 || lastDotIndex < lastSlashIndex) {
            lastDotIndex = filePath.length();
        }
        return filePath.substring(lastSlashIndex + 1, lastDotIndex);
    }

    public static String getFileExtension(String filePath) {
        int lastDotIndex = filePath.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return "";
        }
        return filePath.substring(lastDotIndex + 1);
    }
}
