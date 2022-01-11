package de.workshops.bookdemo.book;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/book")
public class BookRestController {
    
    private final ObjectMapper mapper;

    private final ResourceLoader resourceLoader;

    private List<Book> books;
    
    public BookRestController(ObjectMapper mapper, ResourceLoader resourceLoader) {
        this.mapper = mapper;
        this.resourceLoader = resourceLoader;
    }
    
    @PostConstruct
    public void init() throws IOException {
        final var resource = resourceLoader.getResource("classpath:books.json");
        this.books = mapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }

    @GetMapping
    public List<Book> getAllAbooks() {
        return this.books;
    }
}
