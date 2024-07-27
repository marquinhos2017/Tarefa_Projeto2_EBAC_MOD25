import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDao clienteDao;
    private Cliente cliente;

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        clienteDao = new ClienteDaoMock(); // Utilize a implementação mock para os testes

        cliente = new Cliente();
        cliente.setCpf(1234567890L);
        cliente.setNome("Rodrigo");
        cliente.setCidade("Sao Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(119999999999L);
        clienteDao.cadastrar(cliente);
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

        Boolean retorno = clienteDao.cadastrar(novoCliente);
        Assert.assertTrue("O cliente não foi cadastrado corretamente.", retorno);

        Cliente clienteSalvo = clienteDao.consultar(novoCliente.getCpf());
        Assert.assertNotNull("O cliente salvo não foi encontrado.", clienteSalvo);
        Assert.assertEquals("O nome do cliente salvo não corresponde ao esperado.", "Ana", clienteSalvo.getNome());
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull("O cliente consultado não deve ser nulo.", clienteConsultado);
        Assert.assertEquals("O nome do cliente consultado não corresponde ao esperado.", "Rodrigo", clienteConsultado.getNome());
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());

        Cliente clienteExcluido = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull("O cliente excluído deve ser nulo.", clienteExcluido);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Rodrigo Pires");
        clienteDao.alterar(cliente);

        Cliente clienteAlterado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull("O cliente alterado não deve ser nulo.", clienteAlterado);
        Assert.assertEquals("O nome do cliente alterado não corresponde ao esperado.", "Rodrigo Pires", clienteAlterado.getNome());
    }
}
