package com.demo.mappingsdemo.onetomany.service;

import com.demo.mappingsdemo.exception.BookNotFoundException;
import com.demo.mappingsdemo.onetomany.dao.BookDao;
import com.demo.mappingsdemo.onetomany.dao.PageDao;
import com.demo.mappingsdemo.onetomany.dto.BookDto;
import com.demo.mappingsdemo.onetomany.dto.PageDto;
import com.demo.mappingsdemo.onetomany.mapper.BookMapper;
import com.demo.mappingsdemo.onetomany.mapper.PageMapper;
import com.demo.mappingsdemo.onetomany.model.Book;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

  private final BookDao bookDao;

  private final BookMapper bookMapper;

  private final PageMapper pageMapper;

  private final PageDao pageDao;

  public BookDto createBook(BookDto bookDto){
    Book book = bookMapper.map(bookDto);
    book = bookDao.save(book);
    return bookMapper.map(book);
  }

  public BookDto getBook(Long bookId){
    Book book = getBookById(bookId);
     BookDto v = bookMapper.map(book);
     log.info("AAAAAAA {}", v.getPages().size());
     return v;
  }

  public BookDto updateBook(Long bookId, BookDto bookDto){
    Book book= getBookById(bookId);
    bookMapper.updateBookFromBookDto(bookDto, book);
    book = bookDao.save(book);
    return bookMapper.map(book);
  }

  public void deleteBook(Long bookId){
    bookDao.deleteById(bookId);
  }

  public Book getBookById(Long bookId){
    Optional<Book> book  = bookDao.findById(bookId);
    book.orElseThrow(() -> new BookNotFoundException("Book id "+ bookId + " not found" ));
    return book.get();
  }

  public List<BookDto> getAllBooks(){
    List<Book> carList = bookDao.findAll();
    return bookMapper.map(carList);
  }

  public List<PageDto> getAllPagesByBook(Long bookId){
    return pageMapper.map(pageDao.getAllPagesByBook(bookId));
  }


}
