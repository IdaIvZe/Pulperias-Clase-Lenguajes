package hn.unah.lenguajes.pulperias.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.unah.lenguajes.pulperias.modelos.TipoProducto;

public interface TipoProductoRepositorio extends JpaRepository<TipoProducto, Long> {
    
    public List<TipoProducto> getByDescripcion(String descripcion);

    public boolean existsByDescripcion(String descripcion);
}
