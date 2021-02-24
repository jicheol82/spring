package member.model.dao;

import java.util.List;

import member.model.dto.MemberDTO;

public interface MemberDAO {
	//CRUD
	//회원가입
	public void insertMember(MemberDTO dto) throws Exception;
	//아이디 비번 확인
	public int idPwCheck(MemberDTO dto) throws Exception;
	//전체회원데이터조회
	public List selectAll() throws Exception;
	//회원한명데이저조회
	public MemberDTO selectMember(String id) throws Exception;
	//회원정보수정
	public void updateMember(MemberDTO dto) throws Exception;
	//회원탈퇴
	public void deleteMember(String id) throws Exception;
	//아이디 사용가능 여부
	public int idAvailCheck(String id) throws Exception;
}
