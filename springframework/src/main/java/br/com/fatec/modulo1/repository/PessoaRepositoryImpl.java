package br.com.fatec.modulo1.repository;

import br.com.fatec.modulo1.entity.Pessoa;
import br.com.fatec.modulo1.exception.InternalServerException;
import br.com.fatec.modulo1.repository.adapter.PessoaRepositoryAdapter;
import br.com.fatec.modulo1.repository.client.PessoaMongoRepository;
import br.com.fatec.modulo1.repository.orm.PessoaOrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {
    private static final Logger LOG = LoggerFactory.getLogger(PessoaRepositoryImpl.class);

    private final PessoaMongoRepository mongoRepo;

    public PessoaRepositoryImpl(PessoaMongoRepository mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Page<Pessoa> findAllAtivosTrue(Pageable pageable) {
        try {
            LOG.info("Listando todas as pessoas");
            return mongoRepo.findAllByAtivoTrue(pageable)
                    .map(PessoaRepositoryAdapter::convertToEntity);
        } catch (Exception e) {
            LOG.error("Erro ao listar pessoas: {}; data / hora: {}", e.getMessage(), LocalDateTime.now());
            throw new InternalServerException(e);
        }
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        try {
            LOG.info("Atualizando / criando a pessoa: novo nome={}", pessoa.nome());
            PessoaOrm orm = PessoaRepositoryAdapter.convertToOrm(pessoa);

            return PessoaRepositoryAdapter.convertToEntity(mongoRepo.save(orm));
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
