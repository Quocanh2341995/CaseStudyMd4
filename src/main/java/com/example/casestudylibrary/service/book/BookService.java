package com.example.casestudylibrary.service.book;

import com.example.casestudylibrary.domain.Book;
import com.example.casestudylibrary.domain.Category;
import com.example.casestudylibrary.domain.File;
import com.example.casestudylibrary.domain.dto.req.BookReqDto;
import com.example.casestudylibrary.domain.dto.res.BookResDto;
import com.example.casestudylibrary.domain.enumration.EStatus;
import com.example.casestudylibrary.repository.FileRepository;
import com.example.casestudylibrary.repository.IBookRepository;
import com.example.casestudylibrary.repository.ICategoryRepository;
import com.example.casestudylibrary.service.ICategoryService;
import com.example.casestudylibrary.service.IExistsService;
import com.example.casestudylibrary.service.book.request.BookSaveRequest;
import com.example.casestudylibrary.service.book.response.BookDetailResponse;
import com.example.casestudylibrary.service.book.response.BookListResponse;
import com.example.casestudylibrary.service.file.UploadFileService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService, IExistsService {
    private final UploadFileService uploadFileService;
    private final IBookRepository bookRepository;
    private final ICategoryRepository categoryRepository;
    private final ObjectMapper objectMapper;
    private final String ENTITY = "Book";

    public BookService(IBookRepository bookRepository, ObjectMapper objectMapper, UploadFileService uploadFileService, ICategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.objectMapper = objectMapper;
        this.uploadFileService = uploadFileService;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Page<Book> findAllWithSearch(String search, Long categoryId, Pageable pageable) {
        search = "%" + search + "%";
//        return bookRepository.findAllWithSearch(search, categoryId, pageable);
        return null;
    }

    @Override
    public void create(BookReqDto request, MultipartFile poster) throws IOException {
        File file = uploadFileService.saveAvatar(poster);
        Book book = objectMapper.convertValue(request, Book.class);
        Category category = categoryRepository.findById(Long.valueOf(request.getCategoryId())).get();
        book.setCategory(category);
        book.setPoster(file);
        bookRepository.save(book);
    }

    @Override
    public void update(BookReqDto request, Long id, MultipartFile poster) throws IOException {
        File file = null;
        if(poster != null ) {
            file = uploadFileService.saveAvatar(poster);
        }

        Book book = findBookById(id);
        book.setPoster(file);
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
        return new BookDetailResponse(book.getId(), book.getName(), book.getDescription(),book.getPoster().getFileName(),book.getStatus(), book.getPublisher(), book.getCategory().getId());
    }

    @Override
    public List<BookListResponse> findAll() {
        return bookRepository.getAllBookResDto();
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
