package com.cg.airways.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TourPlanner {

	private int visitNo;
	/*@DateTimeFormat(pattern = "dd/MM/yyyy")*/
	/*@Temporal(TemporalType.DATE)*/
	@Future(message="date should be after today")
	@NotNull
	private Date travelDate;
    @NotNull
    @Size(min=3, message="please enter the source")
	private String tourFrom;
	@NotNull
	@Size(min=3, message="please enter the destination")
    private String to;

	
	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	

	public String getTourFrom() {
		return tourFrom;
	}

	public void setTourFrom(String tourFrom) {
		this.tourFrom = tourFrom;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Id
	@GeneratedValue
	public int getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(int visitNo) {
		this.visitNo = visitNo;
	}

	@Override
	public String toString() {
		return "TourPlanner [visitNo=" + visitNo + ", travelDate=" + travelDate + ", from=" + tourFrom + ", to=" + to + "]";
	}

}
