package com.example.JavaShogi.JavaShogicontroller;

// 正しいimport文
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.example.JavaShogi.config.SecurityConfig;
import com.example.JavaShogi.controller.LoginController;
import com.example.JavaShogi.login.AppUserDetailsService;

@WebMvcTest(LoginController.class)
@Import(SecurityConfig.class)
@TestPropertySource(properties = {
    "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration"
})
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserDetailsService appUserDetailsService;

    @Test
    public void testLoginPage() throws Exception {
        mockMvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser(username = "user", roles = "USER")
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/home"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"));
    }

    @Test
    @WithMockUser(username = "testuser", roles = "USER")
    public void testGamePageShowsUsername() throws Exception {
        mockMvc.perform(get("/game"))
            .andExpect(status().isOk())
            .andExpect(view().name("game"))
            .andExpect(model().attribute("username", "testuser"))
            .andExpect(content().string(org.hamcrest.Matchers.containsString("<span>testuser</span>")))
            .andExpect(content().string(org.hamcrest.Matchers.containsString("こんにちは、")));
    }

    @Test
    public void testGamePageAsAnonymous() throws Exception {
        mockMvc.perform(get("/game"))
            .andExpect(status().isOk())
            .andExpect(view().name("game"))
            .andExpect(model().attribute("username", "ゲスト"))
            .andExpect(content().string(org.hamcrest.Matchers.containsString("<span>ゲスト</span>")))
            .andExpect(content().string(org.hamcrest.Matchers.containsString("こんにちは、")));
    }
}