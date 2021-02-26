package board.service.bean;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.model.dao.BoardDAO;
import board.model.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO = null;
	
	@Override
	public void insertArticle(BoardDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public int getArticleCount(String sel, String search) throws SQLException {
		int result = boardDAO.getArticleCount(sel, search);
		return result;
	}
	
	@Override
	public List getArticles(int pageNum, String sel, String search) throws SQLException {
		int articleCount = boardDAO.getArticleCount(sel, search);
		int start = (pageNum-1) * pageSize + 1;
		int end = (pageNum * pageSize)>articleCount?articleCount:(pageNum * pageSize);
		List list = boardDAO.getArticles(start, end, sel, search);
		list.add(start);
		return list;
	}

	@Override
	public BoardDTO getArticle(int num) throws SQLException {
		BoardDTO article = boardDAO.getArticle(num);
		return article;
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
