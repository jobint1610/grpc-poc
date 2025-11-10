package org.alm.service;

import com.alm.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {

  private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

  public static void main(String[] args) {

    var person1 = Person.newBuilder()
            .setName("John Doe")
            .setAge(25)
            .build();

    log.info("person1: {}", person1);

    // Create a new Person by modifying person1
    var person2 = person1.toBuilder()
            .setName("Jane Smith")
            .build();

    log.info("person2: {}", person2);

    // Create a third Person by setting the age of person2 to null
    // Note: Since protobuf does not support null, we need to clear the field
    var person3 = person2.toBuilder()
            .clearAge()
            .build();

    log.info("person3: {}", person3);

  }

}
