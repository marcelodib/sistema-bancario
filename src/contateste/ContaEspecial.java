package contateste;
public class ContaEspecial extends Conta {
	
	
	public ContaEspecial(String nome, int numero, double saldo, double limiteDeCredito)
	{
		super(nome,numero,saldo,limiteDeCredito,0);
	}
	public void sacar(double saque) throws ExceptionNumeroNegativo
	{
		double saldo;
		saldo = super.getSaldo();
                double limite;
                limite = super.getLimiteDeCredito();
		if((saldo - saque) >= (limite)*(-1))
		{
			super.sacar(saque);
		}
		else
               {
                  throw new  ExceptionNumeroNegativo("Saque recusado");
               }
	}
}
