package org.alm.service;

import com.alm.model.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {

  private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

  public static void main(String[] args) {

    var person = PersonOuterClass.Person.newBuilder()
            .setName("John Doe")
            .setAge(25)
            .build();

    log.info("Person: {}", person);

  }

}
