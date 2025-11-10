package org.alm.service;

import com.alm.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScalarProtoDemo {

  private static final Logger log = LoggerFactory.getLogger(ScalarProtoDemo.class);
  public static final Path PATH = Path.of("person.out");

  public static void main(String[] args) throws IOException {

    var person1 = Person.newBuilder()
            .setName("Alice")
            .setAge(30)
            .setEmail("alice@gmail.com")
            .setSalary(75000.50)
            .setBankAccountNumber(1234567890L)
            .setEmployed(true)
            .setBalance(-150)
            .build();

    log.info("person1: {}", person1);

    serialize(person1);
    log.info("Bytes Length:{}", person1.toByteArray().length);
    log.info("Serialized person1 to {}", deserialize());
    log.info("equals: {}", person1.equals(deserialize()));

  }

  public static void serialize(Person person) throws IOException {
    try (var output = Files.newOutputStream(PATH)) {
      person.writeTo(output);
    }
  }

  public static Person deserialize() throws IOException {
    try (var input = Files.newInputStream(PATH)) {
      return Person.parseFrom(input);
    }
  }

}
