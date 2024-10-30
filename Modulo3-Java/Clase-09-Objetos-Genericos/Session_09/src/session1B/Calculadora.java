package session1B;

public class Calculadora {
	public int numero;

	Calculadora(int numero){
		this.numero=numero;
	}   


	@Override
	public String toString() {
		return "numero: "+numero ;
	}

	@Override
	public boolean equals(Object objB) {

		//          A         B
		//cl1.equals(cl2) 
		//        this       objB

		// comparar clases tipo 

		System.out.println("objeto A "+ getClass().getSimpleName());
		System.out.println("objeto B "+ objB.getClass().getSimpleName());

		if(getClass().getSimpleName()==  objB.getClass().getSimpleName()) {
			//validar atributos

			Calculadora clb = (Calculadora) objB;//castear al objB a calculadora
			if(this.numero== clb.numero) {
				return true;
			}else {
				return false;
			}           
		}
		return false;
	}
}