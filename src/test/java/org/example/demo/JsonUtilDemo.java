package org.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonUtilDemo {

    public static class Car {

        private String color;
        private String type;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }


    @Test
    void writeObjectToJson() {
        Car car = new Car();
        car.setColor("RED");
        car.setType("Легковая");

        String json = JsonUtil.writeToJson(car);
        Assertions.assertEquals("{\"color\":\"RED\",\"type\":\"Легковая\"}", json);
    }

    @Test
    void readFromJson() {
        String json = "{\"color\":\"красный\",\"type\":\"Легковая\"}";
        Car restoredCar = JsonUtil.readFromJson(json, Car.class);

        Assertions.assertNotNull(restoredCar);
        Assertions.assertEquals("красный", restoredCar.getColor());
        Assertions.assertEquals("Легковая", restoredCar.getType());
    }
}
