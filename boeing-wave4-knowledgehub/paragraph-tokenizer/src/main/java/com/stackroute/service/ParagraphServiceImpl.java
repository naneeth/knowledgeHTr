package com.stackroute.service;

import com.stackroute.domain.Paragraph;
import com.stackroute.exception.ParagraphNotFoundException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ParagraphServiceImpl implements ParagraphService{

    @Override
    public List<JSONObject> getParagraphObject(JSONObject object) throws ParagraphNotFoundException {

       try {
           if(object.isEmpty()){
               throw new ParagraphNotFoundException("Paragraph not found");
           }
           String documentId1 = (String) object.get("documentId");
           String text = (String) object.get("documentText");

           Paragraph paraObj = new Paragraph();
           String patternStr = "[.?!][/\\s/g]?\\n+";
           Pattern pattern = Pattern.compile(patternStr);
           Matcher matcher = pattern.matcher(text);
           String[] para = text.split(patternStr);
           int i = 0;
           while (matcher.find()) {
               String paragraph = matcher.group();
               para[i] = para[i] + paragraph.charAt(0);
               i++;
           }
           int cnt = 0;
           paraObj.setParagraphId(1);
           int id = paraObj.getParagraphId();
           List<JSONObject> list = new ArrayList();
           JSONObject obj1 = new JSONObject();
           obj1.put("documentId", documentId1);
           list.add(obj1);
           while (cnt < para.length) {
               JSONObject obj = new JSONObject();
//            obj.put("documentId", documentId1);
               obj.put("paragraphId", id);
               paraObj.setParagraphId(id++);
               paraObj.setParagraphText(para[cnt]);
               obj.put("paragraphText", paraObj.getParagraphText());
               cnt++;

               list.add(obj);
           }
           return list;
       }catch (ParagraphNotFoundException ex){
           throw ex;
       }
    }
}
