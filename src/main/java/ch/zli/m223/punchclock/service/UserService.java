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

    public List<ApplicationUser> createUsers(List<ApplicationUser> users) {
        return applicationUserRepository.saveAll(users);
    }

    public void deleteUser(long id) {
        applicationUserRepository.deleteById(id);
    }

    //...
    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }

    //Update User
    public ApplicationUser updateUser(Long userId, ApplicationUser user) {
        //Get user From db by Id
        ApplicationUser user1 = applicationUserRepository.getOne(userId);
        //Set the username from the user retrived from the db to the username value from the parameters
        user1.setUsername(user.getUsername());
        //Set the password from the user retrived from the db to the password value from the parameters
        user1.setPassword(user.getPassword());
        //Save updated user to the db
        return applicationUserRepository.save(user1);
    }
}