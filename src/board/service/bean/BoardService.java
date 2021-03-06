package board.service.bean;

import java.sql.SQLException;
import java.util.List;

import board.model.dto.BoardDTO;

public interface BoardService {
	static int pageSize = 5;
	static int pageBlock = 5;
	// 게시글 저장
	public void insertArticle(BoardDTO dto) throws SQLException;
	// 검색 글 개수 검색
	public int getArticleCount(String sel, String search) throws SQLException;
	// 검색 게시글 범위 지정 가져오기 
	public List getArticles(int pageNum, String sel, String search) throws SQLException;
	// 게시글 한개 정보 가져오기 (조회수up O)
	public BoardDTO getArticle(int num) throws SQLException;
	// 게시글 한개 정보 가져오기 (조회수up X)
	public BoardDTO getArticleForUpdate(int num) throws SQLException;
	// 게시글 수정 
	public int updateArticle(BoardDTO dto) throws SQLException;
	// 게시글 삭제
	public int deleteArticle(int num, String pw) throws SQLException;
}
