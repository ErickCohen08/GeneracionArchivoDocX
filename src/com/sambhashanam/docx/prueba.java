package com.sambhashanam.docx;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.io.IOException;
 
import com.sambhashanam.docx.DocxDocumentMergerAndConverter;
 
import fr.opensagres.xdocreport.core.XDocReportException;

public class prueba {

	public prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, XDocReportException{
		// TODO Auto-generated method stub
		String templatePath = "D:\\docs\\pruebadocx.docx";
		 
		Map<String, Object> nonImageVariableMap = new HashMap<String, Object>();
		nonImageVariableMap.put("thank_you_date", "vector");
		nonImageVariableMap.put("name", "erick");
		nonImageVariableMap.put("website", "cohen");
		nonImageVariableMap.put("author_name", "Dhananjay Jha");
		
		Map<String, String> imageVariablesWithPathMap =new HashMap<String, String>();
		imageVariablesWithPathMap.put("header_image_logo", "D:\\docs\\CabeceraCorreo.jpg");
 
		DocxDocumentMergerAndConverter docxDocumentMergerAndConverter = new DocxDocumentMergerAndConverter();
		byte[] mergedOutput = docxDocumentMergerAndConverter.mergeAndGenerateOutput(templatePath, TemplateEngineKind.Freemarker, nonImageVariableMap, imageVariablesWithPathMap);
//		assertNotNull(mergedOutput);
		FileOutputStream os = new FileOutputStream("D:\\docs\\erco"+System.nanoTime()+".docx");
		
		
		os.write(mergedOutput);
		os.flush();
		os.close();
	}

}
