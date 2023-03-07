package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tacos.data.jpa_repositories.UserRepository;
import tacos.security.users_domain.User;


@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //Этот метод как раз-таки и вызывается, когда я нажимаю на кнопку Login. Поскольку в configure() программе указано,
    //Что вся защита, связанная с базой данных (то есть пользователи, которых нужно логинить) лежит тут,
    //То и при нажатии Login я попадаю в этот метод, который простейшей логикой либо вернет нужного пользователя, либо родит exception
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user; //в данном случае программу устраивает возвращение объекта User, т.к. User у нас является наследником UserDetails
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
