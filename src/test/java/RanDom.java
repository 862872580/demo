import java.util.Random;

public class RanDom {
    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);

        Random random2 = new Random();
        //从0开始 不包含10
        System.out.println(20 + random2.nextInt(10));
    }
}
