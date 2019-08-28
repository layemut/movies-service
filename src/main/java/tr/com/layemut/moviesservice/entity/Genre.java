package tr.com.layemut.moviesservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Genre")
public class Genre {

    @Id
    @Column(name = "GENREID")
    Long id;

    @Column(name = "MOVIEID")
    Long movieId;

    @Column(name = "NAME")
    String name;
}
