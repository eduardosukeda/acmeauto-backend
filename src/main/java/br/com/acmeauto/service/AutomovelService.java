package br.com.acmeauto.service;

import br.com.acmeauto.dto.AutomovelDTO;
import br.com.acmeauto.entity.Automovel;

import java.util.List;

public interface AutomovelService {

    public List<AutomovelDTO> findAll();

    public AutomovelDTO findAutomovelByPlaca(String placa);

    public Automovel getAutomovel(String placa);

    public AutomovelDTO create(AutomovelDTO automovelDTO);

    public AutomovelDTO update(AutomovelDTO automovelDTO);

    public void delete(String placa);
}
