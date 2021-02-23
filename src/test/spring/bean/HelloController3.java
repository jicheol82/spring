package test.spring.bean;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController3 {
	@RequestMapping("pika.do")
	public String pika(String name, Model model) {
		System.out.println(name);
		// 128bit범위의 랜덤한 id생성
		System.out.println(UUID.randomUUID().toString());
		model.addAttribute("name", name);
		return "spring03/pika";
	}
	
	@RequestMapping("uploadForm.do")
	public String uploadForm() {
		System.out.println("uploadForm");
		return "spring03/uploadForm";
	}
	
	@RequestMapping("uploadPro.do")
	public String uploadPro(String writer, MultipartHttpServletRequest request, Model model) {
		System.out.println("uploadPro");
		MultipartFile mf = null;
		try {
			// 일반 데이터 -> 일반 매개변수로 받아서 이상없는지 확인
			// System.out.println("writer : " + writer);
			
			// 파일정보 담기
			mf = request.getFile("img");
			// System.out.println(mf.getSize());
			
			// 서버상의 폴더인 save 폴더에 저장
			String path = request.getRealPath("save");
			// System.out.println("path : "+path);
			/*
			String imgPath = path + "\\" + mf.getOriginalFilename();
			System.out.println("imgPath : "+imgPath);
			
			// 파일 저장하기
			// -> 먼저 위에 완성된 파일경로+파일명인 imgPath로 file 객체 만들기
			File copyFile = new File(imgPath);
			mf.transferTo(copyFile);
			*/
			//  파일명 중복처리 저장
			String orgName = mf.getOriginalFilename();
			// System.out.println("orgName : "+orgName);
			// 파일명 확장자 나누기
			String imgName = orgName.substring(0,orgName.lastIndexOf('.'));
			// System.out.println("imgName :"+imgName);
			String ext = orgName.substring(orgName.lastIndexOf('.'));
			// System.out.println("ext :"+ext);
			long date = System.currentTimeMillis();
			String newName = imgName + date + ext;
			// System.out.println("newName : "+newName);
			String imgPath = path + "\\" + newName;
			File copyFile = new File(imgPath);
			mf.transferTo(copyFile);
			
			model.addAttribute("newName", newName);
		}catch(Exception e) {e.printStackTrace();}
		return "spring03/uploadPro";
	}
	@RequestMapping("download.do")
	public ModelAndView down() {
		// 다운시킬 파일의 경로와 처리만 호출(파일연결)
		File f = new File("e://cjc//test//pika.jpg");
		// fileDown: xml에 만든 다운로드 비즈니스로직처리 클래스의 bean 태그 id속성값
		// downloadFile: 파라미터명 지정
		// f: 파라미터명에 일치하는 데이터(File 객체)
		ModelAndView mv = new ModelAndView("fileDown","downloadFile",f);
		return mv;
	}
}
