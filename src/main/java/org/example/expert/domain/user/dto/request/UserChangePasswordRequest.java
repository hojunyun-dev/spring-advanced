package org.example.expert.domain.user.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {

    @NotNull
    @Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d).*$",
            message = "비밀번호는 대문자와 숫자를 각각 1개 이상 포함해야 합니다."
    )
    private String newPassword;

    @NotNull
    private String oldPassword;
}
