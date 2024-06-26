package com.example.library.service.impl;

import com.example.library.entity.UserEntity;
import com.example.library.entity.UserRoleEntity;
import com.example.library.repository.RoleRepository;
import com.example.library.repository.UserRepository;
import com.example.library.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository, UserRoleRepository userRoleRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findAllByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        List<String> roleList = userRoleRepository.findByUserId(user.getId()).stream().map(UserRoleEntity::getRoleId).collect(Collectors.toList());
        List<String> roleName = roleList.stream().map(item->roleRepository.findByRoleId(item).getRoleName()).collect(Collectors.toList());
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(roleName)) {
            for (String role : roleList) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(),
                grantList);
    }
}
