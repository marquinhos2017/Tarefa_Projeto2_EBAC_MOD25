import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        IClienteDao dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);

        cliente = new Cliente();
        cliente.setCpf(1234567890L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("Sao Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(119999999999L);
        clienteService.salvar(cliente);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Cliente novoCliente = new Cliente();
        novoCliente.setCpf(1234567891L);
        novoCliente.setNome("Ana");
        novoCliente.setCidade("Rio de Janeiro");
        novoCliente.setEnd("Rua A");
        novoCliente.setEstado("RJ");
        novoCliente.setNumero(20);
        novoCliente.setTel(21999999999L);

        Boolean retorno = clienteService.salvar(novoCliente);
        Assert.assertTrue(retorno);

        Cliente clienteSalvo = clienteService.buscarPorId(novoCliente.getCpf());
        Assert.assertNotNull(clienteSalvo);
        Assert.assertEquals("Ana", clienteSalvo.getNome());
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorId(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
        Assert.assertEquals("Rodrigo", clienteConsultado.getNome());
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());

        Cliente clienteExcluido = clienteService.buscarPorId(cliente.getCpf());
        Assert.assertNull(clienteExcluido);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteService.alterar(cliente);

        Cliente clienteAlterado = clienteService.buscarPorId(cliente.getCpf());
        Assert.assertNotNull(clienteAlterado);
        Assert.assertEquals("Rodrigo Pires", clienteAlterado.getNome());
    }
}
