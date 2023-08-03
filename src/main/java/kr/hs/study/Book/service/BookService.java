package kr.hs.study.Book.service;

import kr.hs.study.Book.dto.BookDTO;

import java.util.List;

public interface BookService {
    public void insert(BookDTO dto);

    public List<BookDTO> listAll();

    public void delete(String id);

    public BookDTO readOne(String id);
    public void update(BookDTO dto);
}
