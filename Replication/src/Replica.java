import java.util.ArrayList;
import java.util.List;

public class Replica {
	private int replicaId;
	private boolean isPrimary;
	private Object value;
	private Client client;
	private List<Replica> replicas;

	public Replica() {
		replicas = new ArrayList<>();
	}

	public Replica(int replicaId, Client client) {
		super();
		replicas= new ArrayList<>();
		this.replicaId = replicaId;
		this.client = client;
	}

	public void addReplica(Replica replica) {
		replicas.add(replica);
	}

	public void removeReplica(Replica replica) {
		replicas.remove(replica);
	}

	public int getReplicaId() {
		return replicaId;
	}

	public void setReplicaId(int replicaId) {
		this.replicaId = replicaId;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Replica> getReplicas() {
		return replicas;
	}

	public void setReplicas(List<Replica> replicas) {
		this.replicas = replicas;
	}

	public void update(int clientId, Object value) {
		if(isPrimary()){
			setValue(value);
			for (Replica replica : replicas) {
				replica.update(clientId, value);
			}
			client.receiveAck(replicaId, clientId);
		}else{
			setValue(value);
			receiveAck(replicaId, clientId);
		}
	}

	public void receiveAck(int replicaId, int clientId) {
		System.out.println("Value updates , Replica ID"+replicaId +": Value"+value);
	}
}
