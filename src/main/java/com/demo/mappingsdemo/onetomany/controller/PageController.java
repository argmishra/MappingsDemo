package com.demo.mappingsdemo.onetomany.controller;

import com.demo.mappingsdemo.onetomany.dto.PageDto;
import com.demo.mappingsdemo.onetomany.service.PageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pages")
@Slf4j
@RequiredArgsConstructor
public class PageController {

  private final PageService pageService;

  @PutMapping("/{pageId}")
  public ResponseEntity<PageDto> updatePage(@PathVariable Long pageId, @RequestBody PageDto pageDto){
    log.info("Update Page Request for id : {}", pageId);
    PageDto page = pageService.updatePage(pageId, pageDto);
    return new ResponseEntity<>(page, HttpStatus.OK);
  }

  @GetMapping("/{pageId}")
  public ResponseEntity<PageDto> getPage(@PathVariable Long pageId){
    log.info("Get Page Request for id : {}", pageId);
    PageDto page = pageService.getPage(pageId);
    return new ResponseEntity<>(page, HttpStatus.OK);
  }

  @DeleteMapping("/{pageId}")
  public ResponseEntity<Void> deletePage(@PathVariable Long pageId){
    log.info("Delete Page Request for id : {}", pageId);
    pageService.deletePage(pageId);
    return new ResponseEntity(HttpStatus.OK);
  }
}
