//package tacos.domain.cassandra_specific_domain;
//
//import com.datastax.oss.driver.api.core.uuid.Uuids;
//import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
//import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
//import org.springframework.data.cassandra.core.mapping.Table;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.UUID;
//
//@Table("users")
//public class UserC implements UserDetails {
//
//    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
//    private UUID id = Uuids.timeBased();
//
//    private final String username;
//
//    private final String password;
//    private final String fullname;
//    private final String street;
//    private final String city;
//    private final String state;
//    private final String zip;
//    private final String phoneNumber;
//    private final String email;
//
//    public UserC(String username, String password, String fullname, String street, String city, String state, String zip, String phoneNumber, String email) {
//        this.username = username;
//        this.password = password;
//        this.fullname = fullname;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.zip = zip;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public String getZip() {
//        return zip;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//}
