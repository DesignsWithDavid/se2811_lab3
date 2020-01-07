package gonzalez_salzwedelda;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class is used to test the functionality of the CrypStick through a rudimentary CLI.  This is not how the
 * actual CrypStick is intended to be used, but rather a way of ensuring it functions properly.
 *
 * @author David Gonzalez
 * @version 1.0
 * @created 01-Jan-2020 5:25 PM
 */
public class Main {
    private static CrypStick crypStick;

    public static void main(String[] args) {
        crypStick = new CrypStick(new Media());
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        out.print("E)ncrypt or D)ecrypt: ");
        String type = in.nextLine().toLowerCase();
        out.print("Method (rev, shift, xor): ");
        String method = in.nextLine().toLowerCase();

        switch (method+"_"+type){
            case "rev_e":
                rev_e(in, out);
                break;
            case "rev_d":
                rev_d(in, out);
                break;
            case "shift_e":
                shift_e(in, out);
                break;
            case "shift_d":
                shift_d(in, out);
                break;
            case "xor_e":
                xor_e(in, out);
                break;
            case "xor_d":
                xor_d(in, out);
                break;
        }
    }


    private static void rev_e(Scanner in, PrintStream out){
        crypStick.setEncryptionStrategy(new ReverseEncrypter());
        out.println("Message: ");
        String message = input_message(in);
        crypStick.setMessage(message);
        System.out.println(crypStick.getMedia());
    }

    private static void rev_d(Scanner in, PrintStream out){
        crypStick.setEncryptionStrategy(new ReverseEncrypter());
        out.println("Message: ");
        String message = input_message(in);
        crypStick.getMedia().set(message);
        System.out.println(crypStick.getMessage());
    }


    private static void shift_e(Scanner in, PrintStream out){
        out.print("Shift amount: ");
        int amount = Integer.parseInt(in.nextLine());
        crypStick.setEncryptionStrategy(new ShiftEncrypter(amount));
        out.print("Message: \n");
        String message = input_message(in);
        crypStick.setMessage(message);
        System.out.println(crypStick.getMedia());
    }

    private static void shift_d(Scanner in, PrintStream out){
        out.print("Shift amount: ");
        int amount = Integer.parseInt(in.nextLine());
        crypStick.setEncryptionStrategy(new ShiftEncrypter(amount));
        out.println("Message: ");
        String message = input_message(in);
        crypStick.getMedia().set(message);
        System.out.println(crypStick.getMessage());
    }


    private static void xor_e(Scanner in, PrintStream out) {
        out.print("Key: ");
        String key = in.nextLine();
        crypStick.setEncryptionStrategy(new XOREncrypter(key));
        out.println("Message: ");
        String message = input_message(in);
        crypStick.setMessage(message);
        System.out.println(crypStick.getMedia());
    }

    private static void xor_d(Scanner in, PrintStream out) {
        out.print("Key: ");
        String key = in.nextLine();
        crypStick.setEncryptionStrategy(new XOREncrypter(key));
        out.println("Message: ");
        String message = input_message(in);
        crypStick.getMedia().set(message);
        System.out.println(crypStick.getMessage());
    }

    private static String input_message(Scanner in){
        Pattern old_delimiter = in.delimiter();
        in.useDelimiter("^D");
        StringBuilder string = new StringBuilder();
        while (in.hasNext()){
            String next = in.nextLine();
            string.append(next + "\n");
        }
        in.useDelimiter(old_delimiter);//return to original state
        return string.toString();
    }
}
