package org.sanjay.webentrypoint.service;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.sanjay.webentrypoint.exception.CamelApplicationException;
import org.sanjay.webentrypoint.model.BookingResponse;
import org.sanjay.webentrypoint.model.TicketRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightCamelService {
    @Autowired
    private ProducerTemplate producerTemplate;

    private static final Logger logger = LoggerFactory.getLogger("org.sanjay.webentrypoint.service.FlightCamelService");

    public BookingResponse doBooking(TicketRequest ticketRequest) throws CamelApplicationException {
        Object response = null;

        response  = producerTemplate.sendBody("direct:doBooking", ExchangePattern.InOut, ticketRequest);

        if (response instanceof CamelApplicationException) {
            logger.error("We have an exception");
            String message = ((CamelApplicationException) response).getMessage();
            throw new CamelApplicationException(message);
        }
        return (BookingResponse) response;
    }
}
