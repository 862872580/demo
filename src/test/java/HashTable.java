import java.util.Hashtable;

public class HashTable {
    public static void main(String[] args) {
        java.util.Hashtable[] hashtables = new java.util.Hashtable[1];
        java.util.Hashtable hashtable = new java.util.Hashtable();
        hashtables[0] = hashtable;

        java.util.Hashtable hashtable1 = new java.util.Hashtable();
        hashtable.put("cino", hashtable1);
        System.out.println(hashtable);
        System.out.println(hashtables[0]);
        System.out.println(hashtable.get("ci"));
    }
}
