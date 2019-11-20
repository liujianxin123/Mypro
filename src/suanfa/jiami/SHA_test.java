package suanfa.jiami;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA_test {
    public static final String KEY_SHA = "SHA1";
    public static String getResult(String inputStr)
    {
        BigInteger sha =null;
        System.out.println("=======加密前的数据:"+inputStr);
        byte[] inputData = inputStr.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());

            System.out.println("SHA加密后:" + sha.toString());

            System.out.println("SHA解密后:"+getFormattedText(messageDigest.digest()));
        } catch (Exception e) {e.printStackTrace();}
        return sha.toString();
    }
    public static void main(String args[])
    {
        try {
            String inputStr = "你好";
            String a = getResult(inputStr);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes
     *            the raw bytes from the digest.
     * @return the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }





}
