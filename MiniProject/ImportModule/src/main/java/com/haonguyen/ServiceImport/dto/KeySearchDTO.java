package com.haonguyen.ServiceImport.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class KeySearchDTO {
      private String key;
      @Temporal(TemporalType.TIMESTAMP)
      private Date date;

      public String getKey() {
            return key;
      }

      public void setKey(String key) {
            this.key = key;
      }

      public Date getDate() {
            return date;
      }

      public void setDate(Date date) {
            this.date = date;
      }
}
