package br.com.acmeauto.service.impl;

import br.com.acmeauto.dto.ClienteDTO;
import br.com.acmeauto.entity.Cliente;
import br.com.acmeauto.repository.ClienteRepository;
import br.com.acmeauto.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findClienteByCpf(String cpf) {
        Cliente cliente = clienteRepository.findClienteByCpf(cpf).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ClienteDTO(cliente);
    }

    @Override
    public ClienteDTO create(ClienteDTO clienteRequestDTO) {

        boolean isPresentCliente = clienteRepository.findClienteByCpf(clienteRequestDTO.getCpf()).isPresent();

        if (!isPresentCliente) {
            Cliente cliente = clienteRepository.save(new Cliente(clienteRequestDTO));
            return new ClienteDTO(cliente);
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteRequestDTO) {
        Cliente cliente = getCliente(clienteRequestDTO.getCpf());
        cliente.setNome(clienteRequestDTO.getNome());

        return new ClienteDTO(clienteRepository.save(cliente));
    }

    @Override
    public void delete(String cpf) {
        Cliente cliente = getCliente(cpf);
        clienteRepository.delete(cliente);
    }

    private Cliente getCliente(String cpf) {
        return clienteRepository.findClienteByCpf(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
