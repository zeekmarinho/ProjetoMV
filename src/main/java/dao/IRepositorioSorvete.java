package dao;

import java.util.List;

import entidade.Sorvete;

public interface IRepositorioSorvete {
	
	public boolean inserirSorvete(Sorvete sorvete);
	public void deletarSorvete(String nome);
	public List<Sorvete> listaSorvetes();

}
