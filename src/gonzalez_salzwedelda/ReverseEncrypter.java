package gonzalez_salzwedelda;

/**
 * This class implements the reverse encryption strategy where the message being encrypted is reversed
 * byte by byte.
 *
 * @author David Gonzalez
 * @version 1.0
 * @created 01-Jan-2020 5:25 PM
 */
public class ReverseEncrypter implements Encrypter {

    @Override
    public byte[] decrypt(byte[] byte_array) {
        return encrypt(byte_array);
    }

    @Override
    public byte[] encrypt(byte[] byte_array) {
        int length = byte_array.length;
        byte[] new_array = new byte[length];
        for(int i = 0; i < length; i++){
            new_array[i] = byte_array[length-(i+1)];
        }

        return new_array;
    }
}
