package contateste;

public abstract class Conta {
    private String  nomeDoCorrentista;
	private int numero;
	private double saldo;
	private double limiteDeCredito;
        private double juros;

        public double getJuros() {
            return juros;
        }

        public void setJuros(double juros) {
            this.juros = juros;
        }
	public String getNomeDoCorrentista() {
		return nomeDoCorrentista;
	}
	public void setNomeDoCorrentista(String nomeDoCorrentista) {
		this.nomeDoCorrentista = nomeDoCorrentista;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimiteDeCredito() {
		return limiteDeCredito;
	}
	public void setLimiteDeCredito(double limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}
	
	public  Conta(String nomeDoCorrentista,int numero, double saldo, double limiteDeCredito, double juros)
	{
		this.nomeDoCorrentista = nomeDoCorrentista;
		this.numero = numero;
		this.saldo = saldo;
		this.limiteDeCredito = limiteDeCredito;
                this.juros = juros;
	}
	public  Conta()
	{
		this.nomeDoCorrentista = "Conta Inativa";
		this.numero = 0;
		this.saldo = 0;
		this.limiteDeCredito = 0;
                this.juros = 0;
	}
	public void sacar(double saque)throws ExceptionNumeroNegativo
	{
		this.saldo = this.saldo - saque;
	}
	public void depositar(double deposito) {
		this.saldo = this.saldo + deposito;
	}

        public int validaConta(int numero)
        {
            if(getNumero() == numero)
            {
                return 1;
            }
            return 0;
        }

//    void Rendimento() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
