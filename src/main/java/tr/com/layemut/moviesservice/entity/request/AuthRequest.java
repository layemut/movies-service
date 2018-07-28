package tr.com.layemut.moviesservice.entity.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    @NotNull(message = "Kullanıcı adı boş bırakılamaz.")
    private String userName;

    @NotNull(message = "Parola boş bırakılamaz.")
    private String password;
}
