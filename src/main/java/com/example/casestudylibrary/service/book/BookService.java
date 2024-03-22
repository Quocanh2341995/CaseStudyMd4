package com.example.casestudylibrary.service.book;

import com.example.casestudylibrary.domain.Book;
import com.example.casestudylibrary.domain.Category;
import com.example.casestudylibrary.domain.enumration.EStatus;
import com.example.casestudylibrary.repository.IBookRepository;
import com.example.casestudylibrary.service.IExistsService;
import com.example.casestudylibrary.service.book.request.BookSaveRequest;
import com.example.casestudylibrary.service.book.response.BookDetailResponse;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService, IExistsService {
    private final IBookRepository bookRepository;

    private final ObjectMapper objectMapper;
    private final String ENTITY = "Book";

    public BookService(IBookRepository bookRepository, ObjectMapper objectMapper) {
        this.bookRepository = bookRepository;
        this.objectMapper = objectMapper;
    }
    @Override
    public Page<Book> findAllWithSearch(String search, Long categoryId, Pageable pageable) {
        search = "%" + search + "%";
        return bookRepository.findAllWithSearch(search, categoryId, pageable);
    }

    @Override
    public void create(BookSaveRequest request) {
        Book book = objectMapper.convertValue(request, Book.class);
        bookRepository.save(book);
    }

    @Override
    public void update(BookSaveRequest request, Long id) throws JsonMappingException {
        Book book = findBookById(id);
        objectMapper.updateValue(book, request);
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("%s with id %d not found", ENTITY, id)));
    }

    @Override
    public BookDetailResponse findBookDetailById(Long id) {
        Book book = findBookById(id);
        return new BookDetailResponse(book.getId(), book.getName(), book.getDescription(),book.getImage().getFileName(),book.getStatus(), book.getPublisher(), book.getCategory().getId());
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public void init() {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setName("book 1");
        book.setDescription("description 1");
        book.setImage(null);
        book.setStatus(EStatus.AVAILABLE.toString());
        book.setPublisher("publisher1");
        book.setCategory(null);
        books.add(book);

        Book book2 = new Book();
        book2.setName("book 2");
        book2.setDescription("description 2");
        book2.setImage(null);
        book2.setStatus(EStatus.AVAILABLE.toString());
        book2.setPublisher("publisher2");
        book2.setCategory(null);
        books.add(book);
        bookRepository.saveAll(books);
    }

    @Override
    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }

    @Override
    public boolean isService(String serviceName) {
        return "book".equals(serviceName);
    }
}
