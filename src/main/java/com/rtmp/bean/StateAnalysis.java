package com.rtmp.bean;

import cn.hutool.core.util.XmlUtil;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @作者 LEIJIE
 * @时间 2019-9-25 10:54
 * @描述 状态xml解析
 */
public class StateAnalysis {

    static SuperValue superValue;

    public static RtmpState runJob(String monitorUrl) throws IOException {
        String xmlContent = Jsoup.connect(monitorUrl).get().toString();
        Document document = XmlUtil.parseXml(cleanInvalid(xmlContent));
        parseElement(document.getDocumentElement());
        return SuperValue.rtmpState;
    }

    public static void parseElement(Element element){
        NodeList nodeList = element.getChildNodes();
        String nodeName=null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            nodeName = childNode.getParentNode().getNodeName();
            superValue = SuperValue.getObjForType(i,nodeName);
            if (childNode.getNodeType() != Node.TEXT_NODE && childNode.getChildNodes().getLength()<=1){
                if (superValue != null){
                    superValue.setValue(childNode.getNodeName(),childNode.getTextContent().trim());
                }
            }else if(childNode.getChildNodes().getLength() >1){
                parseElement((Element) childNode);
            }
        }
        SuperValue.saveObj(nodeName);
    }

    public final static String INVALID_REGEX = "[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f-\n]";

    public static String cleanInvalid(String xmlContent) {
        if (xmlContent == null) {
            return null;
        }
        return xmlContent.replaceAll(INVALID_REGEX, "");
    }

    public static String readableFileSize(long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "Kb", "Mb", "Gb", "Tb"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + "" + units[digitGroups]+"/s";
    }

}
