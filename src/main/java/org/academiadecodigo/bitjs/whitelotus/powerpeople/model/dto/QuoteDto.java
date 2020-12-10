package org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuoteDto {

    private Integer id;

    @NotNull(message = "Quote is mandatory")
    @NotBlank(message = "Quote is mandatory")
    @Size(min = 6, max = 400)
    private String quote;

    @NotNull(message = "Author is mandatory")
    @NotBlank(message = "Author is mandatory")
    @Size(min = 3, max = 64)
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
