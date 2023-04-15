package com.productexseption.sms;

import com.productexseption.core.enumeration.SmsStatus;
import com.productexseption.core.enumeration.Status;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "sms")
public class Sms {
    @Id
    @SequenceGenerator(name = "sms_id_seq", sequenceName = "sms_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "text")
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "sms_status", nullable = false)
    private SmsStatus smsStatus;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status", columnDefinition = "varchar(20) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "deleted_at", columnDefinition = "timestamp without time zone")
    private Date deletedAt;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

}
