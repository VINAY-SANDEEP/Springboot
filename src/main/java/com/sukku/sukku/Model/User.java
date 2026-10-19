package com.sukku.sukku.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class User {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long id;
      private String name;
      private String village;
      private String loverName;
      public User(){
        
      }
      public User(String name, String village, String loverName) {
        this.name = name;
        this.village = village;
        this.loverName = loverName;
      }
      public Long getId() {
          return id;
      }
      public void setId(Long id) {
          this.id = id;
      }
      public String getName() {
          return name;
      }
      public void setName(String name) {
          this.name = name;
      }
      public String getVillage() {
          return village;
      }
      public void setVillage(String village) {
          this.village = village;
      }
      public String getLoverName() {
          return loverName;
      }
      public void setLoverName(String loverName) {
          this.loverName = loverName;
      }
    
}
