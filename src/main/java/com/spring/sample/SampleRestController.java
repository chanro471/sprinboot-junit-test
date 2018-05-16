package com.spring.sample;

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
		return ResponseEntity.status(HttpStatus.OK).body(new SampleDTO("rahul","123","gurgaon"));
	}
}
