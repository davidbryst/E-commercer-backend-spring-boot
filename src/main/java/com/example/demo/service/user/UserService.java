package com.example.demo.service.user;

import com.example.demo.domain.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;
    private final ArticleRepository articleRepository;
    private final OrderRepository orderRepository;
    private final ArticleOrderRepository articleOrderRepository;


    // auth
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(username);
        AppUser user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("user not find in data base");
            throw new UsernameNotFoundException("user not find in data base");
        } else {
            log.info("user {} find in data base", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    // crud user and role
    public AppUser saveUser(AppUser user) {
        log.info("user {} save", user.getFirstname());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Role saveRole(Role role) {
        log.info("user {} save", role.getName());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String name) {
        log.info("role {} is add to user {}", name, username);
        AppUser user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(name);
        user.getRoles().add(role);
    }

    public AppUser getUser(String username) {
        log.info("fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    public List<AppUser> getUsers() {
        log.info("fetching all users");
        return userRepository.findAll();
    }

    // crud cart
    public List<Cart> getCarts(String username) {
        return (List<Cart>) userRepository.findByUsername(username).getCarts();
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void addToCart(String username, Long articleId) {
        Collection<Cart> carts = userRepository.findByUsername(username).getCarts();
        Boolean find = false;
        Iterator i = carts.iterator();
        Cart cart = null;
        while (i.hasNext()) {
            cart = (Cart) i.next();
            if (cart.getArticles().getId() == articleId) {
                find = true;
                break;
            }
        }
        System.out.println(find);
        if (find) {
            cart.setNumber(cart.getNumber() + 1);
        } else {
            carts.add(cartRepository.save(new Cart(null, articleRepository.findById(articleId).get(), 1)));
        }
    }

    public void removeToCart(String username, Long articleId) {
        Collection<Cart> carts = userRepository.findByUsername(username).getCarts();
        Boolean find = false;
        Iterator i = carts.iterator();
        Cart cart = null;
        while (i.hasNext()) {
            cart = (Cart) i.next();
            if (cart.getArticles().getId() == articleId) {
                find = true;
                break;
            }
        }
        if (find) {
            if (cart.getNumber() > 1) {
                cart.setNumber(cart.getNumber() - 1);
            } else {
                cartRepository.delete(cart);
                carts.remove(cart);
            }
        }
    }

    // crud order
    public void creatOrder(String username, String deliveryAdress) {
        AppUser user = userRepository.findByUsername(username);
        Collection<Cart> carts = user.getCarts();
        System.out.println(carts.size());
        if (carts.size() >= 1) {
            Cart cart;
            UserOrder order = orderRepository.save(new UserOrder(null, deliveryAdress, 1, user, System.currentTimeMillis()));
            Iterator i = carts.iterator();
            while (i.hasNext()) {
                cart = (Cart) i.next();
                articleOrderRepository.save(new ArticleOrder(null, cart.getNumber()*cart.getArticles().getPrice(), cart.getNumber(), cart.getArticles(), order));
                cartRepository.delete(cart);
            }
            carts.removeAll(carts);
        }
    }
}
