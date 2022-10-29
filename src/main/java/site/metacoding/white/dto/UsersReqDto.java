package site.metacoding.white.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white.domain.Users;

public class UsersReqDto {

    @Getter
    @Setter
    public static class JoinReqDto {
        private String username;
        private String password;

        public Users toEntity() {
            return Users.builder().username(username).password(password).build();
        }
    }

}
