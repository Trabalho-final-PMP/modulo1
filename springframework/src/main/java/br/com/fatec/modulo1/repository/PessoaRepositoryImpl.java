package br.com.fatec.modulo1.repository;

import br.com.fatec.modulo1.controller.adapter.PessoaAdapter;
import br.com.fatec.modulo1.entity.Pessoa;
import br.com.fatec.modulo1.exception.InternalServerException;
import br.com.fatec.modulo1.repository.client.PessoaMongoRepository;
import br.com.fatec.modulo1.repository.orm.PessoaOrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {
    private static final Logger LOG = LoggerFactory.getLogger(PessoaRepositoryImpl.class);

    private final PessoaMongoRepository mongoRepo;

    public PessoaRepositoryImpl(PessoaMongoRepository mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public List<Pessoa> findAll() {
        try {
            LOG.info("Listando todas as pessoas");
            return mongoRepo.findAll()
                    .stream()
                    .map(PessoaAdapter::convertToEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Erro ao listar pessoas: {}; data / hora: {}", e.getMessage(), LocalDateTime.now());
            throw new InternalServerException(e);
        }
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        try {
            LOG.info("Atualizando / criando a pessoa: novo nome={}", pessoa.nome());
            PessoaOrm orm = PessoaAdapter.convertToOrm(pessoa);

            return PessoaAdapter.convertToEntity(mongoRepo.save(orm));
        } catch (Exception e) {
            LOG.error("Erro ao cadastrar / atualizar pessoa: {}; data / hora: {}", e.getMessage(), LocalDateTime.now());
            throw new InternalServerException(e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            LOG.info("Removendo pessoa: ID={}", id);
            mongoRepo.deleteById(id);
        } catch (Exception e) {
            LOG.error("Erro ao remover pessoa: {}; data / hora: {}", e.getMessage(), LocalDateTime.now());
            throw new InternalServerException(e);
        }
    }
}
