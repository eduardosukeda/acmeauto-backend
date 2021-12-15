package br.com.acmeauto.service.impl;

import br.com.acmeauto.dto.AutomovelDTO;
import br.com.acmeauto.dto.LocacaoRequestDTO;
import br.com.acmeauto.dto.LocacaoResponseDTO;
import br.com.acmeauto.entity.Automovel;
import br.com.acmeauto.entity.Locacao;
import br.com.acmeauto.repository.LocacaoRepository;
import br.com.acmeauto.service.AutomovelService;
import br.com.acmeauto.service.LocacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class LocacaoServiceImpl implements LocacaoService {

    private LocacaoRepository locacaoRepository;
    private AutomovelService automovelService;

    public LocacaoServiceImpl(LocacaoRepository locacaoRepository, AutomovelService automovelService) {
        this.locacaoRepository = locacaoRepository;
        this.automovelService = automovelService;
    }

    @Override
    public LocacaoResponseDTO create(LocacaoRequestDTO locacaoRequestDTO) {
        Automovel automovel = automovelService.getAutomovel(locacaoRequestDTO.getAutomovel().getPlaca());

        if (automovel.isDisponivel()) {
            Locacao locacao = locacaoRepository.save(new Locacao(locacaoRequestDTO));
            AutomovelDTO automovelDTO = new AutomovelDTO(automovel);
            automovelDTO.setDisponivel(false);
            automovelService.update(automovelDTO);
            return new LocacaoResponseDTO(locacao);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED);

        }
    }

    @Override
    public LocacaoResponseDTO calcular(LocacaoRequestDTO locacaoRequestDTO) {
        if (locacaoRequestDTO.getAutomovel().isDisponivel()) {
            double valor = locacaoRequestDTO.getDias() * locacaoRequestDTO.getAutomovel().getValorDiaria();

            if (locacaoRequestDTO.getDias() > 14) {
                valor = valor - (valor * 0.05);
            }
            LocacaoResponseDTO locacaoResponseDTO = new LocacaoResponseDTO(locacaoRequestDTO.getCliente(), locacaoRequestDTO.getAutomovel(), locacaoRequestDTO.getDias(), valor);
            return locacaoResponseDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
