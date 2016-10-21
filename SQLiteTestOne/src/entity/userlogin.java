package entity;

public class userlogin {
	private int _id;
	private String name;
	private String password;
	private int loginnum;
	private String logindatatime;
	public userlogin(String name,String password,String string,String logindatatime){
		super();

	this.name=name;
	this.password=password;
	this.loginnum=loginnum;
	this.logindatatime=logindatatime;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLoginnum() {
		return loginnum;
	}
	public void setLoginnum(int loginnum) {
		this.loginnum = loginnum;
	}
	public String getLogindatatime() {
		return logindatatime;
	}
	public void setLogindatatime(String logindatatime) {
		this.logindatatime = logindatatime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}

}
