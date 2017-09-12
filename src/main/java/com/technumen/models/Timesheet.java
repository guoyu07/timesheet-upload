package com.technumen.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Maintains Timesheet Information.
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"employee", "timesheetId"})
@NoArgsConstructor
@AllArgsConstructor
public class Timesheet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIMESHEET_ID", unique = true, nullable = false)
    private long timesheetId;
    private String timesheetType;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    private String timesheetStatus;
    //Timesheet Information
    private double regularHours;
    private double extraHours;
    //Upload Information
    private java.sql.Blob blobMessage;
    private String dscFileName;
    @Transient
    private transient String rowid;
    private long fileSize;
    private String dscComments;
    //Audit Information
    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastModified;
    @DateTimeFormat(pattern = "MM/dd/yyyy hh:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApproved;
    private String nameCreated; //Name of the user Uploaded the timesheet.
    private String nameLastModified;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @JsonIgnore
    private Employee employee;


}
