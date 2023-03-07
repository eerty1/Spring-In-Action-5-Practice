//package tacos.domain.cassandra_specific_domain;
//
//import com.datastax.oss.driver.api.core.uuid.Uuids;
//import jdk.internal.dynalink.linker.LinkerServices;
//import org.springframework.data.cassandra.core.cql.Ordering;
//import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
//import org.springframework.data.cassandra.core.mapping.Table;
//
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//@Table("tacos")
//public class TacoC {
//
//    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
//    private UUID id = Uuids.timeBased();
//
//    @NotNull
//    @Size(min = 5, message = "Name  must be at least 5 characters long")
//    private String name;
//
//    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
//    private Date createdAt = new Date();
//
//    @NotEmpty(message = "You must choose at least one ingredient")
//    @Column("ingredients")
//    private List<IngredientUDT> ingredients;
//
//
//}
