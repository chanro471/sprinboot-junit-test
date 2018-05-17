package com.spring.sample;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class SampleRestController {

	@RequestMapping(value="/sample", method=RequestMethod.GET)
	public ResponseEntity<?> getSamples(){
		SampleDTO dto =  new SampleDTO();
		dto.setCity("gurgaon");
		dto.setId("123");
		dto.setName("rahul");
		dto.setProjects(Arrays.asList("ug","ng"));
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
}
