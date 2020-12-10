package org.academiadecodigo.bitjs.whitelotus.powerpeople.service;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.dao.QuoteDao;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

    private QuoteDao quoteDao;

   @Autowired
    public void setQuoteDao(QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }

    @Override
    public Quote get(Integer id){
       return quoteDao.findById(id);
    }


}
