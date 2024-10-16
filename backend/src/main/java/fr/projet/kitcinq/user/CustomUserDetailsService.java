package fr.projet.kitcinq.user;

import fr.projet.kitcinq.admin.AdminRepository;
import fr.projet.kitcinq.model.UserEntity;
import fr.projet.kitcinq.professor.ProfessorRepository;
import fr.projet.kitcinq.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    public CustomUserDetailsService(UserRepository userRepository, AdminRepository adminRepository, StudentRepository studentRepository, ProfessorRepository professorRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Set<GrantedAuthority> authorities = new HashSet<>();

        if (studentRepository.existsByUserId(userEntity.getId())) {
            authorities.add(new SimpleGrantedAuthority(Role.ROLE_STUDENT));
        }
        else if (professorRepository.existsByUserId(userEntity.getId())) {
            authorities.add(new SimpleGrantedAuthority(Role.ROLE_PROFESSOR));
        }
        else if (adminRepository.existsByUserId(userEntity.getId())) {
            authorities.add(new SimpleGrantedAuthority(Role.ROLE_ADMIN));
        }

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities
        );
    }
}

