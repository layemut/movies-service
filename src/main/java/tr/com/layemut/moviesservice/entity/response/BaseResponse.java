package tr.com.layemut.moviesservice.entity.response;

import lombok.*;
import lombok.experimental.Accessors;
import tr.com.layemut.moviesservice.entity.Result;


@ToString
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    Result result;
}
