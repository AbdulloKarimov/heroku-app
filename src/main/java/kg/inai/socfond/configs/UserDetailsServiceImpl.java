package kg.inai.socfond.configs;

import kg.inai.socfond.entities.User;
import kg.inai.socfond.entities.UserRole;
import kg.inai.socfond.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getUserRoles()));
    }


    private List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : roles){
            SimpleGrantedAuthority auth = new SimpleGrantedAuthority(userRole.getName());
            authorities.add(auth);
        }

        return authorities;
    }

}