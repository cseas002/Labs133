public class askisi3 {

    public static void main(String[] args)
    {
        BankVault vault = new BankVault(500, 500, 500);
        int stolen_gold = vault.goldBars;
        vault.goldBars = 0;
        int stolen_bonds = vault.getBonds();
        vault.withdrawBonds(stolen_bonds);
        double stolen_cash = vault.getCash();
        vault.withdrawCash(stolen_cash);
        double deposit_cash = vault.getCash();
        vault.depositCash(-deposit_cash);

        StdOut.println(vault.getBonds());
        StdOut.println(vault.getCash());
        StdOut.println(vault.getGoldBars());
    }

}
