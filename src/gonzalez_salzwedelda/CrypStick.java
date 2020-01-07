package gonzalez_salzwedelda;

import java.nio.charset.StandardCharsets;

/**
 * This class is the CrypStick itself.  It provides a means for encrypting and decrypting content onto some media
 * through the use of various encryption strategies.
 *
 * @author David Gonzalez
 * @version 1.0
 * @created 01-Jan-2020 5:25 PM
 */
public class CrypStick {
    private Media media;
    private Encrypter encrypter;

    public CrypStick(Media media){
        this.media = media;
    }

    protected Media getMedia(){
        return media;
    }

    public String getMessage(){
        return new String(encrypter.decrypt(media.get()), StandardCharsets.UTF_8);
    }

    public void setEncryptionStrategy(Encrypter encrypter){
        this.encrypter = encrypter;
    }

    public void setMessage(String message){
        media.set(encrypter.encrypt(message.getBytes(StandardCharsets.UTF_8)));
    }
}
