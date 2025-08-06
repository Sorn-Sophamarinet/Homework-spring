package kh.edu.istasd.fswdapi.dto;

public record RegisterRequest(
        String userName,
        String email,
        String firstName,
        String lastName,
        String password,
        String confirmPasswords

) {

}
