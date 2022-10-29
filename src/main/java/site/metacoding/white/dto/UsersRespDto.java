package site.metacoding.white.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white.domain.Users;

public class UsersRespDto {

    @Setter
    @Getter
    public static class JoinRespDto {
        private Long id;
        private String username;

        public JoinRespDto(Users users) {
            this.id = users.getId();
            this.username = users.getUsername();
        }
    }

}
