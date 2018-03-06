
public class RSMManager {

	public static void main(String[] args) {
		
		Client client = new Client(1);
		Replica primary = new Replica(1, client);
		primary.setPrimary(true);
		client.setPrimary(primary);
		Replica backup1 = new Replica(2, client);
		Replica backup2 = new Replica(3, client);
		
		primary.addReplica(backup1);
		primary.addReplica(backup2);
		
		backup1.setReplicas(primary.getReplicas());
		backup2.setReplicas(primary.getReplicas());
		
		
		client.update(5);
		
//		System.out.println(backup1.getValue());
	}

}
