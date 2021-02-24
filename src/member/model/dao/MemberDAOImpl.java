package member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import member.model.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	//sqlSession 주입받아 아래 메서드에서 sqlSession.se~사용
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	// autowired가 아닌 setmethod를 이용하여 DI 가능
	// @autowired를 빼고 아래 입력
	/*
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	*/
	// 또는 기본생성자에 sqlSessionTmeplate sqlSession을 매개변수로 하고
	// xml에는 contsrutor-arg로 선언
	
	@Override
	public void insertMember(MemberDTO dto) throws Exception {
		sqlSession.insert("member.insertMember", dto);
	}

	@Override
	public int idPwCheck(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO selectMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int idAvailCheck(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
