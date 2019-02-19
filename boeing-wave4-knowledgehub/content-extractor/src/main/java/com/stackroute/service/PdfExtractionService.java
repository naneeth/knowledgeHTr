package com.stackroute.service;

import com.stackroute.Exception.EmptyFileException;
import com.stackroute.Exception.FileNotFoundException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;

public interface PdfExtractionService {

    String extractFromFile(String path) throws IOException, SAXException,
            TikaException,FileNotFoundException, EmptyFileException;
}



