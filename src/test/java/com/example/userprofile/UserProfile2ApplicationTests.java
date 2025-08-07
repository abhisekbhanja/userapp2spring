package com.example.userprofile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.userprofile.model.Category;
import com.example.userprofile.repository.CategoryRepository;
import com.example.userprofile.service.MyService;

@SpringBootTest
class UserProfile2ApplicationTests {
	
	@Autowired
	MyService myService;

	@Test
	void contextLoads() {
	}
	
	
	


}
