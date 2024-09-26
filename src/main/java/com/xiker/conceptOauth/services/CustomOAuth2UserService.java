
package com.xiker.conceptOauth.services;

import com.xiker.conceptOauth.model.MiOAuth2User;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Xiker
 */
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest,OAuth2User>{

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
       OAuth2User oAuth2User = new DefaultOAuth2UserService().loadUser(userRequest);
       MiOAuth2User miUsuario = new MiOAuth2User(oAuth2User);
       
       System.out.println(miUsuario);
       System.out.println(miUsuario.getAuthorities());
       
       return miUsuario;
    }
    
}
