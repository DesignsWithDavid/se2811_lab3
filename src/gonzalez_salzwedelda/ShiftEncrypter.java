package gonzalez_salzwedelda;

/**
 * This class implements the shift encryption strategy where each byte of the message being encrypted is
 * incremented according to the shift value provided
 *
 * @author David Gonzalez
 * @version 1.0
 * @created 01-Jan-2020 5:25 PM
 */
public class ShiftEncrypter implements Encrypter  {
    private int amount;

    public ShiftEncrypter(int amount){
        this.amount = amount;
    }

    @Override
    public byte[] decrypt(byte[] byte_array) {
        byte[] new_array = new byte[byte_array.length];
        for(int i = 0; i < byte_array.length; i++){
            new_array[i] = (byte)(byte_array[i] - amount);
        }
        return new_array;
    }

    @Override
    public byte[] encrypt(byte[] byte_array) {
        byte[] new_array = new byte[byte_array.length];
        for(int i = 0; i < byte_array.length; i++){
            new_array[i] = (byte)(byte_array[i] + amount);
        }
        return new_array;
    }
}
