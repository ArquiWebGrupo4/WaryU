package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Rol;
import com.example.waryu.entities.Usuario;
import com.example.waryu.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findOneByNombreusuario(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        Rol rol = user.getRol();
        String nombreRol = rol.getNombre();
        roles.add(new SimpleGrantedAuthority(nombreRol));

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getNombreusuario(), user.getContrasenahash(), true, true, true, true, roles);

        return ud;
    }
}