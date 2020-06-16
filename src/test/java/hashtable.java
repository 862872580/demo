import java.util.Hashtable;

public class hashtable {
    public static void main(String[] args) {
        Hashtable[] hashtables = new Hashtable[1];
        Hashtable hashtable = new Hashtable();
        hashtables[0] = hashtable;

        Hashtable hashtable1 = new Hashtable();
        hashtable.put("cino", hashtable1);
        System.out.println(hashtable);
        System.out.println(hashtables[0]);
        System.out.println(hashtable.get("ci"));
    }
}
