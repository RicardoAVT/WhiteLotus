package org.academiadecodigo.bitjs.whitelotus.powerpeople.converters;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.QuoteDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Quote;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuoteDtoToQuote implements Converter<QuoteDto, Quote> {

    private QuoteService quoteService;

    @Autowired
    public void setQuoteService(QuoteService quoteService) {
        this.quoteService = quoteService;
    }


    @Override
    public Quote convert(QuoteDto quoteDto) {
        Quote quote = (quoteDto.getId() != null ? quoteService.get(quoteDto.getId()) : new Quote());

        quote.setQuote(quoteDto.getQuote());
        quote.setAuthor(quoteDto.getAuthor());

        return quote;
    }
}
