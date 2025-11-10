package org.alm.service;

import com.alm.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CollectionProtoDemo {

  private static final Logger log = LoggerFactory.getLogger(CollectionProtoDemo.class);

  public static void main(String[] args) {

    var book1 = Book.newBuilder()
            .setTitle("Book One")
            .setAuthor("Author A")
            .setPublishedYear(1998)
            .build();

    var book2 = Book.newBuilder()
            .setTitle("Book Two")
            .setAuthor("Author B")
            .setPublishedYear(2005)
            .build();

    var book3 = Book.newBuilder()
            .setTitle("Book Three")
            .setAuthor("Author C")
            .setPublishedYear(2010)
            .build();

    var library = Library.newBuilder()
            .setName("City Library")
//            .addBooks(book1)
//            .addBooks(book2)
//            .addBooks(book3)
            .addAllBooks(List.of(book1, book2, book3))
            .build();

    log.info("library: {}", library);

  }

}
