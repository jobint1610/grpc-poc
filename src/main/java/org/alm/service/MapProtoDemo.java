package org.alm.service;

import com.alm.model.BodyStyle;
import com.alm.model.Car;
import com.alm.model.Dealer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapProtoDemo {

  private static final Logger log = LoggerFactory.getLogger(MapProtoDemo.class);

  public static void main(String[] args) {

    var car1 = Car.newBuilder()
            .setMake("Honda")
            .setModel("Civic")
            .setYear(2015)
            .setBodyStyle(BodyStyle.HATCHBACK)
            .build();

    var car2 = Car.newBuilder()
            .setMake("Toyota")
            .setModel("Camry")
            .setYear(2018)
            .setBodyStyle(BodyStyle.SEDAN)
            .build();

    var dealer = Dealer.newBuilder()
            .setName("Best Cars Dealer")
            .putInventory(car1.getYear(), car1)
            .putInventory(car2.getYear(), car2)
            .build();

    log.info("dealer: {}", dealer);
    log.info("body style of car2: {}", car2.getBodyStyle());

  }
}
