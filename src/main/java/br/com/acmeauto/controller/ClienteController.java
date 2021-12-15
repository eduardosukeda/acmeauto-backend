package br.com.acmeauto.controller;

import br.com.acmeauto.dto.ClienteDTO;
import br.com.acmeauto.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("{cpf}")
    public ResponseEntity<ClienteDTO> findClienteByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clienteService.findClienteByCpf(cpf));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteRequestDTO) {
        return ResponseEntity.ok(clienteService.create(clienteRequestDTO));
    }

    @PutMapping()
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteRequestDTO) {
        return ResponseEntity.ok(clienteService.update(clienteRequestDTO));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{cpf}")
    public void delete(@PathVariable String cpf) {
        clienteService.delete(cpf);
    }
}
