
public class Client {
	private int clientId;
	private Replica primary;

	public Client() {
	}

	public Client(int clientId) {
		super();
		this.clientId = clientId;
	}

	public int getClientId() {
		return clientId;
	}

	public Replica getPrimary() {
		return primary;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public void setPrimary(Replica primary) {
		this.primary = primary;
	}
	
	public void update(Object value){
		primary.update(clientId,value);
	}
	
	public void receiveAck(int replicaId, int clientId){
		System.out.println("Update Sucessful");
	}
}
