import java.util.*;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        int length= getPasswordLength();
        boolean useUppercase = toUseUpperCase();
        boolean useLowercase = toUseLowerCase();
        boolean useDigits = toUseDigits();
        boolean useSpecialCharacters = toUseSpecialCharacters();

        String password = generateRandomPassword(length,useUppercase,useLowercase,useDigits,useSpecialCharacters);
        System.out.println("Generated Password: " + password);

    }
    private static int getPasswordLength() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the password: ");
        return sc.nextInt();
    }
    private static boolean toUseUpperCase(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Want to include uppercase letters? (y/n):");
        String inp=sc.nextLine();
        return inp.equalsIgnoreCase("y");
    }
    private static boolean toUseLowerCase(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Want to include lowercase letters? (y/n):");
        String inp=sc.nextLine();
        return inp.equalsIgnoreCase("y");
    }
    private static boolean toUseDigits(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Want to include digits? (y/n):");
        String inp=sc.nextLine();
        return inp.equalsIgnoreCase("y");
    }
    private static boolean toUseSpecialCharacters(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Want to include special characters? (y/n):");
        String inp=sc.nextLine();
        return inp.equalsIgnoreCase("y");
    }
    private static String generateRandomPassword(int length, boolean useUppercase, boolean useLowercase, boolean useDigits, boolean useSpecialCharacters){
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        StringBuilder allowedCharacters = new StringBuilder();
        if (useUppercase) allowedCharacters.append(uppercaseLetters);
        if (useLowercase) allowedCharacters.append(lowercaseLetters);
        if (useDigits) allowedCharacters.append(digits);
        if (useSpecialCharacters) allowedCharacters.append(specialCharacters);


        Random random = new Random();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = allowedCharacters.charAt(random.nextInt(allowedCharacters.length()));
        }
        return new String(password);
    }

}
