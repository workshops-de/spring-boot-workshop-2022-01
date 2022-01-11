package de.workshops.bookdemo.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class BookRestControllerTest {

    @Autowired
    private BookRestController bookRestController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    void getAllBooksByMethod() {
        assertEquals(3, bookRestController.getAllBooks().size());
    }
    
    @Test
    public void getAllBooks() throws Exception {
        // use static imports
        mockMvc.perform(MockMvcRequestBuilders.get(BookRestController.REQUEST_URL))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title", CoreMatchers.is("Clean Code")));
    }

    @Test
    public void getAllBooksWithMvcResult() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(BookRestController.REQUEST_URL)).andReturn();
        String jsonPayload = result.getResponse().getContentAsString();
        List<Book> books = objectMapper.readValue(jsonPayload, new TypeReference<List<Book>>(){});
        assertEquals(3, books.size());
        assertEquals("Clean Code", books.get(1).getTitle());
            
                

    }
}
