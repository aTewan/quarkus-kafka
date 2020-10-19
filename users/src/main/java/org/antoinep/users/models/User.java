package org.antoinep.users.models;

import java.util.Date;

public class User {
  
  private String firstName;

  private String lastName;

  private String gender;

  private Date birthDate;


  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getGender() {
    return this.gender;
  }

  public Date getBirthDate() {
    return this.birthDate;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
}

