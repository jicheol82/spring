package test.mybatis.bean;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.model.TestMybatisDTO;

@Controller
public class TestMybatis2 {
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	@RequestMapping("selectIf.do")
	public String selectIf() {
//		String id = "test3";
//		int count = sqlSession.selectOne("myba.selectIf", id);
//		System.out.println(count);
//		count = sqlSession.selectOne("myba.selectIf");
//		System.out.println(count);
//		
		// select count(*) from test where pw in (,,,---)
//		List list = new ArrayList();
//		list.add("0000");
//		list.add("1111");
//		list.add("1234");
//		
//		int count = sqlSession.selectOne("myba.selectFor", list);
//		System.out.println(count);
		
		// selectkey 사용을 위한 예
//		TestMybatisDTO dto = new TestMybatisDTO();
//		dto.setId("test3");
//		dto.setPw("0000");
//		sqlSession.update("myba.updateKey", dto);
//		System.out.println(dto.getAge()); // 자동으로 값이 binding된다
		
		// board_seq사용
		TestMybatisDTO dto = new TestMybatisDTO();
		dto.setPw("asdf");
		dto.setAge(100);
		sqlSession.insert("myba.insertKey", dto);
		System.out.println("id :"+dto.getId());
		return "spring05/select";
	}
}
