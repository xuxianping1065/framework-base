package com.framework.common.security.service;

import com.framework.common.security.model.SecurityUser;

public interface UserService {

	public SecurityUser getUserByName(String username);
	
}
