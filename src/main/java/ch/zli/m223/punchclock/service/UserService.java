package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private ApplicationUserRepository applicationUserRepository;

    public UserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public List<ApplicationUser> createUsers(List<ApplicationUser> users) {
        return applicationUserRepository.saveAll(users);
    }

    public void deleteUser(long id) {
        applicationUserRepository.deleteById(id);
    }

    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }

    public ApplicationUser updateUser(Long userId, ApplicationUser user) {
        ApplicationUser user1 = applicationUserRepository.getOne(userId);
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        return applicationUserRepository.save(user1);
    }
}