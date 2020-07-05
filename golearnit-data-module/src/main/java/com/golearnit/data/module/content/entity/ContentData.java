package com.golearnit.data.module.content.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "content_data")
public class ContentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_id")
    private Long dataId;

    @Column(name = "encr_data")
    private String encrData;

    @Column(name = "data_type")
    private String dataType;

    @Column(name = "quiz_id_list")
    private String quizIdList;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

}
