package session_18;


public class DatosISS {
	private String estado;
	private long timestamp;
	private Posicion posicionIss;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Posicion getPosicionIss() {
		return posicionIss;
	}

	public void setPosicionIss(Posicion posicionIss) {
		this.posicionIss = posicionIss;
	}

	public static class Posicion {
		private double latitud;
		private double longitud;

		public double getLatitud() {
			return latitud;
		}

		public void setLatitud(double latitud) {
			this.latitud = latitud;
		}

		public double getLongitud() {
			return longitud;
		}

		public void setLongitud(double longitud) {
			this.longitud = longitud;
		}
	}
}