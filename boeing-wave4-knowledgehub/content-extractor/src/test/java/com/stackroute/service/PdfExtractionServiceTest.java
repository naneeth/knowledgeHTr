//package com.stackroute.service;
//
//import com.google.gson.Gson;
//import com.stackroute.domain.PdfDocument;
//import org.apache.tika.exception.TikaException;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.xml.sax.SAXException;
//
//import java.io.IOException;
//
//public class PdfExtractionServiceTest {
//
//    private PdfDocument pdfDocument;
//
//    private PdfExtractionServiceImpl pdfExtractionService;
//    public String[] metadata;
//
//    @Before
//    public void setUp() throws Exception
//    {
//        this.pdfExtractionService =new PdfExtractionServiceImpl();
//        this.pdfDocument=new PdfDocument();
//
//    }
//
//    @Test
//    public void testPdfServiceSuccess() throws TikaException, SAXException, IOException {
//
//        pdfDocument.setDocumentId("867e7615-cf2b-478d-a2d0-606f6e0edc60");
//        pdfDocument.setDocumentText("\nAdobe Acrobat PDF Files\n\nAdobe® Portable Document Format (PDF) is a universal file format that preserves all\nof the fonts, formatting, colours and graphics of any source document, regardless of\nthe application and platform used to create it.\n\nAdobe PDF is an ideal format for electronic document distribution as it overcomes the\nproblems commonly encountered with electronic file sharing.\n\n• Anyone, anywhere can open a PDF file. All you need is the free Adobe Acrobat\nReader. Recipients of other file formats sometimes can\u0027t open files because they\ndon\u0027t have the applications used to create the documents.\n\n• PDF files always print correctly on any printing device.\n\n• PDF files always display exactly as created, regardless of fonts, software, and\noperating systems. Fonts, and graphics are not lost due to platform, software, and\nversion incompatibilities.\n\n• The free Acrobat Reader is easy to download and can be freely distributed by\nanyone.\n\n• Compact PDF files are smaller than their source files and download a\npage at a time for fast display on the Web.\n\n\n");
//        metadata = new String[]{"date","pdf:PDFVersion","pdf:docinfo:title","xmp:CreatorTool","access_permission:modify_annotations","access_permission:can_print_degraded","dc:creator","dcterms:created","Last-Modified","dcterms:modified","dc:format","title","xmpMM:DocumentID","Last-Save-Date","pdf:docinfo:creator_tool","access_permission:fill_in_form","pdf:docinfo:modified","meta:save-date","pdf:encrypted","dc:title","modified","Content-Type","pdf:docinfo:creator","X-Parsed-By","creator","meta:author","meta:creation-date","created","access_permission:extract_for_accessibility","access_permission:assemble_document","xmpTPg:NPages","Creation-Date","access_permission:extract_content","access_permission:can_print","Author","producer","access_permission:can_modify","pdf:docinfo:producer","pdf:docinfo:created"};
//        pdfDocument.setDocumentMetaData(metadata);
//
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(pdfDocument);
//
//        String actualString= pdfExtractionService.extractFromFile("/home/user/Documents/boeing-wave4-knowledgehub/pdf-sample.pdf");
//
//        Assert.assertEquals(jsonString.substring(51), actualString.substring(51));
//
//    }
//
//
//    @Test
//    public void testPdfServiceFailure() throws TikaException, SAXException, IOException {
//
//        pdfDocument.setDocumentId("867e7615-cf2b-478d-a2d0-606f6e0edc60");
//        pdfDocument.setDocumentText("\nAdobe Acrobat PDF Files\n\nAdobe® Portable Document Format (PDF) is a universal file format that preserves all\nof the fonts, formatting, colours and graphics of any source document, regardless of\nthe application and platform used to create it.\n\nAdobe PDF is an ideal format for electronic document distribution as it overcomes the\nproblems commonly encountered with electronic file sharing.\n\n• Anyone, anywhere can open a PDF file. All you need is the free Adobe Acrobat\nReader. Recipients of other file formats sometimes can\u0027t open files because they\ndon\u0027t have the applications used to create the documents.\n\n• PDF files always print correctly on any printing device.\n\n• PDF files always display exactly as created, regardless of fonts, software, and\noperating systems. Fonts, and graphics are not lost due to platform, software, and\nversion incompatibilities.\n\n• The free Acrobat Reader is easy to download and can be freely distributed by\nanyone.\n\n• Compact PDF files are smaller than their source files and download a\npage at a time for fast display on the Web.\n\n\n");
//        metadata = new String[]{"date","pdf:PDFVersion","pdf:docinfo:title","xmp:CreatorTool","access_permission:modify_annotations","access_permission:can_print_degraded","dc:creator","dcterms:created","Last-Modified","dcterms:modified","dc:format","title","xmpMM:DocumentID","Last-Save-Date","pdf:docinfo:creator_tool","access_permission:fill_in_form","pdf:docinfo:modified","meta:save-date","pdf:encrypted","dc:title","modified","Content-Type","pdf:docinfo:creator","X-Parsed-By","creator","meta:author","meta:creation-date","created","access_permission:extract_for_accessibility","access_permission:assemble_document","xmpTPg:NPages","Creation-Date","access_permission:extract_content","access_permission:can_print","Author","producer","access_permission:can_modify","pdf:docinfo:producer","pdf:docinfo:created"};
//        pdfDocument.setDocumentMetaData(metadata);
//
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(pdfDocument);
//
//        String actualString= pdfExtractionService.extractFromFile("/home/user/Documents/boeing-wave4-knowledgehub/pdf-sample.pdf");
//
//        Assert.assertNotEquals(jsonString.substring(50), actualString.substring(51));
//
//    }
//
//}
