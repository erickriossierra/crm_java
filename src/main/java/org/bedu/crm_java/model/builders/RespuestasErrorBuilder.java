package org.bedu.crm_java.model.builders;

import java.util.HashMap;
import java.util.Map;

import org.bedu.crm_java.model.RespuestaError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class RespuestasErrorBuilder {
    private int estatus;
    private String mensaje;
    private Map<String,String> errores;
    private String ruta;  

    public RespuestasErrorBuilder estatus(int estatus){
        this.estatus=estatus;
        return this;
    }

    public RespuestasErrorBuilder status(HttpStatus estatus){
        this.estatus=estatus.value();
        if (estatus.isError()) {
            this.errores.put("error", estatus.getReasonPhrase());
        }
        return this;
    }

    public RespuestasErrorBuilder errores(Map<String,String> error){
        this.errores=error;
        return this;
    }

    public RespuestasErrorBuilder mensaje(String mensaje){
        this.mensaje=mensaje;
        return this;
    }

    public RespuestasErrorBuilder exception(MethodArgumentNotValidException exception ){
        HttpStatus status= HttpStatus.BAD_REQUEST;
        this.estatus=status.value();

        errores = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{
            String fieldname = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errores.put(fieldname, errorMessage);
        });

        return this;
    }

    public RespuestasErrorBuilder ruta(String ruta){
        this.ruta=ruta;
        return this;
    }

    public RespuestaError build(){
        RespuestaError respuesta = new RespuestaError();
        respuesta.setEstatus(estatus);
        respuesta.setMensaje(mensaje);
        respuesta.setErrores(errores);
        respuesta.setRuta(ruta);
        return respuesta; 
    }

    public ResponseEntity<RespuestaError> entidad() {
        return ResponseEntity.status(estatus).headers(HttpHeaders.EMPTY).body(build()); 
    }

}
