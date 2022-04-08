package com.demo.mappingsdemo.onetomany.controller;

import com.demo.mappingsdemo.onetomany.dto.BookDto;
import com.demo.mappingsdemo.onetomany.dto.PageDto;
import com.demo.mappingsdemo.onetomany.service.BookService;
import com.demo.mappingsdemo.onetomany.service.PageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@Slf4j
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  private final PageService pageService;

  @PostMapping
  public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
    log.info("Create Book Request");
    BookDto book = bookService.createBook(bookDto);
    return new ResponseEntity<>(book, HttpStatus.CREATED);
  }

  @PutMapping("/{bookId}")
  public ResponseEntity<BookDto> updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto){
    log.info("Update Book Request for id : {}", bookId);
    BookDto book = bookService.updateBook(bookId, bookDto);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @GetMapping("/{bookId}")
  public ResponseEntity<BookDto> getBook(@PathVariable Long bookId){
    log.info("Get Book Request for id : {}", bookId);
    BookDto book = bookService.getBook(bookId);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @DeleteMapping("/{bookId}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long bookId){
    log.info("Delete Book Request for id : {}", bookId);
    bookService.deleteBook(bookId);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/{bookId}/page")
  public ResponseEntity<PageDto> createPage(@RequestBody PageDto pageDto, @PathVariable Long bookId){
    log.info("Create Page Request for bookId : {}", bookId);
    PageDto page = pageService.createPage(bookId, pageDto);
    return new ResponseEntity<>(page, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks(){
    log.info("Get All Book Request ");
    List<BookDto> bookList = bookService.getAllBooks();
    return new ResponseEntity<>(bookList, HttpStatus.OK);
  }

}
