package OnlineBankingSystem.TesfaSolutions.dto;


import OnlineBankingSystem.TesfaSolutions.model.User;

public record UserRegisterDTO(String username, String firstName, String lastName, String password) {

    public static User toUser(UserRegisterDTO dto) {
        User user = new User();
        user.setUsername(dto.username());
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        return user;
    }
}