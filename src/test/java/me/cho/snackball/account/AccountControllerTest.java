package me.cho.snackball.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc //필터, 시큐리티 포함
//@WebMvcTest(AccountController.class) //필터, 시큐리티 미포함, 컨트롤러 계층만 로드
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /sign-up - Sign Up Form Page")
    void signUpFormTest() throws Exception {
        mockMvc.perform(get("/sign-up"))
                .andExpect(status().isOk()) // HTTP 상태 코드 200 확인
                .andExpect(view().name("account/sign-up"))
                .andExpect(model().attributeExists("signUpForm")); // 반환된 뷰 이름 확인
    }
}