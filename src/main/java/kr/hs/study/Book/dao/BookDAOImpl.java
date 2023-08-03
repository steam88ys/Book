package kr.hs.study.Book.dao;

import kr.hs.study.Book.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void insert(BookDTO dto) {
        String sql = "insert into book values(?,?,?)";
        jdbc.update(sql, dto.getBook_id(), dto.getBook_title(), dto.getBook_price());
    }

    @Override
    public List<BookDTO> listAll() {
        String sql = "select * from book order by book_id asc";
        List<BookDTO> list = jdbc.query(sql, new BeanPropertyRowMapper<>(BookDTO.class));
        System.out.println(list);
        return list;
    }

    @Override
    public void delete(String id) {
        String sql = "delete from book where book_id = "+id;
        jdbc.update(sql);
    }

    @Override
    public BookDTO readOne(String id) {
        String sql = "select * from book where book_id="+id;
        // sql의 결과를 BookDTO클래스에 넣겠다
        BookDTO dto = jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(BookDTO.class));
        return dto;
    }

    @Override
    public void update(BookDTO dto) {
        System.out.println("DTO: "+dto);
        System.out.println(dto.getBook_id());
        String sql = "update book set book_title=?, book_price=? where book_id=?";
        jdbc.update(sql, dto.getBook_title(), dto.getBook_price(), dto.getBook_id());
    }

}
