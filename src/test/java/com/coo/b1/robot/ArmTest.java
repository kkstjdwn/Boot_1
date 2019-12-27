package com.coo.b1.robot;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.coo.head.Header;

@SpringBootTest
class ArmTest {
	
	@Autowired
	@Qualifier("la")
	private Arm arm1;
	
	@Autowired
	private Header header;
	

//	//@Autowired
//	@Resource(name = "rightArm")
//	private Arm arm2;
	

	@Test
	void test() {
		assertNotNull(header);
//		assertNotNull(arm2);

	}

}
