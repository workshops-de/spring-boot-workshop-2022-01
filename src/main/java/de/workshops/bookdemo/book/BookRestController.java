package de.workshops.bookdemo.book;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = BookRestController.REQUEST_URL)
@RequiredArgsConstructor
@Slf4j
public class BookRestController {
    
    public static final String REQUEST_URL = "/book";
    
    private final BookService bookService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Iterable<Book> getAllBooks() {
        return bookService.loadAllBooks();
    }

    // @GetMapping("/{isbn}")
    // public Book getSingleBook(@PathVariable String isbn) throws BookException {
    //     return this.books.stream().filter(book -> hasIsbn(book, isbn)).findFirst().orElseThrow( () -> new BookException("wrong isbn"));
    // }

    // @GetMapping(params = "author")
    // public Book searchBookByAuthor(@RequestParam String author) throws Exception {
    //     return this.books.stream().filter(book -> hasAuthor(book, author)).findFirst().orElseThrow(Exception::new);
    // }

    // @PostMapping("/search")
    // public List<Book> searchBooks(@RequestBody BookSearchRequest request) {
    //     return this.books.stream()
    //             .filter(book -> hasAuthor(book, request.getAuthor()))
    //             .filter(book -> hasIsbn(book, request.getIsbn()))
    //             .collect(Collectors.toUnmodifiableList());
    // }

    // private boolean hasIsbn(Book book, String isbn) {
    //     return book.getIsbn().equals(isbn);
    // }

    // private boolean hasAuthor(Book book, String author) {
    //     return book.getAuthor().contains(author);
    // }
}
