package gonzalez_salzwedelda;
import java.nio.charset.StandardCharsets;

/**
 * This class implements the XOR encryption strategy where the message being encrypted is xored with a provided key.
 *
 * @author David Gonzalez
 * @version 1.0
 * @created 01-Jan-2020 5:25 PM
 */
public class XOREncrypter implements Encrypter {
    private byte[] key;

    public XOREncrypter(String key){
        this.key = key.getBytes(StandardCharsets.UTF_8);
    }


    @Override
    public byte[] decrypt(byte[] byte_array) {
        return  encrypt(byte_array);
    }

    @Override
    public byte[] encrypt(byte[] byte_array) {
        byte[] new_array = new byte[byte_array.length];
        for (int i = 0; i < byte_array.length; i++){
            new_array[i] = (byte)(byte_array[i] ^ key[i%(key.length)]);
        }
        return new_array;
    }
}
