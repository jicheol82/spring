package board.controller.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.service.bean.BoardService;
import board.service.bean.BoardServiceImpl;

@Controller
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService boardService = null;
	
	@RequestMapping("list.do")
	public String list(Integer pageNum, Model model) throws Exception{
		if(pageNum==null) {
			pageNum=1;
		}
		int count = boardService.getArticleCount();
		model.addAttribute("count", count);
		int number = boardService.getStartRow(pageNum);
		model.addAttribute("number", number);
		List articlelist = boardService.getArticles(pageNum);
		model.addAttribute("articleList", articlelist);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", BoardService.pageSize);
		model.addAttribute("pageBlock", BoardService.pageBlock);
		
		
		
		return "board/list";
	}
	
	@RequestMapping("list.do")
	public String list(Integer pageNum, String sel, String search, Model model) throws Exception{
		System.out.println("검색어로");
		return "board/list";
	}
}
