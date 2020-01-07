package gonzalez_salzwedelda;

/**
 * This interface is what is required to implement an encryption strategy.  Any class that implements this interface
 * can be used to encrypt and decrypt data by whatever means chosen.
 *
 * @author David Gonzalez
 * @version 1.0
 * @created 01-Jan-2020 5:25 PM
 */
public interface Encrypter {
    byte[] decrypt(byte[] byte_array);
    byte[] encrypt(byte[] byte_array);
}
