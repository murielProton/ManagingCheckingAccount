package com.example;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controller.TypeOfTransactionEnumMapingController;
import com.example.model.enums.Author;
import com.example.model.enums.ThemeGeneral;
import com.example.model.enums.ThemeSub;
import com.example.model.enums.TypeOfTransaction;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EnumMappingIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPassingLowerCaseEnumConstant_thenConvert_TypeOfTransaction() throws Exception {
        mockMvc.perform(get("/enummapping/type-of-transaction/get?typeOfTransaction=tip"))
            .andExpect(status().isOk())
            .andExpect(content().string(TypeOfTransaction.TIP.name()));
    }
    @Test
    public void whenPassingLowerCaseEnumConstant_thenConvert_ThemeGeneral() throws Exception {
        mockMvc.perform(get("/enummapping/theme-general/get?themeGeneral=travel"))
            .andExpect(status().isOk())
            .andExpect(content().string(ThemeGeneral.TRAVEL.name()));
    }
    @Test
    public void whenPassingLowerCaseEnumConstant_thenConvert_ThemeSub() throws Exception {
        mockMvc.perform(get("/enummapping/theme-sub/get?themeSub=construction_work"))
            .andExpect(status().isOk())
            .andExpect(content().string(ThemeSub.CONSTRUCTION_WORK.name()));
    }
    @Test
    public void whenPassingLowerCaseEnumConstant_thenConvert_Author() throws Exception {
        mockMvc.perform(get("/enummapping/author/get?author=muriel"))
            .andExpect(status().isOk())
            .andExpect(content().string(Author.MURIEL.name()));
    }

}
