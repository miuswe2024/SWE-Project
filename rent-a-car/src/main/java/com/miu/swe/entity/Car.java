package com.miu.swe.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Car implements Serializable {

    @Id
    private String registrationNr;
    private Integer constructionYear;
    private Integer mileage;
    private String model;
    @ManyToOne
    private Station station;
    @Override
    public String toString() {
        return "(" + registrationNr + ") " + model;
    }
}

