package com.cosmos.documents;

public class Invoice {
  public final String name;

  public final String date;

  public final String pay;

  public final String classroom;

  public Invoice(String name, String date, String pay, String classroom) {
    this.name = name;
    this.date = date;
    this.pay = pay;
    this.classroom = classroom;
  }

  public String getName() {
    return name;
  }

  public void build() {}
}
