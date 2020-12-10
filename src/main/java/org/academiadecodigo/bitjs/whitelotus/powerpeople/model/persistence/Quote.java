package org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "quote")
public class Quote extends AbstractModel {
    private String quote;
    private String author;

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
