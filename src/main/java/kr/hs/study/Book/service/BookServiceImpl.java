package kr.hs.study.Book.service;

import kr.hs.study.Book.dao.BookDAO;
import kr.hs.study.Book.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO dao;

    @Override
    public void insert(BookDTO dto) {
        dao.insert(dto);
    }

    @Override
    public List<BookDTO> listAll() {
        return dao.listAll();
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public BookDTO readOne(String id) {
        return dao.readOne(id);
    }

    @Override
    public void update(BookDTO dto) {
        dao.update(dto);
    }


}
