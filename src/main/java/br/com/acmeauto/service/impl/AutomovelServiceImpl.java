package br.com.acmeauto.service.impl;

import br.com.acmeauto.dto.AutomovelDTO;
import br.com.acmeauto.entity.Automovel;
import br.com.acmeauto.repository.AutomovelRepository;
import br.com.acmeauto.service.AutomovelService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutomovelServiceImpl implements AutomovelService {

    private AutomovelRepository automovelRepository;

    public AutomovelServiceImpl(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    @Override
    public List<AutomovelDTO> findAll() {
        List<Automovel> automovelList = automovelRepository.findAll();
        return automovelList.stream().map(AutomovelDTO::new).collect(Collectors.toList());
    }

    @Override
    public AutomovelDTO findAutomovelByPlaca(String placa) {
        Automovel automovel = automovelRepository.findAutomovelByPlaca(placa).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new AutomovelDTO(automovel);
    }

    @Override
    public AutomovelDTO create(AutomovelDTO automovelDTO) {
        boolean isPresentAutomovel = automovelRepository.findAutomovelByPlaca(automovelDTO.getPlaca()).isPresent();

        if (!isPresentAutomovel) {
            Automovel automovel = automovelRepository.save(new Automovel(automovelDTO));
            return new AutomovelDTO(automovel);
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public AutomovelDTO update(AutomovelDTO automovelDTO) {
        Automovel automovel = getAutomovel(automovelDTO.getPlaca());
        automovel.setMarca(automovelDTO.getMarca());
        automovel.setAno(automovelDTO.getAno());
        automovel.setValorDiaria(automovelDTO.getValorDiaria());
        automovel.setDisponivel(automovelDTO.isDisponivel());

        return new AutomovelDTO(automovelRepository.save(automovel));
    }

    @Override
    public void delete(String placa) {
        Automovel automovel = getAutomovel(placa);
        automovelRepository.delete(automovel);
    }

    public Automovel getAutomovel(String placa) {
        return automovelRepository.findAutomovelByPlaca(placa)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
