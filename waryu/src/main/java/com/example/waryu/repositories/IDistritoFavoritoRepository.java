package com.example.waryu.repositories;

import com.example.waryu.entities.Distrito;
import com.example.waryu.entities.DistritoFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDistritoFavoritoRepository extends JpaRepository<DistritoFavorito, Integer> {
    @Query("select df.distrito from DistritoFavorito df where df.usuario.ID_Usuario =:id and df.Estado = true")
    public List<Distrito> findDistritoFavoritoByUsuario(@Param("id") Integer id);
}
