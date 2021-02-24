package member.service.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import member.model.dao.MemberDAO;
import member.model.dto.MemberDTO;

public class MemberServiceImpl implements MemberService{

	// DAO 호출되게 자동주입
	@Autowired
	private MemberDAO memberDAO = null;
	//회원가입처리
	@Override
	public void addMember(MemberDTO dto) throws Exception {
		memberDAO.insertMember(dto);
	}

	@Override
	public int idPwCheck(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO getMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAllMembers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMember(MemberDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int idCheck(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeSessionAttr(String sessionName) {
		// TODO Auto-generated method stub
		
	}

}
