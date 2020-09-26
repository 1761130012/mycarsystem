package com.vo;

import java.util.Arrays;

public class TestUser {
    private Integer id;//id
    private String name;//名称
    private byte[] image;//图片

   @Override
   public String toString() {
      return "TestUser{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
   }

   public TestUser() {
   }

   public TestUser(String name, byte[] image) {
      this.name = name;
      this.image = image;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public byte[] getImage() {
      return image;
   }

   public void setImage(byte[] image) {
      this.image = image;
   }
}
