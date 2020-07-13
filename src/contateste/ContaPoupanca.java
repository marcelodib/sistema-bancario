package contateste;

public class ContaPoupanca extends Conta {
	private double juros;
	
	public ContaPoupanca(String nome, int numero, double saldo, double limiteDeCredito, double juros)
	{
		super(nome,numero,saldo,limiteDeCredito,juros);
		this.juros = juros;
	}
	public void sacar(double saque) throws ExceptionNumeroNegativo
	{
		double saldo;
		saldo = super.getSaldo();
		if((saldo - saque) >= 0)
		{
			super.sacar(saque);
		}
		else
                {
                    throw new  ExceptionNumeroNegativo("Saque recusado");
                }
	}
        public void rendimento()throws ExceptionNumeroNegativo
        {
            double saldo;
            saldo = super.getSaldo();
            super.depositar(saldo *(1 + (juros / 100)));
            super.sacar(saldo);
        }
}
