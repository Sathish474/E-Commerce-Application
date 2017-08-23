public class CustomerControl {
	private Prod_Cust_Reln cbo;
        private String name;

	public CustomerControl(String n){
                name=n;
		cbo = new Prod_Cust_Reln(name);
                cbo.show();
	}
}