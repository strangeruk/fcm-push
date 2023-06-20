//package com.hni.notification.common;
//
//import lombok.Getter;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import java.time.LocalDateTime;
//
//import javax.persistence.Column;
//import javax.persistence.EntityListeners;
//import javax.persistence.MappedSuperclass;
//
//@Getter
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public abstract class BaseTimeEntity {
//
//    @CreatedDate
//    @Column(updatable = false,nullable = false)
//    private LocalDateTime regDate;
//}