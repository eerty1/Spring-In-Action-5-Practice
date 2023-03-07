package tacos.web.rest_controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.data.jpa_repositories.TacoRepository;
import tacos.domain.Taco;
import tacos.web.rest_controllers.utility_rest.TacoResource;
import tacos.web.rest_controllers.utility_rest.assemblers.TacoResourceAssembler;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
public class VariousHTTPRequestTacoRestController {
    private final TacoRepository tacoRepository;

    public VariousHTTPRequestTacoRestController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(path = "/tacos/recent", produces = "application/json")
    public ResponseEntity<CollectionModel<TacoResource>> recentTacos() {
        PageRequest page = PageRequest.of(0, 2, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepository.findAll(page).getContent();
        CollectionModel<TacoResource> tacoResources = new TacoResourceAssembler().toCollectionModel(tacos);
        tacoResources.add(linkTo(methodOn(VariousHTTPRequestTacoRestController.class).recentTacos()).withRel("recents"));
        return new ResponseEntity<>(tacoResources, HttpStatus.OK);
    }

    @GetMapping(path = "/{tacoId}", produces = "application/json")
    public ResponseEntity<Taco> haveTaco(@PathVariable("tacoId") Long id) {
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        if (optionalTaco.isPresent()) {
            return new ResponseEntity<>(optionalTaco.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{tacoId}", consumes = "application/json")
    public Taco putTaco(@RequestBody() Taco taco) {
        return tacoRepository.save(taco);
    }

    @PatchMapping(path = "/{tacoId}", consumes = "application/json")
    public Taco patchOrder(@PathVariable("tacoId") Long tacoId, @RequestBody Taco taco) {
        Taco tacoToPatch = tacoRepository.findById(tacoId).get();
        if (taco.getId() != null) {
            tacoToPatch.setId(taco.getId());
        }
        if (taco.getName() != null) {
            tacoToPatch.setName(taco.getName());
        }
        if (taco.getIngredients() != null) {
            tacoToPatch.setIngredients(taco.getIngredients());
        }
        if (taco.getCreatedAt() != null) {
            tacoToPatch.setCreatedAt(taco.getCreatedAt());
        }
        return tacoRepository.save(tacoToPatch);
    }
}

