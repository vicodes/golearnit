package com.golearnit.data.module.content.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long contentId;

    @Column(name = "content_name")
    private String contentName;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "quiz_id_list")
    private String quizIdList;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "data_id")
    private int dataId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;
}