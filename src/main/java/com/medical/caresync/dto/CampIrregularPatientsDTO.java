package com.medical.caresync.dto;
import java.util.Date;
import java.util.List;

public class CampIrregularPatientsDTO {

    private Long id;
	private String patientName;
	private Long patientsCamps;
	private Long totalCamps;
	private List<Date> attendedCamps;
	private List<Date> missedCamps;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Long getPatientsCamps() {
		return patientsCamps;
	}
	public void setPatientsCamps(Long patientsCamps) {
		this.patientsCamps = patientsCamps;
	}
	public Long getTotalCamps() {
		return totalCamps;
	}
	public void setTotalCamps(Long totalCamps) {
		this.totalCamps = totalCamps;
	}
	public List<Date> getAttendedCamps() {
		return attendedCamps;
	}
	public void setAttendedCamps(List<Date> attendedCamps) {
		this.attendedCamps = attendedCamps;
	}
	public List<Date> getMissedCamps() {
		return missedCamps;
	}
	public void setMissedCamps(List<Date> missedCamps) {
		this.missedCamps = missedCamps;
	}
}
