package kr.hs.study.Book.controller;

import kr.hs.study.Book.dto.BookDTO;
import kr.hs.study.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/add")
    public String add_form() {
        return "add_form";
    }

    @PostMapping("/add_done")
    public String add_done(BookDTO dto) {
        System.out.println("id: "+dto.getBook_id());
        System.out.println("title: "+dto.getBook_title());
        System.out.println("price: "+dto.getBook_price());
        service.insert(dto);
        return "result";
    }
}
