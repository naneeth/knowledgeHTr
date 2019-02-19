package com.stackroute.domain;

import lombok.Data;
import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class PdfDocument {

    @Id
    private String documentId;

    private String documentText;
    private JSONObject documentMetaData;

}
