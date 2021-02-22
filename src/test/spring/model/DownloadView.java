package test.spring.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

// 다운할때 연결해줄 파일에 대한 비즈니스 로직 처리할 클래스
public class DownloadView extends AbstractView {
	
	public DownloadView() {
		// 주고 받을 data type의 선언
		setContentType("application/download; charset=utf-8"); 
	}

	@Override							
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		
		File file = (File)model.get("downloadFile");		
		response.setContentType(getContentType()); 		
		response.setContentLength((int)file.length());		
		// 자바내에서 인코등 하는 방법
		String fileName = java.net.URLEncoder.encode(file.getName(), "UTF-8"); 
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";");  
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);		
			FileCopyUtils.copy(fis, out);			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fis != null) { try {fis.close();}catch(Exception e2) { e2.printStackTrace(); } }
			out.flush();
		}
	}
	
}
