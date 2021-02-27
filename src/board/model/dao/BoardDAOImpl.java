package board.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSessionTemplate sqlSession = null;

	@Override
	public void insertArticle(BoardDTO dto) throws SQLException {
		
		sqlSession.update("board.insertArticle", dto);
	}

	@Override
	public int getArticleCount(String sel, String search) throws SQLException {
		Map map = new HashMap();
		map.put("sel", sel);
		map.put("search", search);
		int result = sqlSession.selectOne("board.getArticleCount", map);
		return result;
	}
	
	@Override
	public List getArticles(int start, int end, String sel, String search) throws SQLException {
		// 배열 리스트로도 매개변수 보내줄 수 있으나 map이 가장 많이 쓰이고 부르기 편한 듯
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("sel", sel);
		map.put("search", search);
		List list = sqlSession.selectList("board.getArticles", map);
		return list;
	}

	@Override
	public BoardDTO getArticle(int num) throws SQLException {
		sqlSession.update("board.readCount", num);
		BoardDTO article = sqlSession.selectOne("board.getArticle", num);
		return article;
	}

	@Override
	public BoardDTO getArticleForUpdate(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateArticle(BoardDTO dto) throws SQLException {
		// 쿼리문에 따로 resultType 선언 안해도 자동으로 update의 리턴타입은 int이다
		int result = sqlSession.update("board.updateArticle", dto);
		return result;
	}

	@Override
	public int deleteArticle(int num, String pw) throws SQLException {
		Map map = new HashMap();
		map.put("num", num);
		map.put("pw", pw);
		int result = sqlSession.delete("board.deleteArticle", map);
		return result;
	}
}
