package br.com.acmeauto.service;

import br.com.acmeauto.dto.LocacaoRequestDTO;
import br.com.acmeauto.dto.LocacaoResponseDTO;

public interface LocacaoService {
    public LocacaoResponseDTO create(LocacaoRequestDTO locacaoRequestDTO);

    public LocacaoResponseDTO calcular(LocacaoRequestDTO locacaoRequestDTO);
}
