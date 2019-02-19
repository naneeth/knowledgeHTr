package com.stackroute.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.stackroute.Exception.EmptyFileException;
import com.stackroute.Exception.FileNotFoundException;
import com.stackroute.domain.PdfDocument;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class PdfExtractionServiceImpl implements PdfExtractionService {

    /*
    This method will take path of PDF file as input parameter and return String in JSON Format
     */

    public String extractFromFile( String path ) throws IOException , SAXException, NullPointerException, FileNotFoundException, EmptyFileException,
            TikaException{

        Parser parser = new AutoDetectParser();
        PdfDocument pdfDocument = new PdfDocument();
        String uniqueID = UUID.randomUUID().toString();
        BodyContentHandler handler = new BodyContentHandler(1000000);
        Metadata metadata =new Metadata();

        FileInputStream content = new FileInputStream(path);
        if( content == null )
        {
            throw new FileNotFoundException("File Not Found !! ");
        }
        parser.parse(content,handler,metadata,new ParseContext());
        pdfDocument.setDocumentId(uniqueID);
        pdfDocument.setDocumentText(handler.toString());
        if( handler.toString().length()  == 0)
        {
            throw new EmptyFileException("File is Empty");
        }

        JSONObject metaDataJson = new JSONObject();
        for( String name : metadata.names())
        {
            metaDataJson.put(name,metadata.get(name));
        }
        pdfDocument.setDocumentMetaData(metaDataJson);
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(pdfDocument);
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonString = objectWriter.writeValueAsString(pdfDocument);
        return jsonString;
    }

}
