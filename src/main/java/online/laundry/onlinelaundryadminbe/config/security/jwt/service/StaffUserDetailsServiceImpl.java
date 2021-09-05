package online.laundry.onlinelaundryadminbe.config.security.jwt.service;
import online.laundry.onlinelaundryadminbe.models.StaffUser;
import online.laundry.onlinelaundryadminbe.repository.StaffUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StaffUserDetailsServiceImpl implements UserDetailsService {
    private final StaffUserRepository staffUserRepository;

    @Autowired
    public StaffUserDetailsServiceImpl(StaffUserRepository staffUserRepository) {
        this.staffUserRepository = staffUserRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StaffUser user = staffUserRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

        return StaffUserPrinciple.build(user);
    }
}
