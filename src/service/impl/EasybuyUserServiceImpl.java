package service.impl;

import java.util.List;

import javax.annotation.Resource;

import mapper.EasybuyUserMapper;
import model.EasybuyUser;
import model.EasybuyUserExample;

import org.springframework.stereotype.Service;

import service.EasybuyUserService;
@Service
public class EasybuyUserServiceImpl implements EasybuyUserService {
	@Resource
	private EasybuyUserMapper easybuyUserMapper;
	
	@Override
	public boolean login(String loginName , String password) {
		EasybuyUserExample easybuyUserExample = new EasybuyUserExample();
		easybuyUserExample.createCriteria().andLoginnameEqualTo(loginName);
		List<EasybuyUser> users = easybuyUserMapper.selectByExample(easybuyUserExample);
		if (users != null && users.size() > 0) {
			for(EasybuyUser u : users){
				if (u.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean register(EasybuyUser user) {
		int result = easybuyUserMapper.insert(user);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public List<EasybuyUser> allMessage() {
		// TODO Auto-generated method stub
		EasybuyUserExample example = new EasybuyUserExample();
		return easybuyUserMapper.selectByExample(example);
	}

	@Override
	public EasybuyUser getAdminByLoginname(String loginName) {
		// TODO Auto-generated method stub
		EasybuyUserExample example = new EasybuyUserExample();
		example.createCriteria().andLoginnameEqualTo(loginName);
		return easybuyUserMapper.selectByExample(example).get(0);
	}

}
