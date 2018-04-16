package conversor;

public class Conversor {
	
	private static final Double COTIZACION_PESO=20.5;
	private static final Double COTIZACION_BITCOIN=8350.0;
	
	
	public static Double convertirPesoADolar(Double montoEnpesos) {
		return montoEnpesos / COTIZACION_PESO;
	}
	
	public static Double convertirDolarAPeso(Double montoEnDolares) {
		return montoEnDolares * COTIZACION_PESO;
	}
	
	public static Double convertirDolarABitcoin(Double montoEnDolares) {
		return montoEnDolares / COTIZACION_BITCOIN;
	}
	
	public static Double convertirBitcoinADolar(Double montoEnBitcoins) {
		return montoEnBitcoins * COTIZACION_BITCOIN;
	}

}
