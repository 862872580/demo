package xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaxXml {
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
                "</returnInfos>" +

                "<exData>" +
                "<zipCode>0,1</zipCode> " +
                "<encryptCode>0,1</encryptCode>" +
                "<content>base64请求数据内容或返回数据内容</content>" +
                "</exData>" +
                "</invInterface>";
        Map<String, String> map = SaxXml(xml);
        System.out.println(map);
    }


    private static Map<String, String> SaxXml(String xml) throws JDOMException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        Document doc = saxBuilder.build(new StringReader(xml));
        Element root = doc.getRootElement();
        for (Element ele : ((Element) root).getChildren()) {
            getChild(ele, map);
        }
        return map;
    }

    public static void getChild(Element ele, Map<String, String> map) {
        List<Element> children = ele.getChildren();
        if (children.isEmpty()) {
            String key = ele.getName();
            String value = ele.getValue();
            map.put(key, value);

        } else {
            for (Element e : children) {
                getChild(e, map);
            }
        }
    }
}

