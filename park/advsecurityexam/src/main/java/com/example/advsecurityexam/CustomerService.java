package com.example.advsecurityexam;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {

@Autowired
private CustomerRepository customerRepository;

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

Optional<Customer> tcustomer = customerRepository.findByusername(username);
if (tcustomer.isEmpty()) {
throw new UsernameNotFoundException("You need to Sign up first...");
}
Customer customer = tcustomer.get();
List<GrantedAuthority> authorities = new ArrayList<>();
if ("ROLE_USER".equals(customer.getRole())) {
authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
} else if ("ROLE_MANAGER".equals(customer.getRole())) {
authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
} else {
authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
}
return new User(customer.getUsername(), customer.getPassword(), authorities);

}

public void create(Customer customer) {

customer.setEnabled(true);
customer.setRole("ROLE_USER"); //ROLE_ADMIN, ROLE_MANAGER, ROLE_PAID...
customer.setCdate(LocalDateTime.now());
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
customer.setPassword(passwordEncoder.encode(customer.getPassword()));
customerRepository.save(customer);

}
public Customer authen() {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	String username = userDetails.getUsername();
	
	Optional<Customer> oc = customerRepository.findByusername(username);//username

	return oc.get();

}

}