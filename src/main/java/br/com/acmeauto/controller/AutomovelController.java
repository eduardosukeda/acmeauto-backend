package br.com.acmeauto.controller;

import br.com.acmeauto.dto.AutomovelDTO;
import br.com.acmeauto.service.AutomovelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/automoveis")
public class AutomovelController {

    private AutomovelService automovelService;

    public AutomovelController(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }

    @GetMapping
    public ResponseEntity<List<AutomovelDTO>> findAll() {
        return ResponseEntity.ok(automovelService.findAll());
    }

    @GetMapping("{placa}")
    public ResponseEntity<AutomovelDTO> findClienteByCpf(@PathVariable String placa) {
        return ResponseEntity.ok(automovelService.findAutomovelByPlaca(placa));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<AutomovelDTO> create(@RequestBody AutomovelDTO automovelDTO) {
        return ResponseEntity.ok(automovelService.create(automovelDTO));
    }

    @PutMapping()
    public ResponseEntity<AutomovelDTO> update(@RequestBody AutomovelDTO automovelDTO) {
        return ResponseEntity.ok(automovelService.update(automovelDTO));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{placa}")
    public void delete(@PathVariable String placa) {
        automovelService.delete(placa);
    }
}
