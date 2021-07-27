package com.comit.bikerama.service.impl;

import java.util.List;
import java.util.Optional;
import com.comit.bikerama.domain.User;
import com.comit.bikerama.repository.RoleRepository;
import com.comit.bikerama.repository.UserRepository;
import com.comit.bikerama.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import net.minidev.json.JSONObject;

@Service
public class UserServiceImpl implements UserService  {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public final static String USER_NOT_FOUND_MSG = "El usuario con email %s no fue encontrado";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        // how to update in crud?
        return userRepository.save(user);
    }

    @Override
    public String delete(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            userRepository.deleteById(id);
            jsonObject.put("Mensaje", "Usuario borrado correctamente");
        } catch (Exception e) {
            logger.error("Error al borrar usuario");
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }


    /*
     * @Override public User findByUserName(String userName) { return
     * userRepository.findByUserName(userName); }
     */
    /*
     * @Override public User findByEmail(String email) { return
     * userRepository.findByEmail(email); }
     */
   
    /*
     * @Override public User createUser(User user) { User localUser =
     * this.findByUserName(user.getUserName()); if (localUser == null) { Cart cart =
     * new Cart(); cart.setUser(user); user.setCart(cart);
     * 
     * localUser = this.save(user);
     * 
     * }else{ logger.info("El usuario {}, existe, no es posible el registro",
     * user.getUserName()); } return localUser; }
     */

}
