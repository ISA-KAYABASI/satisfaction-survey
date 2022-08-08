package com.isakayabasi.maintermproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeStampModel {

        //kim ekledi
        @CreatedBy
        protected String createdBy;
        //Ne zaman ekledi
        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        protected Date createdDate;
        //kim güncelledi
        @LastModifiedBy
        protected String lastModifiedBy;
        //Ne zaman güncelledi
        @Temporal(TemporalType.TIMESTAMP)
        @LastModifiedDate
        protected Date lastModifiedDate;


//    @CreationTimestamp
//    @Column(name = "created_at",nullable = false,updatable = false)
//    private Date createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private Date updateAt;



}
