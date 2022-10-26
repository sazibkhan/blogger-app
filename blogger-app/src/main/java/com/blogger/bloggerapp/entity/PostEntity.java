package com.blogger.bloggerapp.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_body")
    private String postBody;

    @ManyToOne
    @JoinColumn(
            name = "book_id",
            foreignKey = @ForeignKey(
                    name = "posts_book_id_fk"
            )
    )
    private BookEntity bookEntity;

}
