package com.sakaripi.someblock.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity(name = "Point")
@Table(
        name = "points",
        uniqueConstraints = {@UniqueConstraint(name = "point_unique_constraints", columnNames = {"id", "latitude", "longitude", "giver_email", "receiver_email", "passcode"})}
)
public class Point {

    Point(){}

    public Point(String latitude, String longitude, String giverEmail, Team team) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.giverEmail = giverEmail;
        this.team = team;
    }

    @Id
    @SequenceGenerator(
            name = "point_sequence",
            sequenceName = "point_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_sequence")
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "latitude",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String latitude;

    @Column(
            name = "longitude",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String longitude;

    @Column(
            name = "giver_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String giverEmail;

    @Column(
            name = "receiver_email",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String receiverEmail;


    @Column(
            name = "team",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Team team;

    @Column(
            name = "passcode",
            nullable = true,
            columnDefinition = "integer"
    )
    private Integer passcode;



    private void validateAndAssignPassCode(){
        //validate that no other point in the database has the same passcode
        this.passcode = (int)(Math.round(Math.random() * (19998 - 10000 + 1)) + 10000);
    }
}
