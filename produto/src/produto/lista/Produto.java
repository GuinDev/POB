package produto.lista;

public class Produto {
	public String nome;
	private int ID;
	private String Cod;
	private String Sku;
	public String descricao;
	public String categoria;
	public float preco;
	public float peso;
	public String fabricante;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getSku() {
		return Sku;
	}
	public void setSku(String sku) {
		Sku = sku;
	}
	
	public String getCod() {
		return Cod;
	}
	public void setCod(String Cod) {
		this.Cod = Cod;
	}
	
	
}
