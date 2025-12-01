package com.journal.core;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "Journal")
@Data
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false, updatable = false)
    private String username;

    @Column(name = "USER_EVENT",columnDefinition = "LONGTEXT")
    private String event;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;
}
