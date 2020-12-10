package org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.jpa;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.QuoteDao;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Quote;
import org.springframework.stereotype.Repository;

@Repository
public class QuoteJpaDao extends GenericJpaDao<Quote> implements QuoteDao {

    public QuoteJpaDao(){
        super(Quote.class);
    }
}
