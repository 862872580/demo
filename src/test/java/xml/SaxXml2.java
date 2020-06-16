package xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaxXml2 {
    static final SAXBuilder saxBuilder = new SAXBuilder();

    public static void main(String[] args) throws JDOMException, IOException {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
                "<invInterface>" +
                "<baseInfo>" +
                "<version>接口版本</version>" +
                "<interfaceCode>接口编码</interfaceCode>" +
                "<sellerTaxNo>组织代码</sellerTaxNo>" +
                "</baseInfo>" +

                "<returnInfos>" +
                "<returnInfo>" +
                "<returnCode>返回代码</returnCode>" +
                "<returnMessage>base64 返回描述</returnMessage>" +
                "</returnInfo>" +

                "<returnInfo>" +
                "<returnCode>返回代码2</returnCode>" +
                "<returnMessage>base64 返回描述2</returnMessage>" +
                "</returnInfo>" +

                "<returnInfo>" +
                "<returnCode>返回代码3</returnCode>" +
                "<returnMessage>base64 返回描述3</returnMessage>" +
                "</returnInfo>" +
                "</returnInfos>" +

                "<exData>" +
                "<zipCode>0,1</zipCode> " +
                "<encryptCode>0,1</encryptCode>" +
                "<content>base64请求数据内容或返回数据内容</content>" +
                "</exData>" +
                "</invInterface>";
        Map<String, Object> map = SaxXml(xml);
        System.out.println(map);
    }


    private static Map<String, Object> SaxXml(String xml) throws JDOMException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Document doc = saxBuilder.build(new StringReader(xml));
        Element root = doc.getRootElement();
        //使用sax解析出元素
        for (Element ele : ((Element) root).getChildren()) {
            getChild(ele, map);
        }
        return map;
    }

    public static void getChild(Element ele, Map<String, Object> map) {
        List<Element> children = ele.getChildren();
        List<String> list;

        if (children.isEmpty()) {
            String key = ele.getName();
            String value = ele.getValue();
            //如果map中没有该数据则放入
            if (map.get(key) != null){
                //如果map中有数据,且为List,就往list中插入数据
                if (map.get(key) instanceof List) {
                    list = (List<String>) map.get(key);
                    list.add(value);
                    map.put(key,list);
                //map中有数据为String,创建一个list并放入两个值
                }else{
                    list = new ArrayList();
                    list.add((String) map.get(key));
                    list.add(value);
                    map.put(key,list);
                }
            }else{
                map.put(key, value);
            }

        } else {
            for (Element e : children) {
                getChild(e, map);
            }
        }
    }
}

