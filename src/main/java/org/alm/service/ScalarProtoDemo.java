package org.alm.service;

import com.alm.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScalarProtoDemo {

  private static final Logger log = LoggerFactory.getLogger(ScalarProtoDemo.class);

  public static void main(String[] args) {

    Person person1 = Person.newBuilder()
            .setName("Alice")
            .setAge(30)
            .setEmail("alice@gmail.com")
            .setSalary(75000.50)
            .setBankAccountNumber(1234567890L)
            .setEmployed(true)
            .setBalance(-150)
            .build();

    log.info("person1: {}", person1);

  }

}
