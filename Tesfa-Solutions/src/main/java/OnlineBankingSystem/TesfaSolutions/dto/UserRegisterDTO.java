package OnlineBankingSystem.TesfaSolutions.dto;


import OnlineBankingSystem.TesfaSolutions.model.Address;
import OnlineBankingSystem.TesfaSolutions.model.User;

public record UserRegisterDTO(String username, String firstName,
                              String lastName, String password, Address address) {

    public static User toUser(UserRegisterDTO dto) {
        User user = new User();
        user.setUsername(dto.username());
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setAddress(dto.address);


        return user;
    }
}