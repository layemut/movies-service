package tr.com.layemut.moviesservice.entity.response;

import lombok.*;
import lombok.experimental.Accessors;
import tr.com.layemut.moviesservice.entity.Person;

@ToString(callSuper = true)
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class PersonCreateResponse extends BaseResponse {
    Person person;
}
