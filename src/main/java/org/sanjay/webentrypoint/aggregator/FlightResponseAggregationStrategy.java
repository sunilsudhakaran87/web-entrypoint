package org.sanjay.webentrypoint.aggregator;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.sanjay.webentrypoint.model.Flight;

public class FlightResponseAggregationStrategy implements AggregationStrategy {
    /*
    public Flight aggregate(Flight prevFlight, Flight nextFlight) {
        if (prevFlight != null && prevFlight.getPrice().compareTo(nextFlight.getPrice()) == -1)
            return prevFlight;
        else
            return nextFlight;

    }
    */

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null)
            return newExchange;

        Flight prevFlight = oldExchange.getIn().getBody(Flight.class);
        Flight nextFlight = newExchange.getIn().getBody(Flight.class);

        if (prevFlight != null && prevFlight.getPrice().compareTo(nextFlight.getPrice()) == -1)
            newExchange.getIn().setBody(prevFlight, Flight.class);
        else
            newExchange.getIn().setBody(nextFlight, Flight.class);

        return newExchange;
    }
}
