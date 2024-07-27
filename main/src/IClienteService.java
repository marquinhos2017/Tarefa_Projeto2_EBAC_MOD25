

public interface IClienteService extends IGenericService<Cliente> {
    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorId(Long cpf);
    //   Boolean salvar(Cliente cliente);
    //  Cliente buscarPorCPF(long cpf);

    //void excluir(long cpf);

//    void alterar(Cliente cliente);
}
