package contateste;

public class ContaSimples extends Conta{
    public ContaSimples(String nome, int numero, double saldo, double limiteDeCredito)
	{
            super(nome,numero,saldo,limiteDeCredito,0);
	}
	public void sacar(double saque)throws ExceptionNumeroNegativo
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
}

