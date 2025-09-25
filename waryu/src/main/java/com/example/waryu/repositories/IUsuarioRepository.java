package com.example.waryu.repositories;

import com.example.waryu.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findOneByNombreusuario(String nombreusuario);
    @Query(value = "SELECT u.nombreusuario, COUNT(bp.id_boton_panico) AS total_activaciones " +
            "FROM usuario u JOIN boton_panico bp ON u.id_usuario = bp.id_usuario " +
            "GROUP BY u.nombreusuario ORDER BY total_activaciones DESC", nativeQuery = true)
    List<String[]> UsoBotonPanicoPorUsuario();
}
