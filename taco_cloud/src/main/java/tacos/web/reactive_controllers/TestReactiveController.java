//package tacos.web.reactive_controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//import tacos.data.reactive_jpa_repositories.ReactiveTacoRepository;
//import tacos.domain.Taco;
//
//@RestController
//@RequestMapping(path = "/reactiveTest", produces = "application/json")
//@CrossOrigin(origins = "*")
//public class TestReactiveController {
//    private ReactiveTacoRepository reactiveTacoRepository;
//
//    @Autowired
//    public TestReactiveController(ReactiveTacoRepository reactiveTacoRepository) {
//        this.reactiveTacoRepository = reactiveTacoRepository;
//    }
//
//    @GetMapping(path = "/recent", produces = "application/json")
//    public Flux<Taco> getRecentTacos() {
//        return reactiveTacoRepository.findAll().take(2);
//    }
//}
