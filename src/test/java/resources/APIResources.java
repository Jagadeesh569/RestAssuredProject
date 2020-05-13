package resources;
public enum APIResources {
	
	CreateUserAPI("/public-api/users"),
	GetUserAPI("/public-api/users"),
	DeleteUserAPI("/public-api/users");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
