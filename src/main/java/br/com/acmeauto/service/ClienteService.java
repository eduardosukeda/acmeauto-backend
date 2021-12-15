package br.com.acmeauto.service;

import br.com.acmeauto.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    public List<ClienteDTO> findAll();

    public ClienteDTO findClienteByCpf(String cpf);

    public ClienteDTO create(ClienteDTO clienteRequestDTO);

    public ClienteDTO update(ClienteDTO clienteRequestDTO);

    public void delete(String cpf);
}
