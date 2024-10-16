package com.miu.swe.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Customer implements Serializable {

    @Id
    private Integer customerNumber;
    private String firstName;
    private String lastName;
    @Override
    public String toString() {
        return "(" + customerNumber + ") " + firstName + ' ' + lastName;
    }
}
