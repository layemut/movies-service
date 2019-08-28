package tr.com.layemut.moviesservice.entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSONID")
    private Long id;

    @Column(name = "NAME")
    @NotNull(message = "İsim boş bırakılamaz.")
    private String name;

    @Column(name = "SURNAME")
    @NotNull(message = "Soyisim boş bırakılamaz.")
    private String surName;

    @Column(name = "USERNAME")
    @NotNull(message = "Kullanıcı adı boş bırakılamaz.")
    private String userName;

    @Column(name = "PASSWORD")
    @Getter(AccessLevel.NONE)
    @NotNull(message = "Şifre boş bıraklamaz.")
    private String password;

    @Column(name = "AGE")
    @Min(value = 18, message = "Yaş 18'den küçük olamaz")
    private int age;

    @Column(name = "GENDER")
    private String gender = "U";
}
