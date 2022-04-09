package com.demo.mappingsdemo.onetomany.service;

import com.demo.mappingsdemo.exception.PageNotFoundException;
import com.demo.mappingsdemo.onetomany.dao.PageDao;
import com.demo.mappingsdemo.onetomany.dto.BookDto;
import com.demo.mappingsdemo.onetomany.dto.PageDto;
import com.demo.mappingsdemo.onetomany.mapper.BookMapper;
import com.demo.mappingsdemo.onetomany.mapper.PageMapper;
import com.demo.mappingsdemo.onetomany.model.Book;
import com.demo.mappingsdemo.onetomany.model.Page;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PageService {

  private final PageDao pageDao;

  public final BookService bookService;

  public final PageMapper pageMapper;

  public final BookMapper bookMapper;

  public PageDto createPage(Long bookId, PageDto pageDto){
    Book book = bookService.getBookById(bookId);
    Page page = pageMapper.map(pageDto);
    page.setBook(book);
    page = pageDao.save(page);
    return pageMapper.map(page);
  }

  public PageDto getPage(Long pageId){
    Page page = getPageById(pageId);
    return pageMapper.map(page);
  }

  public PageDto updatePage(Long pageId, PageDto pageDto){
    Page page = getPageById(pageId);
    pageMapper.updatePageFromPageDto(pageDto, page);
    page = pageDao.save(page);
    return pageMapper.map(page);
  }

  public void deletePage(Long pageId){
    pageDao.deleteById(pageId);
  }

  private Page getPageById(Long pageId){
    Optional<Page> page  = pageDao.findById(pageId);
    page.orElseThrow(() -> new PageNotFoundException("Page id "+ pageId + " not found" ));
    return page.get();
  }

  public BookDto getBookFromPage(Long pageId){
    Page page = getPageById(pageId);
    Book book = bookService.getBookById(page.getBook().getId());
    return bookMapper.map(book);
  }


}
