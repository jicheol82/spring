package board.controller.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.model.dto.BoardDTO;
import board.service.bean.BoardService;
import board.service.bean.BoardServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService boardService = null;
	
	@RequestMapping("list.do")
	public String list(Integer pageNum, String sel, String search, Model model) throws Exception{
		// pageNum para없을때
		if(pageNum==null) pageNum=1;
		// 변수 선언
		int count = 0;
		List articlelist = boardService.getArticles(pageNum, sel, search);
		int number = (int) articlelist.get(articlelist.size()-1);
		articlelist.remove(articlelist.size()-1);
		// 글목록 가져오기
		count = boardService.getArticleCount(sel, search);
		// view에 값 보내주기
		model.addAttribute("count", count);
		model.addAttribute("number", number);
		model.addAttribute("articleList", articlelist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", BoardService.pageSize);
		model.addAttribute("pageBlock", BoardService.pageBlock);
		return "board/list";
	}
	
	@RequestMapping("content.do")
	public String content(int num, Model model) throws Exception{
		BoardDTO article = boardService.getArticle(num);
		model.addAttribute("article", article);
		return "board/content";
	}
	
	@RequestMapping("writeForm.do")
	public String writeForm() {
		return "board/writeForm";		
	}
	
	@RequestMapping("writePro.do")
	public String writePro(BoardDTO dto) throws SQLException {
		System.out.println("controller에서 ref : "+dto.getRef());
		boardService.insertArticle(dto);
		return "board/writePro";		
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm(int num, Model model) throws SQLException {
		BoardDTO article = boardService.getArticle(num);
		model.addAttribute("article", article);
		return "board/modifyForm";
	}
	@RequestMapping("modifyPro.do")
	public String modifyPro(BoardDTO dto, Model model) throws SQLException{
		int result = boardService.updateArticle(dto);
		model.addAttribute("result", result);
		return "board/modifyPro";
	}
	@RequestMapping("deleteForm.do")
	public String deleteForm() throws SQLException{
		return "board/deleteForm";
	}
	@RequestMapping("deletePro.do")
	public String deletePro(int num, String pw, Model model) throws SQLException{
		int result = boardService.deleteArticle(num, pw);
		model.addAttribute("result", result);
		return "board/deletePro";
	}
}
