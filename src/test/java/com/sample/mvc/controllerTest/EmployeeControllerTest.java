package com.sample.mvc.controllerTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sample.mvc.controller.EmployeeController;
import com.sample.mvc.model.EmployeeCommand;
import com.sample.mvc.service.EmployeeService;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration(classes=BaseTestConfig.class)
@ContextConfiguration(locations = {"classpath*:/WEB-INF/employee-servlet.xml"})

//@Transactional
public class EmployeeControllerTest {
	
//	@Autowired
//	private WebApplicationContext wac;
	
	
	 @Mock
	 private EmployeeService employeeService;
	    @InjectMocks
	    private EmployeeController employeeController;
	 
	    private MockMvc mockMvc;
	 
	    @Before
	    public void setup() {
	 
	        // Process mock annotations
	        MockitoAnnotations.initMocks(this);
	 
	        // Setup Spring test in standalone mode
	        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
}
	    
	    /* @Test
	    public void testAddEmployee() throws Exception {
	     
	    	     
	        this.mockMvc.perform(post("/jsp/add")
	                .param("code", "101")
	                .param("name", "mvcfirst")
	                .param("city", "mvclastname"))
	                .andExpect(view().name("redirect:/list"))
	                .andExpect(model().attributeExists("employeeCommand"));
					 Assert.fail();
	     
	    } */
	    /*test method */
	    @Test
		public void findById()
				throws Exception {
	    	
	    	 EmployeeCommand emp = new EmployeeCommand();
	    	 emp.setCode(105);
            emp.setName("vikas");
            emp.setCity("pune");
			

			this.mockMvc
					.perform(post("/edit/{code}", 105))
					.andExpect(view().name("edit"))
					.andExpect(forwardedUrl("edit"));
//					.andExpect(model().attribute("employee",  105 /*hasProperty("code", is(105))*/))
					

			
		}
}
