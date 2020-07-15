package com.library.model;

import javax.persistence.*;

@Entity
@Table
public class User implements Cloneable{
   @Id
   private Long id;

   @ManyToOne
   @JoinColumn(name = "book_id")
   private Book book;

   public User() {}

   public User(Long id, Book book) {
      this.id = id;
      this.book = book;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Book getBook() {
      return book;
   }

   public void setBook(Book book) {
      this.book = book;
   }
}
