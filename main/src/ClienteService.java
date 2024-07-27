import java.util.Collection;

public class ClienteService extends GenericService<Cliente> implements IClienteService {

    private final IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao) {
        super();
        this.clienteDao = clienteDao;
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setCidade(entity.getCidade());
        entityCadastrado.setEnd(entity.getEnd());
        entityCadastrado.setEstado(entity.getEstado());
        entityCadastrado.setNumero(entity.getNumero());
        entityCadastrado.setTel(entity.getTel());
    }

    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        return clienteDao.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorId(Long cpf) {
        return clienteDao.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDao.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDao.alterar(cliente);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return clienteDao.buscarTodos();
    }
}
