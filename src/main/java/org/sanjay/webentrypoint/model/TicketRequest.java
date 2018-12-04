package org.sanjay.webentrypoint.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TicketRequest {
    @NotEmpty
    private String startCity;

    @NotEmpty
    private String endCity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private Date startDate;

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
