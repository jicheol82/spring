package board.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getArticleCount() throws SQLException {
		System.out.println("getArticleCount dao에 옴");
		int result = sqlSession.selectOne("board.getArticleCount");
		System.out.println("쿼리수행함");
		return result;
	}

	@Override
	public List getArticles(@RequestParam int start, @RequestParam int end) throws SQLException {
		List list = sqlSession.selectList("board.getArticles");
		System.out.println("list 사이즈 : "+list.size());
		return list;
	}

	@Override
	public BoardDTO getArticle(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO getArticleForUpdate(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateArticle(BoardDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArticle(int num, String pw) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
