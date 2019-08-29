package tr.com.layemut.moviesservice.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSON")
public class Person implements UserDetails {

    private static final long serialVersionUID = -6074378947558289439L;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PrePersist
    @PreUpdate
    public void beforeSave() {
        setPassword(new BCryptPasswordEncoder().encode(password));
    }
}
