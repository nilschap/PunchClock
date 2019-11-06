package ch.zli.m223.punchclock.controller;
import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import ch.zli.m223.punchclock.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    //Inject Services
    public UserController(UserService userService, ApplicationUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    /**
     * Delete Note
     * @RequestBody Retrives the User that will be added
     * Get User as Input encode its password and saves it
     */
    @PostMapping("/sign-up")
    @CrossOrigin("http://localhost:4200")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

     /**
     * Delete Note
     * @return return alle registerd users
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationUser> getAllUsers() {
        return userService.findAll();
    }

    /**
     * Update User
     * @returns returns the updated User
     * @RequestBody Gets new User with edited data
     * @PathVariable Gets the userId from the userId that will be updated
     */
    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ApplicationUser updateEntry(@PathVariable("userId") long userId, @RequestBody ApplicationUser user)  {
        return userService.updateUser(userId,user);
    }

    /**
     * Delete Note
     * @returns returns the deleted User
     * @PathVariable Gets the userId from the entry that should be deleted
     */
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable("userId") long userId) {
          userService.deleteUser(userId);
    }





}
