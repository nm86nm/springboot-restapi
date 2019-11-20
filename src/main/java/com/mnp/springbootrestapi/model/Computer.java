package com.mnp.springbootrestapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Computer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String procesor;
  private String ram;
  private String motherboard;
  private String graphicscard;

  public Computer() {
  }

  public Computer(String procesor, String ram, String motherboard, String graphicscard) {
    this.procesor = procesor;
    this.ram = ram;
    this.motherboard = motherboard;
    this.graphicscard = graphicscard;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getGraphicscard() {
    return graphicscard;
  }

  public void setGraphicscard(String graphicscard) {
    this.graphicscard = graphicscard;
  }


  public String getMotherboard() {
    return motherboard;
  }

  public void setMotherboard(String motherboard) {
    this.motherboard = motherboard;
  }


  public String getProcesor() {
    return procesor;
  }

  public void setProcesor(String procesor) {
    this.procesor = procesor;
  }


  public String getRam() {
    return ram;
  }

  public void setRam(String ram) {
    this.ram = ram;
  }

}
