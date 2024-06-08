//package com.bbanggood.springviewrecord.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "mysql_view_record")
//public class MysqlViewRecord {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "VIEW_RECORD_ID", nullable = false)
//    private Integer id;
//
//    @Column(name = "SETBX_ID", nullable = false)
//    private Integer setbxId;
//
//    @Column(name = "VOD_ID", nullable = false)
//    private Integer vodId;
//
//    @Lob
//    @Column(name = "VIEW_TYPE", nullable = false)
//    private String viewType;
//
//    @Column(name = "RATING", precision = 5, scale = 3)
//    private BigDecimal rating;
//
//}