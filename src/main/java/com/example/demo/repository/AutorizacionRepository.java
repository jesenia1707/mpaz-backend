
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Autorizacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorizacionRepository extends JpaRepository<Autorizacion, Long> {

    List<Autorizacion> findByMaterialId(Long materialId);

    List<Autorizacion> findByUtpRut(String utpRut);

    List<Autorizacion> findByDecision(String decision);

}
