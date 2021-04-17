package ProjetoMV.ProjetoMV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import dao.RepositorioSorvete;
import entidade.Sorvete;
import util.JpaUtil;


/**
 * Hello world!
 *
 */
public class App 
{
	
	static RepositorioSorvete rs = new RepositorioSorvete();
	
    public static void main( String[] args )
    {
    	EntityManager ent = JpaUtil.getEntityManager();
        Scanner sc = new Scanner(System.in);
		
		int opcao = 0;
		
		while(opcao != 4) {
			
			System.out.println("-------------SISTEMA SORVETERIA-------------");
			System.out.println("1- Inserir Sorvete: ");
			System.out.println("2- Remover Sorvete: ");
			System.out.println("3- Listar Sorvetes: ");
			System.out.println("4- SAIR: ");
			System.out.println("--------------------------------------------");
			opcao = sc.nextInt();
			
			switch(opcao) {
			
				case (1)://INSERIR					
				
					System.out.println("Informe o nome do sorvete: ");
					String nomeI = sc.nextLine();
					sc.nextLine();
					System.out.println("Informe o fabricante: ");
					String fabricanteI = sc.nextLine();
					System.out.println("Informe os ingredientes: ");
					String ingredientesI = sc.nextLine();					
					Sorvete sorvete = new Sorvete();
					sorvete.setNome(nomeI);
					sorvete.setFabricante(fabricanteI);
					sorvete.setIngredientes(ingredientesI);
					rs.inserirSorvete(sorvete);
					System.out.println("Sorvete Inserido");
					
				break;
				
				case (2)://REMOVER
													
					System.out.println("Informe o nome do sorvete que será removido: ");
					String nomeR = sc.nextLine();
					sc.nextLine();
					rs.deletarSorvete(nomeR);				
					
				break;
				
				case (3)://LISTAR
															
					List<Sorvete> lista = new ArrayList<Sorvete>();
						
					lista = rs.listaSorvetes();
						
					System.out.println("---------------SABORES---------------");
						
					for (Sorvete sorvetelista : lista) {
							
						System.out.println("Nome: "+sorvetelista.getNome());
						System.out.println("Fabricante: "+sorvetelista.getFabricante());
						System.out.println("Ingredientes: "+sorvetelista.getIngredientes());
						System.out.println("---------------------------------");
							
					}			
				
				break;
				
				case (4):
					
					System.out.println("Saindo");
					ent.close();
				
				break;
				
				default:
					
					System.out.println("Opção Invalida");
					
				break;
			}
		}
		sc.close();
    }
}
