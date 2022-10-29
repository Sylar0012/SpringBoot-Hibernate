package site.metacoding.white.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.domain.UserRepository;
import site.metacoding.white.domain.Users;
import site.metacoding.white.dto.UsersReqDto.JoinReqDto;
import site.metacoding.white.dto.UsersRespDto.JoinRespDto;
import site.metacoding.white.util.SHA256;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UserRepository userRepository;
    private final SHA256 sha256;

    @Transactional
    public JoinRespDto save(JoinReqDto joinReqDto) {
        String encPassword = sha256.encrypt(joinReqDto.getPassword());
        joinReqDto.setPassword(encPassword);

        Users usersPS = userRepository.save(joinReqDto.toEntity());

        return new JoinRespDto(usersPS);
    }
}
