package br.com.fatec.modulo1.repository;

import br.com.fatec.modulo1.controller.adapter.PessoaAdapter;
import br.com.fatec.modulo1.entity.Pessoa;
import br.com.fatec.modulo1.repository.client.PessoaMongoRepository;
import br.com.fatec.modulo1.repository.orm.PessoaOrm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {
    private final PessoaMongoRepository mongoRepo;

    public PessoaRepositoryImpl(PessoaMongoRepository mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public List<Pessoa> findAll() {
        return mongoRepo.findAll()
                .stream()
                .map(PessoaAdapter::convertToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        PessoaOrm orm = PessoaAdapter.convertToOrm(pessoa);

        return PessoaAdapter.convertToEntity(mongoRepo.save(orm));

    }

    @Override
    public void delete(String id) {
        try {
            mongoRepo.deleteById(id);
        } catch (Exception e) {
            // Tratamento do erro
        }
    }
}
