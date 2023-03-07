package tacos.web.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.data.jpa_repositories.IngredientRepository;
import tacos.data.jpa_repositories.TacoRepository;
import tacos.domain.Taco;
import tacos.web.rest_controllers.utility_rest.TacoResource;
import tacos.web.rest_controllers.utility_rest.assemblers.TacoResourceAssembler;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoRestController {
    private final TacoRepository tacoRepository;
    private final IngredientRepository ingredientRepository;
    EntityLinks entityLinks;

    @Autowired
    public DesignTacoRestController(TacoRepository tacoRepository, IngredientRepository ingredientRepository, EntityLinks entityLinks) {
        this.tacoRepository = tacoRepository;
        this.ingredientRepository = ingredientRepository;
        this.entityLinks = entityLinks;
    }

    @GetMapping("/recent")
    public CollectionModel<TacoResource> showRecentTacos() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("createdAt").descending());
        List<Taco> tacoList = tacoRepository.findAll(pageRequest).getContent();
        CollectionModel<TacoResource> recentTacoCollection = new TacoResourceAssembler().toCollectionModel(tacoList);
        recentTacoCollection.add(linkTo(methodOn(DesignTacoRestController.class).showRecentTacos()).withRel("recents"));
        return recentTacoCollection;
    }

    @GetMapping("/recentList")
    public Iterable<Taco> recentTacos() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("createdAt").descending());
        return tacoRepository.findAll(pageRequest).getContent();
    }


//      samples to create hypermedia in responses
//  recentTacoCollection.add(linkTo(methodOn(DesignTacoRestController.class).showRecentTacos()).withRel("recents"));
//  WebMvcLinkBuilder.linkTo(DesignTacoRestController.class).slash("recent").withRel("recents"));
//  Link.of("http://localhost:8080/design/recent", LinkRelation.of("recents")));


    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }
}
