package service;

import java.util.List;

import model.EasybuyUser;


public interface EasybuyUserService {
	public boolean login(String loginName , String password);
	public boolean register(EasybuyUser user);
	public List<EasybuyUser> allMessage();
	public EasybuyUser getAdminByLoginname(String loginName);
}
