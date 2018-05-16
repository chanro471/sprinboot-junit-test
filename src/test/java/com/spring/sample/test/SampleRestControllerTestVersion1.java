package com.spring.sample.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.spring.sample.SampleRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleRestController.class)
public class SampleRestControllerTestVersion1 {

	@Autowired
	private MockMvc  mockMvc;
	
	
	
	/**
	 * Test json response using skyscremer JSONAssert
	 * @throws Exception
	 */
	@Test
	public void testGetAllSamples() throws Exception{

		MvcResult andReturn = mockMvc.perform(get("/api/sample").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		
		String expectedJson = "{'id':'123','name':'rahul','city':'gurgaon'}";
		
		String jsonResponse = andReturn.getResponse().getContentAsString();
		JSONAssert.assertEquals(expectedJson, jsonResponse, true);
	
	}
	
	// test using hemcrest json
	
	// test @Autowired 
	
	// test @Value
	
	
}
