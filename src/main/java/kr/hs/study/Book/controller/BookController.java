package kr.hs.study.Book.controller;

import kr.hs.study.Book.dto.BookDTO;
import kr.hs.study.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String list(Model model) {
        List<BookDTO> list = service.listAll();
        model.addAttribute("list1", list);
        return "list";
    }

    @GetMapping("/add")
    public String add_form() {
        return "add_form";
    }

    @PostMapping("/add_done")
    public String add_done(BookDTO dto) {
        service.insert(dto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        // select로 내용 가져오기
        BookDTO dto = service.readOne(id);
        model.addAttribute("dto", dto);
        return "update_form";
    }

    @PostMapping("/update_done")
    public String update_done(BookDTO dto) {
        service.update(dto);
        return "redirect:/";
    }
}
