package com.wxinfo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.message.resp.Article;
import com.message.resp.NewsMessage;
import com.message.resp.TextMessage;
import com.message.resp.Music;
import com.message.resp.MusicMessage;
import com.wxinfo.util.MessageUtil;

/**
 * ���ķ�����
 * @author Administrator
 *
 */
public class Service {
	 /** 
     * ����΢�ŷ��������� 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        // ���ظ�΢�ŷ�������xml��Ϣ  
        String respXml = null;  
        // �ı���Ϣ����  
        String respContent = null;
        try {  
            // Ĭ�Ϸ��ص��ı���Ϣ����  
            //String respContent = "�������쳣�����Ժ��ԣ�";  
        	respContent = "�������쳣�����Ժ��ԣ�";  
  
            // xml�������  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // ���ͷ��ʺţ�open_id��  
            String fromUserName = requestMap.get("FromUserName");  
            // �����ʺ�  
            String toUserName = requestMap.get("ToUserName");  
            // ��Ϣ����  
            String msgType = requestMap.get("MsgType");  
  
            // �ظ��ı���Ϣ  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
  
            // �ı���Ϣ  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
            	
                respContent = "�����͵����ı���Ϣ����˵���ǣ�" + requestMap.get("Content");  
            }  
            // ͼƬ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "�����͵���ͼƬ��Ϣ��";  
            }  
            // ����λ����Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "�����͵��ǵ���λ����Ϣ��";  
            }  
            // ������Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "�����͵���������Ϣ��";  
            }  
            // ��Ƶ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "�����͵�����Ƶ��Ϣ����˵���ǣ�" + requestMap.get("Recognition");  
                
                //���û����˵�API
                //�����˻ظ��ַ���
            }  
            
            
            // �¼�����  
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
//                // �¼�����  
//                String eventType = requestMap.get("Event");  
//                // ����  
//                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
//                    respContent = "лл���Ĺ�ע��";  
//                }  
//                // ȡ������  
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
//                    // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ  
//                }  
//                // �Զ���˵�����¼�  
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
//                    // TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ  
//                }  
//            }  
  
            textMessage.setContent(respContent);  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return respMessage;  
    }
}
