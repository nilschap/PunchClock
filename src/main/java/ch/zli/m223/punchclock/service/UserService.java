package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private ApplicationUserRepository applicationUserRepository;

    public UserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public ApplicationUser createUser(ApplicationUser user) {
        return applicationUserRepository.save(user);
    }

    public List<ApplicationUser> createUsers(List<ApplicationUser> users) {
        return applicationUserRepository.saveAll(users);
    }

    public ApplicationUser updateUser(ApplicationUser user) { return applicationUserRepository.save(user); }

    public void deleteUser(ApplicationUser user) {
        applicationUserRepository.delete(user);
    }

    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }
}