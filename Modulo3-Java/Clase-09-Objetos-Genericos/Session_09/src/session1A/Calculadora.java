package session1A;

public class Calculadora {
	public int valor;

	Calculadora(int valor){
		this.valor=valor;
	}

	@Override
	public String toString() {
		return "valor: "+valor ;
	}

	@Override
	public boolean equals(Object obj) {
		//uso del getClass

		//objeto A es this -- objeto B es obj
		if(obj.getClass() == getClass()) {

			System.out.println("misma tipo clase");
			/*if(this == obj) {
                System.out.println("son objetos iguales");

            }else {
                System.out.println("No objetos iguales");
            }*/


			//instanciamos obj
			Calculadora clb= (Calculadora) obj;

			//comparando sus atributos
			if(this.valor == clb.valor) {
				System.out.println("son atributos iguales");
				return true;
			}else {
				System.out.println("No son atributos iguales");
				return false;
			}


		}else {
			System.out.println("NO son del mismo tipo clase");
		}

		return false;
	}
}
