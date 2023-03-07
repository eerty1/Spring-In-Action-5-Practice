package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.data.jpa_repositories.UserRepository;
import tacos.security.RegistrationForm;
import tacos.security.users_domain.User;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute(name = "newlyCoinedUser")
    public User user() {
        return new User();
    }

    @GetMapping
    public String registration() {
        return "/registration";
    }

    //Тут заполнение Юзера происходит путем того, что из сигнатуры метода неявнем образом создается объект RegistrationForm
    //И уже благодаря тому, что объект создался, у нас есть в нем данные и его данными мы в методе toUser() заполняем поля User'а и все там энкодим.
    //Как я понимаю, создание объекта RegistrationForm происходит в момент, когда форма выполняет свое действие и выплевывает данные по /registration
    @PostMapping
    public String processRegistration(RegistrationForm registrationForm) {
        userRepository.save(registrationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
