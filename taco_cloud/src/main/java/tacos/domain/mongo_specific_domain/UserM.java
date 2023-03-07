//package tacos.domain.mongo_specific_domain;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@Document
//public class UserM implements UserDetails {
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    private String id;
//
//    private final String username;
//    private final String password;
//    private final String fullname;
//    private final String street;
//    private final String city;
//    private final String state;
//    private final String zip;
//    private final String phoneNumber;
//
//    public UserM(String id, String username, String password, String fullname, String street, String city, String state, String zip, String phoneNumber) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.fullname = fullname;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.zip = zip;
//        this.phoneNumber = phoneNumber;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
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
//}
