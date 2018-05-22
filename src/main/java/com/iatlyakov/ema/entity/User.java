package com.iatlyakov.ema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "F_USER_ID", nullable = false)
    private Long userId;
    @Column(name="F_FIRST_NAME", nullable = false)
    @Size(min=3, max = 30)
    @Pattern(regexp="^[А-ЯЁ][а-яё]+$")
    private String firstName;
    @Column(name="F_LAST_NAME", nullable = false)
    @Size(min=3, max = 30)
    @Pattern(regexp="^[А-ЯЁ][а-яё]+$")
    private String lastName;
    @Column(name="F_MIDDLE_NAME", nullable = false)
    @Size(min=3, max = 30)
    @Pattern(regexp="^[А-ЯЁ][а-яё]+$")
    private String middleName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public User(@Size(min = 3, max = 30) @Pattern(regexp = "^[А-ЯЁ][а-яё]+$") String firstName, @Size(min = 3, max = 30) @Pattern(regexp = "^[А-ЯЁ][а-яё]+$") String lastName, @Size(min = 3, max = 30) @Pattern(regexp = "^[А-ЯЁ][а-яё]+$") String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public User(){}
}
