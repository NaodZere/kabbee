package OnlineBankingSystem.TesfaSolutions.dto;

import OnlineBankingSystem.TesfaSolutions.model.Role;
import OnlineBankingSystem.TesfaSolutions.model.User;


public record UserDTO(int id, String username,
                      String firstName, String lastName, Role role, boolean enabled) {

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getRole(),
                user.isEnabled());
    }
}
