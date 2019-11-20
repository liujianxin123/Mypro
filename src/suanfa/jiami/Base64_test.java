package suanfa.jiami;

import javax.crypto.*;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DHParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;

public class Base64_test {
    public static void main(String[] args) {
//        String text = "base64 in java8 lib:score_service score_service score_service score_service score_service score_service===";
//        //编码
//        String encode = Base64.getEncoder()
//                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
//        System.out.println(encode);
//
//        //解码
//        String decode = new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
//        System.out.println(decode);
        jdkDH();
    }

    private static String src="这是一个加密字符";

    public static void jdkDES(){
        try {
            //生成key
            KeyGenerator keyGenerator= KeyGenerator.getInstance("DES");
            keyGenerator.init(56);      //指定key长度，同时也是密钥长度(56位)
            SecretKey secretKey = keyGenerator.generateKey(); //生成key的材料
            byte[] key = secretKey.getEncoded();  //生成key

            //key转换成密钥
            DESKeySpec desKeySpec=new DESKeySpec(key);
            SecretKeyFactory factory=SecretKeyFactory.getInstance("DES");
            SecretKey key2 = factory.generateSecret(desKeySpec);      //转换后的密钥

            //加密
            Cipher cipher= Cipher.getInstance("DES/ECB/PKCS5Padding");  //算法类型/工作方式/填充方式
            cipher.init(Cipher.ENCRYPT_MODE, key2);   //指定为加密模式
            byte[] result=cipher.doFinal(src.getBytes());
            //System.out.println("jdkDES加密: "+Hex.encodeHexString(result));  //转换为十六进制

            //解密
            cipher.init(Cipher.DECRYPT_MODE,key2);  //相同密钥，指定为解密模式
            result = cipher.doFinal(result);   //根据加密内容解密
            System.out.println("jdkDES解密: "+new String(result));  //转换字符串

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void jdkDH(){
        try {
            //初始化发送方密钥
            KeyPairGenerator senderKeyPairGenerator= KeyPairGenerator.getInstance("DH");
            senderKeyPairGenerator.initialize(512);   //密钥长度
            KeyPair senderKeyPair = senderKeyPairGenerator.generateKeyPair();
            byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();  //发送方key,需传递给接收方（网络，文件）

            //初始化接收方密钥
            KeyFactory factory= KeyFactory.getInstance("DH");
            X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(senderPublicKeyEnc);  //根据从发送方得到的key解析
            PublicKey receiverPublicKey=factory.generatePublic(x509EncodedKeySpec);
            DHParameterSpec dhParameterSpec=((DHPublicKey)receiverPublicKey).getParams();
            KeyPairGenerator receiverKeyPairGenerator=KeyPairGenerator.getInstance("DH");
            receiverKeyPairGenerator.initialize(dhParameterSpec);
            KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair();
            PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
            byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();

            //密钥构建
            KeyAgreement receiverKeyAgreement=KeyAgreement.getInstance("DH");
            receiverKeyAgreement.init(receiverPrivateKey);
            receiverKeyAgreement.doPhase(receiverPublicKey, true);
            SecretKey receiverDESKey=receiverKeyAgreement.generateSecret("DES");  //发送发密钥(公钥)
            KeyFactory senderKeyFactory=KeyFactory.getInstance("DH");
            x509EncodedKeySpec=new X509EncodedKeySpec(receiverPublicKeyEnc);
            PublicKey senderPublicKey=senderKeyFactory.generatePublic(x509EncodedKeySpec);
            KeyAgreement senderKeyAgreement=KeyAgreement.getInstance("DH");
            senderKeyAgreement.init(senderKeyPair.getPrivate());
            senderKeyAgreement.doPhase(senderPublicKey, true);
            SecretKey senderDESKey=senderKeyAgreement.generateSecret("DES");        //接收方密钥(私钥)
            if(Objects.equals(receiverDESKey, senderDESKey)){
                System.out.println("双方密钥相同");
            }
            //加密
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, senderDESKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk DH加密: "+result);

            //解密
            cipher.init(Cipher.DECRYPT_MODE, receiverDESKey);
            result=cipher.doFinal(result);
            System.out.println("jdk DH解密: "+new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
