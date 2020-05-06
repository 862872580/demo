import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
    public static void main(String[] orgs){
        String password = "1234567";
        String key = "12";
        // 加密后的字符串
        String md5str = DigestUtils.md5Hex(password + key);
        System.out.println("MD5加密后的字符串为:" + md5str);
    }
}
