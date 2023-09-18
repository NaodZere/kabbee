package OnlineBankingSystem.TesfaSolutions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private Address address;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(this.role.name()));
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {

        return false;
    }
//    @Override
//
//    public String getPassword() {
//        return password;
//    }
    @Override
    public boolean isAccountNonLocked() {

        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return false;
    }

    @Override
    public boolean isEnabled() {

        return enabled;
    }
}
