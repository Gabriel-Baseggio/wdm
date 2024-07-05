package net.weg.wdm.service.implementation;

import lombok.AllArgsConstructor;
import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.repository.DispositivoRepository;
import net.weg.wdm.service.interfaces.DispositivoServiceInt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DispositivoServiceImpl implements DispositivoServiceInt {

    private DispositivoRepository dispositivoRepository;

    @Override
    public List<Dispositivo> buscarDispositivosPorId(List<Long> ids) {
        return dispositivoRepository.findAllById(ids);
    }
}
