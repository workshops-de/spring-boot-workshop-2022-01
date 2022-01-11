package de.workshops.bookdemo.book;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BookRestControllerMockitoTest {
    
    //@Autowired
    @InjectMocks
    private BookRestController bookRestController;

    //@MockBean
    @Mock
    private BookService bookService;



    @Test
    void testWithMock() {
        Mockito.when(bookService.loadAllBooks()).thenReturn(null);

        assertNull(bookRestController.getAllBooks());
    }
}
