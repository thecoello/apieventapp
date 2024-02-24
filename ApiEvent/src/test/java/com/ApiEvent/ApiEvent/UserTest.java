package com.ApiEvent.ApiEvent;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ApiEvent.ApiEventApplication;
import com.ApiEvent.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiEventApplication.class)
@AutoConfigureMockMvc
public class UserTest  {
	
    @Autowired
	private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @MockBean
    private UsersService usersService;
    
	ObjectMapper mapper = new ObjectMapper();


    @Before
	public void setup() {
    	MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    
	
	@Test
	void crearUsuario() throws Exception{
		
		JSONObject user = new JSONObject();

		user.put("nombre","Manuel");
		user.put("apellido","Guerra");
		user.put("email", "email@gmail.com");
		user.put("usuario", "thecoello");
		user.put("password","123456");
		user.put("userTerms", "aceptado");
		
		Mockito.when(usersService.postUser(ArgumentMatchers.any())).thenReturn(1L);

		String createUser = mapper.writeValueAsString(user);
		
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(createUser).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	
	@Test
	void nombreRequerido() throws Exception{
		
		JSONObject user = new JSONObject();

		user.put("apellido","Guerra");
		user.put("email", "email@gmail.com");
		user.put("usuario", "thecoello");
		user.put("password","123456");
		user.put("userTerms", "aceptado");
		
		Mockito.when(usersService.postUser(ArgumentMatchers.any())).thenReturn(1L);

		String createUser = mapper.writeValueAsString(user);
		
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(createUser).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	void apellidoRequerido() throws Exception{
		
		JSONObject user = new JSONObject();

		user.put("nombre","Manuel");
		user.put("email", "email@gmail.com");
		user.put("usuario", "thecoello");
		user.put("password","123456");
		user.put("userTerms", "aceptado");
		
		Mockito.when(usersService.postUser(ArgumentMatchers.any())).thenReturn(1L);

		String createUser = mapper.writeValueAsString(user);
		
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(createUser).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	void emailRequerido() throws Exception{
		
		JSONObject user = new JSONObject();

		user.put("nombre","Manuel");
		user.put("apellido","Guerra");
		user.put("usuario", "thecoello");
		user.put("password","123456");
		user.put("userTerms", "aceptado");
		
		Mockito.when(usersService.postUser(ArgumentMatchers.any())).thenReturn(1L);

		String createUser = mapper.writeValueAsString(user);
		
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(createUser).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	void usuarioRequerido() throws Exception{
		
		JSONObject user = new JSONObject();

		user.put("nombre","Manuel");
		user.put("apellido","Guerra");
		user.put("email", "email@gmail.com");
		user.put("password","123456");
		user.put("userTerms", "aceptado");
		
		Mockito.when(usersService.postUser(ArgumentMatchers.any())).thenReturn(1L);

		String createUser = mapper.writeValueAsString(user);
		
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(createUser).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	void passwordRequerido() throws Exception{
		
		JSONObject user = new JSONObject();

		user.put("nombre","Manuel");
		user.put("apellido","Guerra");
		user.put("email", "email@gmail.com");
		user.put("usuario","thecoello");
		user.put("userTerms", "aceptado");
		
		Mockito.when(usersService.postUser(ArgumentMatchers.any())).thenReturn(1L);

		String createUser = mapper.writeValueAsString(user);
		
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(createUser).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	@Test
	void terminosRequerido() throws Exception{
		
		JSONObject user = new JSONObject();

		user.put("nombre","Manuel");
		user.put("apellido","Guerra");
		user.put("email", "email@gmail.com");
		user.put("usuario","thecoello");
		user.put("password","123456");
		
		Mockito.when(usersService.postUser(ArgumentMatchers.any())).thenReturn(1L);

		String createUser = mapper.writeValueAsString(user);
		
		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(createUser).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
	
	
}