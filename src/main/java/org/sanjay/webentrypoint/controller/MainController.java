package org.sanjay.webentrypoint.controller;

import org.sanjay.webentrypoint.exception.CamelApplicationException;
import org.sanjay.webentrypoint.model.BookingResponse;
import org.sanjay.webentrypoint.model.TicketRequest;
import org.sanjay.webentrypoint.service.FlightCamelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MainController {
    @Autowired
    private FlightCamelService flightCamelService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostMapping(value = "/api/ticket", produces = "application/json")
    public ResponseEntity<?> doBookTicket(@RequestBody @Valid TicketRequest ticketRequest) throws CamelApplicationException {

        logger.info("Got request for ticket reservation");

        BookingResponse response = flightCamelService.doBooking(ticketRequest);

        logger.info("Done processing request for ticket booking");

        return new ResponseEntity<>(response, null, HttpStatus.CREATED);
    }
}
