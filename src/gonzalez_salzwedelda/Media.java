package gonzalez_salzwedelda;
import java.util.Scanner;

/**
 * This class represents the media to which data can be written to.  It simply provides the functionality to
 * read and write data from the media device.
 *
 * @author David Gonzalez
 * @version 1.0
 * @created 01-Jan-2020 5:25 PM
 */
public class Media {
    private byte[] bytes;

    public byte[] get(){
        return bytes;
    }

    public void set(byte[] bytes){
        this.bytes = bytes;
    }

    public void set(String byteString){
        Scanner scanner = new Scanner(byteString);
        String line = scanner.nextLine();
        Scanner line_scanner = new Scanner(line);
        int length = (line.length()+1)/(3);
        byte[] bytes = new byte[length];

        for (int i = 0; i < length; i++){
            bytes[i] = Byte.parseByte(line_scanner.next(), 16);
        }
        this.bytes = bytes;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(String.format("%02x ", b));
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
