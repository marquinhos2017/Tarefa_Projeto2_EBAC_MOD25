import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteDaoMock implements IClienteDao {

    private final Map<Long, Cliente> clientes = new HashMap<>();

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        if (clientes.containsKey(entity.getCpf())) {
            return false; // Cliente já existe
        }
        clientes.put(entity.getCpf(), entity);
        return true;
    }

    @Override
    public void excluir(Long valor) {
        clientes.remove(valor);
    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
        if (clientes.containsKey(entity.getCpf())) {
            clientes.put(entity.getCpf(), entity);
        }
    }

    @Override
    public Cliente consultar(Long valor) {
        return clientes.get(valor);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return clientes.values();
    }
}
