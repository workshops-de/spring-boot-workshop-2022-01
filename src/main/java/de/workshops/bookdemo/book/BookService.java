package de.workshops.bookdemo.book;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final BookJpaRepository bookRepository;

	public Iterable<Book> loadAllBooks() {
		return bookRepository.findAll();
	}
}
