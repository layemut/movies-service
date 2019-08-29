package tr.com.layemut.moviesservice.entity.response;

import lombok.*;
import lombok.experimental.Accessors;

@ToString(callSuper = true)
@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class PersonAuthResponse extends BaseResponse {

    String jwtToken;
}
