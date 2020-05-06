import java.util.UUID;

import static org.apache.commons.lang3.SerializationUtils.serialize;

//序列化
public class Serialize {
    public static void main(String[] orgs){
        String s = "asd";
        System.out.println(serialize(s));
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
