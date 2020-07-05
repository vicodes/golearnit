package com.golearnit.data.module.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "f_name")
    private String fName;

    @Column(name = "l_name")
    private String lName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "occupation_details")
    private String occupationDetails;

    @Column(name = "qualification_details")
    private String qualificationDetails;

    @Column(name = "interest_set")
    private String interestSet;

    @Column(name = "profile_photo")
    private Blob profilePhoto;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;
}