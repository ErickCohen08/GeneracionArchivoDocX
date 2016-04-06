package com.sambhashanam.docx;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
import com.sambhashanam.docx.DocxDocumentMergerAndConverter;
 
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

public class DocxDocumentMergerAndConverterTest {
	/**
	 * Test method for {@link com.sambhashanam.docx.DocxDocumentMergerAndConverter#mergeAndGenerateOutput(java.lang.String, fr.opensagres.xdocreport.template.TemplateEngineKind, java.util.Map, java.util.Map)}.
	 * @throws XDocReportException 
	 * @throws IOException 
	 */
	public void testMergeAndGenerateOutput() throws IOException, XDocReportException {
 
		String templatePath = "D:\\junoprojects\\docxtopdf\\docx-template\\ThankYouNote_Template.docx";
 
		Map<String, Object> nonImageVariableMap = new HashMap<String, Object>();
		nonImageVariableMap.put("thank_you_date", "24-June-2013");
		nonImageVariableMap.put("name", "Rajani Jha");
		nonImageVariableMap.put("website", "www.sambhashanam.com");
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
