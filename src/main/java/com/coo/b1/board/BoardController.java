package com.coo.b1.board;

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
	
}
