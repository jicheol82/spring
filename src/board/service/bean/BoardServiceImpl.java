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
	public int getArticleCount() throws SQLException {
		int result = boardDAO.getArticleCount();
		return result;
	}
	
	@Override
	public int getStartRow(int pageNum) {
		int result = (pageNum-1) * pageSize + 1;
		return result;
	}
	
	@Override
	public int getEndRow(int pageNum) throws SQLException{
		int result = (pageNum * pageSize)>getArticleCount()?getArticleCount():(pageNum * pageSize);
		return result;
	}

	@Override
	public List getArticles(int pageNum) throws SQLException {
		//if (pageNum==0) pageNum=1;
		int start =getStartRow(pageNum);
		int end = getEndRow(pageNum);
		List list = boardDAO.getArticles(start, end);
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
