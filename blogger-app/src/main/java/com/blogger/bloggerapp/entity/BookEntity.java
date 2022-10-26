package com.blogger.bloggerapp.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Table(name ="books")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private Integer bookPrice;

    @Column(name = "book_description")
    private String bookDescription;

}
