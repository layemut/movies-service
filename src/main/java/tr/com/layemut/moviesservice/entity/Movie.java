package tr.com.layemut.moviesservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIEID")
    Long id;

    @Column(name = "TITLE")
    String title;

    @Column(name = "YEAR")
    String year;

    @Column(name = "RATED")
    String rated;

    @Column(name = "RELEASED")
    String released;

    @Column(name = "RUNTIME")
    String runTime;

    @Column(name = "GENRE")
    String genre;

    @Column(name = "DIRECTOR")
    String director;

    @Column(name = "WRITER")
    String writer;

    @Column(name = "ACTORS")
    String actors;

    @Column(name = "PLOT")
    String plot;

    @Column(name = "LANGUAGE")
    String language;

    @Column(name = "IMDBID")
    String imdbId;

    @Column(name = "WEBSITE")
    String webSite;
}
