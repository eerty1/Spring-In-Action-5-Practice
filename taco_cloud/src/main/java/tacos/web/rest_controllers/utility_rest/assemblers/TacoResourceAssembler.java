package tacos.web.rest_controllers.utility_rest.assemblers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import tacos.domain.Taco;
import tacos.web.rest_controllers.DesignTacoRestController;
import tacos.web.rest_controllers.utility_rest.TacoResource;


public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoRestController.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateModel(Taco entity) {
        return new TacoResource(entity);
    }

    @Override
    public TacoResource toModel(Taco entity) {
        return createModelWithId(entity.getId(), entity);
    }

    @Override
    public CollectionModel<TacoResource> toCollectionModel(Iterable<? extends Taco> entities) {
        return super.toCollectionModel(entities);
    }

//    public List<TacoResource> toModels(List<Taco> entities) {
//        List<TacoResource> tacoResourcesList = new ArrayList<>();
//        for(Taco tacoItem: entities) {
//            TacoResource tacoResourceItem = createModelWithId(tacoItem.getId(),tacoItem);
//            tacoResourcesList.add(tacoResourceItem);
//        }
//        return tacoResourcesList;
//    } selfmade method to transform a list into TacoResource
}
