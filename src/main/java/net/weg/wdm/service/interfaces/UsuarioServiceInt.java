package net.weg.wdm.service.interfaces;

import net.weg.wdm.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioServiceInt {

    Usuario buscarUsuarioPorId(Long id);

}
