package org.alm.service;

import com.alm.model.Credentials;
import com.alm.model.Email;
import com.alm.model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneOfProtoDemo {

  private static final Logger log = LoggerFactory.getLogger(OneOfProtoDemo.class);

  public static void main(String[] args) {

    var email = Email.newBuilder()
            .setAddress("john.doe@gmail.com")
            .setPassword("password123")
            .build();

    var phone = Phone.newBuilder()
            .setNumber(1234567890)
            .setCode("654321")
            .build();

    login(Credentials.newBuilder().setEmail(email).build());
    login(Credentials.newBuilder().setPhone(phone).build());

  }

  private static void login(Credentials credentials) {
    switch (credentials.getLoginTypeCase()) {
      case EMAIL -> log.info("Logging in with email: {}", credentials.getEmail());
      case PHONE -> log.info("Logging in with phone: {}", credentials.getPhone());
      case LOGINTYPE_NOT_SET -> log.info("Login type not set");
    }
  }

}
