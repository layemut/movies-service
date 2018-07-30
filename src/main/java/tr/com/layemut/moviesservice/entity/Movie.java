package tr.com.layemut.moviesservice.entity;


import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Movie")
public class Movie {

    @Id
    ObjectId _id;

    @SerializedName("id")
    Long movieId;

    boolean adult;

    double budget;

    @SerializedName("original_language")
    String language;

    @SerializedName("original_title")
    String title;

    String overview;

    @SerializedName("release_date")
    Date releaseDate;

    @SerializedName("runtime")
    int runTime;

    String status;

    List<Genre> genres;
}
