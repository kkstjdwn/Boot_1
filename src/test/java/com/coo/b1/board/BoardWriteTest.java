package com.coo.b1.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardWriteTest {
	
	@Autowired
	private noticeMapper mapper;
	
	@Test
	void test() throws Exception{
		for (int i = 0; i < 30; i++) {
			NoticeVO vo = new NoticeVO();
			vo.setTitle("title-"+i);
			vo.setContents("contents-"+i);
			vo.setWriter("co");
			mapper.noticeWrite(vo);
			Thread.sleep(100);
		}
	}

}
