package tr.com.layemut.moviesservice.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Person")
public class Person {

    @Id
    @Generated
    private ObjectId id;

    @NotNull(message = "İsim boş bırakılamaz.")
    private String name;

    @NotNull(message = "Soyisim boş bırakılamaz.")
    private String surName;

    @NotNull(message = "Kullanıcı adı boş bırakılamaz.")
    private String userName;

    @Getter(AccessLevel.NONE)
    @NotNull(message = "Şifre boş bıraklamaz.")
    private String password;

    @Min(value = 18, message = "Yaş 18'den küçük olamaz")
    private int age;

    private String gender = "U";
}
