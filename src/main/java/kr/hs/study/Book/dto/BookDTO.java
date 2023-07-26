package kr.hs.study.Book.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String book_id;
    private String book_title;
    private String book_price;

    public String getBook_id() {
        return book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getBook_price() {
        return book_price;
    }
}
