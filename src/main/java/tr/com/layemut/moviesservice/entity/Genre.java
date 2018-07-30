package tr.com.layemut.moviesservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Genre")
public class Genre {

    Long id;

    String name;
}
