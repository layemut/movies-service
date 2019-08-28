package tr.com.layemut.moviesservice.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    @Column(name = "MOVIEID")
    Long id;

    @Column(name = "ADULT")
    boolean adult;

    @Column(name = "BUDGET")
    double budget;

    @Column(name = "LANGUAGE")
    @SerializedName("original_language")
    String language;

    @Column(name = "TITLE")
    @SerializedName("original_title")
    String title;

    @Column(name = "OVERVIEW")
    String overview;

    @Column(name = "RELEASEDATE")
    @SerializedName("release_date")
    Date releaseDate;

    @Column(name = "RUNTIME")
    @SerializedName("runtime")
    int runTime;

    @Column(name = "STATUS")
    String status;
}
