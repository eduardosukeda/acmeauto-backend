package br.com.acmeauto.controller;

import br.com.acmeauto.dto.ClienteDTO;
import br.com.acmeauto.dto.LocacaoRequestDTO;
import br.com.acmeauto.dto.LocacaoResponseDTO;
import br.com.acmeauto.service.LocacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/locacoes")
public class LocacaoController {

    private LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> create(@RequestBody LocacaoRequestDTO locacaoRequestDTO) {
        return ResponseEntity.ok(locacaoService.create(locacaoRequestDTO));
    }

    @PostMapping("/calcular")
    public ResponseEntity<LocacaoResponseDTO> calcular(@RequestBody LocacaoRequestDTO locacaoRequestDTO) {
        return ResponseEntity.ok(locacaoService.calcular(locacaoRequestDTO));
    }
}
