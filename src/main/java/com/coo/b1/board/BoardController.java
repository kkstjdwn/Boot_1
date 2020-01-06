package com.coo.b1.board;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.coo.b1.util.SqlPager;

@Controller
@RequestMapping("/board/**")
public class BoardController {
	
	@Autowired
	private NoticeService service;
	
	@GetMapping("NoticeWrite")
	public String boardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
	@ModelAttribute("noticeVO")
	public NoticeVO getNoticeVO() throws Exception{
		return new NoticeVO();
	}
	
	@PostMapping("NoticeWrite")
	public ModelAndView noticeWrite(@Valid NoticeVO noticeVO, BindingResult br,MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = 0;
		if (br.hasErrors()) {
			mv.setViewName("board/boardWrite");
		}else {
			result = service.noticeWrite(noticeVO,files);
			if (result > 0) {				
				mv.addObject("msg", "작성 완료");
				mv.addObject("path", "/");
				mv.setViewName("common/msg");
			}else {
				mv.addObject("msg", "다시 작성해주세요");
				mv.addObject("path", "/board/NoticeWrite");
				mv.setViewName("common/msg");	
			}
		}
		
		
		return mv;
	}
	
	@GetMapping("NoticeList")
	public ModelAndView noticeList(SqlPager pager) throws Exception{

		pager.makeRow(pager.getCurPage(), 8);
		pager.makePager(service.countList(), 10);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.noticeList(pager));
		mv.addObject("pager", pager);
		mv.setViewName("/board/boardList");
		
		return mv;
	}
	
	@GetMapping("NoticeSearch")
	public ModelAndView noticeSearch(SqlPager pager) throws Exception {
		pager.makeRow(pager.getCurPage(), 8);
		pager.makePager(service.searchList(pager), 10);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.noticeSearch(pager));
		mv.addObject("pager", pager);
		mv.setViewName("/board/boardList");
		
		return mv;
	}
	
	@GetMapping("NoticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();

		mv.addObject("notice", service.noticeSelect(noticeVO));
		mv.addObject("list", service.getFiles(noticeVO));
		mv.setViewName("/board/boardSelect");
		
		return mv;
	}
	
}
