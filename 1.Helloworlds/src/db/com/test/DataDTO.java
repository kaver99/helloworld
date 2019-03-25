package db.com.test;

import java.util.ArrayList;
import java.util.List;

public class DataDTO {
	
	private String username;
    private String password;
    private String name;
    private String phone;
    private String telecom; 
    private String create_date;
    private String access_date;
    private String img_thumbnail;
	private boolean accountNonExpired = true; 
	private boolean accountNonLocked = true; 
	private boolean credentialsNonExpired = true; 
	private boolean enabled = true;
	private String remoteIp;
	private String socialType;
	private String socialId;
	private char term_ServiceYn;
	private char per_InfomationYn;
	private char event_AlarmYn;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelecom() {
		return telecom;
	}
	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getAccess_date() {
		return access_date;
	}
	public void setAccess_date(String access_date) {
		this.access_date = access_date;
	}
	public String getImg_thumbnail() {
		return img_thumbnail;
	}
	public void setImg_thumbnail(String img_thumbnail) {
		this.img_thumbnail = img_thumbnail;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	public String getSocialType() {
		return socialType;
	}
	public void setSocialType(String socialType) {
		this.socialType = socialType;
	}
	public String getSocialId() {
		return socialId;
	}
	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}
	public char getTerm_ServiceYn() {
		return term_ServiceYn;
	}
	public void setTerm_ServiceYn(char term_ServiceYn) {
		this.term_ServiceYn = term_ServiceYn;
	}
	public char getPer_InfomationYn() {
		return per_InfomationYn;
	}
	public void setPer_InfomationYn(char per_InfomationYn) {
		this.per_InfomationYn = per_InfomationYn;
	}
	public char getEvent_AlarmYn() {
		return event_AlarmYn;
	}
	public void setEvent_AlarmYn(char event_AlarmYn) {
		this.event_AlarmYn = event_AlarmYn;
	}
	
	public List<String> dataToString() {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("username : " + username);
		list.add("password : " + password);
		list.add("name : " + name);
		list.add("phone : " + phone);
		list.add("telecom : " + telecom);
		list.add("img_thumbnail : " + img_thumbnail);
		
		return list;
		
	}
	
	
	
}
