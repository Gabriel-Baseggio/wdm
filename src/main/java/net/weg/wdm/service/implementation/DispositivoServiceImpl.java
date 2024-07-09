package net.weg.wdm.service.implementation;

import lombok.AllArgsConstructor;
import net.weg.wdm.entity.Dispositivo;
import net.weg.wdm.entity.TipoDispositivo;
import net.weg.wdm.repository.DispositivoRepository;
import net.weg.wdm.service.interfaces.DispositivoServiceInt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class DispositivoServiceImpl implements DispositivoServiceInt {

    private final DispositivoRepository repository;


    private List<Dispositivo> buscarDispositivosPorId(List<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Map<TipoDispositivo, List<Dispositivo>> buscarDispositivosPorIdSeparadosPorTipo(List<Long> ids) {
        List<Dispositivo> dispositivos = buscarDispositivosPorId(ids);

        Map<TipoDispositivo, List<Dispositivo>> dispositivosPorTipo = new HashMap<>();

        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivosPorTipo.containsKey(dispositivo.getTipo())) {
                List<Dispositivo> dispositivosTipo = dispositivosPorTipo.get(dispositivo.getTipo());
                dispositivosTipo.add(dispositivo);
                dispositivosPorTipo.replace(dispositivo.getTipo(), dispositivosTipo);
            } else {
                dispositivosPorTipo.put(dispositivo.getTipo(), List.of(dispositivo));
            }
        }

        return dispositivosPorTipo;
    }

}
