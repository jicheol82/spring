package test.mybatis.bean;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.model.TestMybatisDTO;

@Controller
public class TestMybatis {
	// 빈 자동 주입 DI
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@RequestMapping("mybatis.do")
	public String helloMybatis() {
		System.out.println(sqlSession);
		return "spring01/hello";
	}
	// mapper에 있는 sql문 사용하기
	@RequestMapping("testTable.do")
	public String testTable(Model model) {
		int count = (Integer) sqlSession.selectOne("test.userCount");
		int maxAge = (Integer) sqlSession.selectOne("test.maxAge");
//		System.out.println(count);
//		System.out.println(maxAge);
		
		// 형변환을 안해도 불러짐
		List<TestMybatisDTO> userList = sqlSession.selectList("test.selectAll");

		// id로 레코드 가져오기
		String id = "test";
		TestMybatisDTO dto = (TestMybatisDTO)sqlSession.selectOne("test.getUser", id);
		
		// id로 reg 가져오기-Timestamp는 String으로 받을 수 있음
		Timestamp reg = (Timestamp)sqlSession.selectOne("test.getReg", id);
		
		
		model.addAttribute("count", count);
		model.addAttribute("maxAge", maxAge);
		model.addAttribute("userList", userList);
		model.addAttribute("dto", dto);
		model.addAttribute("reg", reg);
		
		return "spring04/test";
	}
	// form 입력하는 페이지 요청
	@RequestMapping("insertForm.do")
	public String insertForm() {
		return "spring04/form";
	}
	// form페이지에서 가입버튼 눌렀을때 요청
	@RequestMapping("insertPro.do")
	public String insertPro(TestMybatisDTO dto, Model model) {
		int result = sqlSession.insert("test.insertUser", dto);
		System.out.println("result : "+result);
		model.addAttribute("dto", dto);
		return "spring04/pro";
	}
	// update page 요청
	@RequestMapping("updateForm.do")
	public String updateForm(Model model) {
		// db가서 해당 id에 일치하는 한개 레코드 전체 가져오기
		String id = "test1";
		TestMybatisDTO dto = sqlSession.selectOne("test.getUser", id);
		// model 통해 view로 전달 "dto"
		model.addAttribute("dto", dto);
		return "spring04/update";
	}
	// update Pro 요청 처리를 hashmap으로 하기
	@RequestMapping("updatePro.do")
	public String updatePro(String pw, Integer age) {
		HashMap map = new HashMap();
		map.put("mapId", "test1");
		map.put("mapPw", pw);
		map.put("mapAge", age);
		
		int result = sqlSession.update("test.updateUser", map);
		System.out.println("result : "+result);
		return "spring04/updatePro";
	}
	
	/*
	// update pro 요청 처리 (dto로 처리)
	@RequestMapping("updatePro.do")
	public String updatePro(TestMybatisDTO dto) {
		// pw, age 넘어와 dto에 자동 바인딩된다.
		dto.setId("test2"); //세션이 없으니 dto로 문자열로 채운다
		int result = sqlSession.update("test.updateUser", dto);
		System.out.println("result : "+result);
		return "spring04/updatePro";
	}
	*/
	@RequestMapping("deleteUser.do")
	public String deleteUser() {
		sqlSession.delete("test.deleteUser", "test2");
		return "spring01/hello";
	}
}
