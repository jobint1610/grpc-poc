package org.alm.service;

import com.alm.model.Address;
import com.alm.model.School;
import com.alm.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompositionProtoDemo {

  private static final Logger log = LoggerFactory.getLogger(CompositionProtoDemo.class);

  public static void main(String[] args) {

    var address = Address.newBuilder()
            .setStreet("123 Main St")
            .setCity("Springfield")
            .setState("GA")
            .build();

    var student = Student.newBuilder()
            .setName("Bob")
            .setAddress(address)
            .build();

    var school = School.newBuilder()
            .setId(1)
            .setName("Springfield High")
            .setAddress(address.toBuilder().setStreet("234 Main St"))
            .build();

    var school2 = school.toBuilder()
            .clearAddress()
            .build();

    log.info("student: {}", student);
    log.info("school: {}", school);
    log.info("school2 street{}", school2.getAddress().getStreet()); // null safe

  }

}
