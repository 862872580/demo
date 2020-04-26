import com.alibaba.fastjson.JSON;
import shiro.beans.User;

public class fastjson {
    public static void main(String[] orgs){
        User user = new User();
        user.setId(1);
        user.setName("zs");
        user.setPassword("123456");

        //把对象转换为JSON格式
        String  toJSON = JSON.toJSONString(user);
        System.out.println(toJSON);

        //把JSON格式数据转换成对象
        User user1 = JSON.parseObject(toJSON,User.class);
        System.out.println(user1);
    }
}
