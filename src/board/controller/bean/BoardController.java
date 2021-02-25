package board.controller.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.service.bean.BoardService;

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
		System.out.println("pageNum: "+pageNum);
		int count = boardService.getArticleCount();
		model.addAttribute("count", count);
		System.out.println("count: "+count);
		int number = boardService.getEndRow(pageNum);
		model.addAttribute("number", number);
		System.out.println("number: "+number);
		List articlelist = boardService.getArticles(pageNum);
		model.addAttribute("articlelist", articlelist);
		System.out.println("컨트롤러의 list "+articlelist.size());
		//model.addAttribute("pageNum", pageNum);
		return "board/list";
	}
}
