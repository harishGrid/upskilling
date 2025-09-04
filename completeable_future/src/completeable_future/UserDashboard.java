package completeable_future;

import java.util.concurrent.CompletableFuture;

class UserProfile{
	public Integer userId;
	public String name;
	
	public UserProfile(Integer userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", name=" + name + "]";
	}
}

class UserOrders{
	public Integer userId;
	public Integer orderCount;
	
	public UserOrders(Integer userId, Integer orderCount) {
		super();
		this.userId = userId;
		this.orderCount = orderCount;
	}
	@Override
	public String toString() {
		return "UserOders [userId=" + userId + ", orderCount=" + orderCount + "]";
	}
}

public class UserDashboard {
	public static void main(String[] args) {
		Integer userId=123;
	
		CompletableFuture<UserProfile> profile = CompletableFuture.supplyAsync(()-> fetchUserProfile(userId));
		CompletableFuture<UserOrders> orders = CompletableFuture.supplyAsync(()->fetchUserOrders(userId));
		
		CompletableFuture<String> thenCombine = profile.thenCombine(orders, (p,o)->p+ " "+o);
		System.out.println(thenCombine.join());
	}
	static UserProfile fetchUserProfile(Integer userId) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new UserProfile(userId, "Harish");
	}
	
	static UserOrders fetchUserOrders(Integer userId) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new UserOrders(userId, 5);
	}
}
