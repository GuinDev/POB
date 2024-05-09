package produto.lista;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto Arroz = new Produto();
		
		Arroz.setID(34523);
		Arroz.nome="Arroz";
		Arroz.setSku("0369-72");
		Arroz.descricao="arroz branco";
		Arroz.categoria="grao";
		Arroz.preco=12.90f;
		Arroz.peso= 1.0f;
		Arroz.fabricante="camil";
		Arroz.setCod("12343245");
		
		Produto Pipoca = new Produto();
		
		Pipoca.setID(34523);
		Pipoca.nome="Pipoca";
		Pipoca.setSku("0129-72");
		Pipoca.descricao="milho de pipoca";
		Pipoca.categoria="grao";
		Pipoca.preco=7.50f;
		Pipoca.peso= 0.400f;
		Pipoca.fabricante="Karito";
		Pipoca.setCod("12987645");
		
		Produto Coca = new Produto();
		
		Coca.setID(34523);
		Coca.nome="Coca";
		Coca.setSku("0187-72");
		Coca.descricao="refrigerante de cola";
		Coca.categoria="bebida";
		Coca.preco=5.50f;
		Coca.peso= 0.310f;
		Coca.fabricante="Coca-cola";
		Coca.setCod("129876098");

		ArrayList<String> Produto = new ArrayList<String>();
		 
		Produto.add("Pipoca");
		Produto.add("Coca");
		Produto.add("Arroz");
		
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("escolha uma opcao");
		System.out.println("1-inserir produto");
		System.out.println("2-alterar produto");
		System.out.println("3-deletar produto");
		System.out.println("4-listar produtos");
		System.out.println("5-listar produto");
		
		int num = myObj.nextInt();
		
		
		System.out.println(Arroz.getID());
		System.out.println(Pipoca.getID());
		System.out.println(Coca.getID());
		System.out.println(Produto);
	}

}
