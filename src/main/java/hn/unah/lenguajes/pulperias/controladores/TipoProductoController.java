package hn.unah.lenguajes.pulperias.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.pulperias.modelos.TipoProducto;
import hn.unah.lenguajes.pulperias.servicios.TipoProductoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/tipoproductos")
public class TipoProductoController {
    
    @Autowired
    private TipoProductoServicio tipoProductoServicio;

    @GetMapping("/obtener/todos")
    List<TipoProducto> obtenerTodos(){
        return this.tipoProductoServicio.obtenerTodos();
    }

    @PostMapping("/crear")
    public TipoProducto crearNuevo(@RequestParam String descripcion) {
        return this.tipoProductoServicio.crearNuevo(descripcion);
    }

    @GetMapping("/obtener/{codigoTipo}")
    public TipoProducto obtenerPorCodigo(@PathVariable long codigoTipo) {
        return this.tipoProductoServicio.obtenerPorCodigo(codigoTipo);
    }
    
    @DeleteMapping("/eliminar/{codigoTipo}")
    public String eliminarPorCodigo(@PathVariable(name="codigoTipo") long codigoTipo){
        return this.tipoProductoServicio.eliminarPorCodigo(codigoTipo);
    }
    
    @PutMapping("actualizar/{codigoTipo}")
    public TipoProducto actualizar(@PathVariable(name="codigoTipo") long codigoTipo, 
                                   @RequestBody TipoProducto tipoProducto) {       
        return this.tipoProductoServicio.actualizar(codigoTipo, tipoProducto);
    }

}
