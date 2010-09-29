package br.pensario.connector;

public abstract class NCLAction {

	private String delay;

	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	
	public abstract String parse(int ident);
	public abstract String toString();
	
}