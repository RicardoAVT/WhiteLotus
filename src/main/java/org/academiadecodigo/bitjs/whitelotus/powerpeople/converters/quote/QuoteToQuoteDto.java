package org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.quote;

import org.academiadecodigo.bitjs.whitelotus.powerpeople.converters.AbstractConverter;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.dto.QuoteDto;
import org.academiadecodigo.bitjs.whitelotus.powerpeople.model.persistence.Quote;
import org.springframework.stereotype.Component;

@Component
public class QuoteToQuoteDto extends AbstractConverter<Quote, QuoteDto> {

    @Override
    public QuoteDto convert(Quote quote) {

        QuoteDto quoteDto = new QuoteDto();
        quoteDto.setId(quote.getId());
        quoteDto.setQuote(quote.getQuote());
        quoteDto.setAuthor(quote.getAuthor());

        return quoteDto;
    }
}
