package de.workshops.bookdemo.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookJpaRepository bookJpaRepository;

    //@Test
    void testFindAll() {
        List<Book> books = bookRepository.findAllBooks();
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Test
    void testCreateBook() {
        Book book = Book.builder()
            //.author("autor")
            .description("desc")
            .isbn("1234567890")
            .title("Der Titel")
            .build();
        
        assertNull(book.getId());
        Book book2 = bookJpaRepository.save(book);
        assertNotNull(book.getId());

        Optional<Book> dbResult = bookJpaRepository.findById(book.getId());
        assertTrue(dbResult.isPresent());
        assertEquals("1234567890", dbResult.get().getIsbn());        
        
        Book dbResult2 = bookJpaRepository.findByIsbn("1234567890");
        assertNotNull(dbResult2);
        
    }
}
