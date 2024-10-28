package modelo;

public class Bicicleta extends Vehiculo {
	private String tipoBicicleta;

	public Bicicleta(int numeroRuedas, int cantidadVentanas, String tipoBicicleta) {
		super(numeroRuedas, cantidadVentanas);
		this.tipoBicicleta = tipoBicicleta;
	}

	public String getTipoBicicleta() {
		return tipoBicicleta;
	}

	public void setTipoBicicleta(String tipoBicicleta) {
		this.tipoBicicleta = tipoBicicleta;
	}

	@Override
	public void encender() {
		System.out.println("La bicicleta está lista para usarse (no tiene motor).");
	}

	@Override
	public void apagar() {
		System.out.println("La bicicleta está guardada.");
	}

	@Override
	public String toString() {
		return "Bicicleta{" +
				"tipoBicicleta='" + tipoBicicleta + '\'' +
				", ruedas=" + getNumeroRuedas() +
				", ventanas=" + getCantidadVentanas() +
				'}';
	}
}