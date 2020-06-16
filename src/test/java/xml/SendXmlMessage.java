package xml;

import java.util.Hashtable;
import java.util.Iterator;

public class SendXmlMessage {
    public static void main(String[] args) {
        Hashtable[] hts = new Hashtable[2];
        Hashtable<String, String> ht = new Hashtable();
        ht.put("1","1");
        ht.put("2","2");
        hts[0] = ht;

        Hashtable<String, String> ht2 = new Hashtable();
        ht.put("3","3");
        ht.put("4","4");
        hts[1] = ht2;

        StringBuffer sb = SendXmlMessage(hts);
        System.out.println(sb);
    }
    public static StringBuffer SendXmlMessage(Hashtable[] hts) {
        StringBuffer sb = new StringBuffer();

        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\n");
        sb.append("<requestFPKJ>").append("\n");

        for(Iterator<String> iterator = hts[0].keySet().iterator(); iterator.hasNext();){
            String key=iterator.next();

            sb.append("<").append(key).append(">");
            sb.append(hts[0].get(key));
            sb.append("</").append(key).append(">").append("\n");
        }

        for (int i = 1; i < hts.length; i ++){
            for(Iterator<String> iterator = hts[i].keySet().iterator(); iterator.hasNext();){
                String key=iterator.next();

                sb.append("<").append(key).append(">");
                sb.append(hts[i].get(key));
                sb.append("</").append(key).append(">").append("\n");
            }
        }

        sb.append("</requestFPKJ>").append("\n");
        return sb;
    }
}