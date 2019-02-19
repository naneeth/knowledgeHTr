package com.stackroute;
import com.stackroute.domain.Paragraph;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.stackroute.domain.Paragraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.stackroute.service.ParagraphServiceImpl;

@SpringBootApplication
public class ParagraphTokenizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParagraphTokenizerApplication.class, args);
	}
}
