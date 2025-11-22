package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Usuario;
import com.example.waryu.repositories.IUsuarioRepository;
import com.example.waryu.serviceinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;

    @Autowired
    private PasswordEncoder pE;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        String hash = pE.encode(usuario.getContrasenahash());
        String num = "51" + usuario.getTelefono();
        String numpa = "51" + usuario.getTelefono();
        usuario.setContrasenahash(hash);
        usuario.setTelefono(num);
        usuario.setTelefono_Panico(numpa);
        uR.save(usuario);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public Usuario findID(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<String[]> UsoBotonPanicoPorUsuario() {
        return uR.UsoBotonPanicoPorUsuario();
    }
}
