public class ClienteDao extends GenericDAO<Cliente>  implements IClienteDao {
    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }

    public ClienteDao(){
    super();
    }

}
