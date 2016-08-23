package services.Encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5EncryptService implements Encrypting {

    private static final Logger LOG = LoggerFactory.getLogger(MD5EncryptService.class);
    private static Encrypting instance;

    private MD5EncryptService() {
    }

    public static Encrypting getInstance() {
        if (instance == null) {
            instance = new MD5EncryptService();
        }
        return instance;
    }

    @Override
    public String encrypt(String word) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(word.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            LOG.error(e.getMessage());
        }
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);
        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }
        return md5Hex;
    }

}
