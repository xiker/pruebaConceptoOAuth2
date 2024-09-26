
package com.xiker.conceptOauth.model;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

/**
 *
 * @author Xiker
 */
public class MiOAuth2User implements OAuth2User{
    private OAuth2User oAuth2User;
   
    
    public MiOAuth2User(OAuth2User oAuth2User){
        this.oAuth2User=oAuth2User;
    }

    @Override
    public <A> A getAttribute(String name) {
        return OAuth2User.super.getAttribute(name);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return Stream.concat(
                 oAuth2User.getAuthorities().stream(),
                 Stream.of(new SimpleGrantedAuthority("ROLE_EXTERNAL"))
         ).collect(Collectors.toList());
    }

    @Override
    public String getName() {
       return oAuth2User.getName();
    }
    
   
    
}
