package com.haonguyen.ServiceImport.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@AllArgsConstructor
@NoArgsConstructor
public class KeySearchDTO {
      private String key;
      @Temporal(TemporalType.DATE)
      private String date;

      public String getKey() {
            return key;
      }

      public void setKey(String key) {
            this.key = key;
      }

      public String getDate() {
            return date;
      }

      public void setDate(String date) {
            this.date = date;
      }
}
