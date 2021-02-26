package board.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import board.model.dto.BoardDTO;

public interface BoardDAO {

	// 게시글 저장
	public void insertArticle(BoardDTO dto) throws SQLException;
	// 검색 글 개수 검색
	public int getArticleCount(String sel, String search) throws SQLException;
	// 게시글 범위 지정 가져오기 
	public List getArticles(int start, int end, String sel, String search) throws SQLException;
	// 게시글 한개 정보 가져오기 (조회수up O)
	public BoardDTO getArticle(int num) throws SQLException;
	// 게시글 한개 정보 가져오기 (조회수up X)
	public BoardDTO getArticleForUpdate(int num) throws SQLException;
	// 게시글 수정 
	public int updateArticle(BoardDTO dto) throws SQLException;
	// 게시글 삭제
	public int deleteArticle(int num, String pw) throws SQLException;
	
}






