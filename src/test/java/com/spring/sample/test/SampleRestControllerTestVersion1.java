package com.spring.sample.test;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;
import com.spring.sample.SampleRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleRestController.class)
public class SampleRestControllerTestVersion1 {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * 
	 * Test json response using skyscremer JSONAssert
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSampleUsingJsonAssert() throws Exception {
		MvcResult andReturn = mockMvc
				.perform(MockMvcRequestBuilders.get("/api/sample").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String expectedJson = "{'id':'123','name':'rahul','city':'gurgaon'}";
		String jsonResponse = andReturn.getResponse().getContentAsString();
		// this will return true if json returned will contain all the element defined in expected json
		JSONAssert.assertEquals(expectedJson, jsonResponse, false);
	}

	
	/**
	 * 
	 * Test test using jayway jsonpath
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSamplesUsingHemcrest() throws Exception {
		 String jsonResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/api/sample").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		
	}
	
	/**
	 * 
	 * Test test using jayway jsonpath + hamcrest
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSamplesUsingJaywayJsonPath() throws Exception {
		 mockMvc
				.perform(MockMvcRequestBuilders.get("/api/sample").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.city", Matchers.is("gurgaon")));
	}
	
	// test @Autowired

	// test @Value


}
